package com.appestados.service.impl;

import com.appestados.message.AppEstadosMessage;
import com.appestados.model.CidadeEntity;
import com.appestados.model.ConfigEntity;
import com.appestados.model.EstadoEntity;
import com.appestados.model.dto.CidadeResponse;
import com.appestados.repository.CidadeRepository;
import com.appestados.repository.ConfigRepository;
import com.appestados.repository.EstadoRepository;
import com.appestados.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeServiceImpl implements CidadeService {


    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ConfigRepository configRepository;

    @Override
    public CidadeResponse incluir(CidadeEntity cidade) {
        try {
            validaCamposObrigatorios(cidade);
            CidadeResponse cidadeResponse = calcularCustoPopulacional(cidadeRepository.save(cidade), false);
            cidadeResponse.setEstado(estadoRepository.findById(cidade.getIdEstado()).get());
            return cidadeResponse;
        } catch (Exception e) {
            throw AppEstadosMessage.badRequest(AppEstadosMessage.ERRO_SALVAR_CIDADE, e.getMessage());
        }
    }

    public void excluir(Integer idCidade) {
        try {
            Optional<CidadeEntity> cidade = cidadeRepository.findById(idCidade);

            if(!cidade.isPresent())
                throw  AppEstadosMessage.badRequest(AppEstadosMessage.CIDADE_INEXISTENTE, idCidade.toString());

            Optional<EstadoEntity> estadoEntity = estadoRepository.findById(cidade.get().getIdEstado());
            if(!estadoEntity.isPresent())
                throw AppEstadosMessage.business(AppEstadosMessage.CIDADE_NAO_EXCLUIR,estadoEntity.get().getNome());

            cidadeRepository.delete(cidade.get());
        } catch (Exception e) {
            throw AppEstadosMessage.badRequest(AppEstadosMessage.ERRO_EXCLUIR_CIDADE, e.getMessage());
        }
    }


    private void validaCamposObrigatorios(CidadeEntity cidade) {

        if(cidade == null){
            throw AppEstadosMessage.business(AppEstadosMessage.CIDADE_INVALIDA);
        }

        if(cidade.getNome() == null || cidade.getNome().isEmpty()) {
            throw AppEstadosMessage.business(AppEstadosMessage.NOME_INVALIDO);
        }

        if(cidade.getIdEstado() == null ) {
            throw AppEstadosMessage.business(AppEstadosMessage.ESTADO_INVALIDO);
        }

        if(cidade.getPopulacao() == null) {
            throw AppEstadosMessage.business(AppEstadosMessage.POPULACAO_INVALIDA);
        }

        CidadeEntity cidadeExistente = cidadeRepository.findByNome(cidade.getNome());

        if(cidadeExistente != null)
            throw AppEstadosMessage.business(AppEstadosMessage.CIDADE_JA_EXISTENTE, cidade.getNome());


    }

    public List<CidadeResponse> listarPorEstado(Integer idEstado, Boolean real){
        Optional<EstadoEntity> estadoEntity = estadoRepository.findById(idEstado);
        if(!estadoEntity.isPresent())
            throw  AppEstadosMessage.badRequest(AppEstadosMessage.ESTADO_INEXISTENTE, idEstado.toString());

        List<CidadeEntity> cidadeEntities = cidadeRepository.findByIdEstado(estadoEntity.get().getId());

        List<CidadeResponse> cidadeResponses = cidadeEntities.stream().map(cidadeEntity -> calcularCustoPopulacional(cidadeEntity, real)).collect(Collectors.toList());

        return cidadeResponses;

    }

    private CidadeResponse calcularCustoPopulacional (CidadeEntity cidadeEntity, Boolean custoEmReal){
        Float custoPopulacional = null;

        List<ConfigEntity> configEntities = configRepository.findAll();

        if(configEntities != null && !configEntities.isEmpty()) {
            ConfigEntity configEntity = configEntities.stream().findFirst().get();


             custoPopulacional = (cidadeEntity.getPopulacao() <= configEntity.getCorte()) ?
                    cidadeEntity.getPopulacao() * configEntity.getCustoOperacional() :
                    (configEntity.getCorte() * configEntity.getCustoOperacional()) + ((cidadeEntity.getPopulacao() - configEntity.getCorte()) * (configEntity.getCustoOperacional() - (configEntity.getCustoOperacional() * configEntity.getDesconto() / 100)));


        }

        Float custoPopulacionalReal = (custoEmReal && custoPopulacional != null)? custoPopulacional * 5.7F: null;

        return CidadeResponse.builder().id(cidadeEntity.getId())
                .populacao(cidadeEntity.getPopulacao())
                .nome(cidadeEntity.getNome())
                .custoPopulacional((custoPopulacional != null )? custoPopulacional.longValue():null)
                .custoPopulacionalEmReal((custoPopulacionalReal!=null)?custoPopulacionalReal.longValue():null)
                .build();
    }

}

package com.appestados.service.impl;

import com.appestados.message.AppEstadosMessage;
import com.appestados.model.CidadeEntity;
import com.appestados.model.ConfigEntity;
import com.appestados.model.EstadoEntity;
import com.appestados.model.dto.CidadeResponse;
import com.appestados.model.dto.EstadoResponse;
import com.appestados.repository.CidadeRepository;
import com.appestados.repository.ConfigRepository;
import com.appestados.repository.EstadoRepository;
import com.appestados.service.CidadeService;
import com.appestados.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeServiceImpl cidadeService;

    @Override
    public List<EstadoEntity> listar() {
        return estadoRepository.findAll();
    }

    @Override
    public List<EstadoResponse> listarComCustoOperacional() {
        List<EstadoResponse> estadoResponseList = new ArrayList<>();
        List<EstadoEntity> estadoEntities = estadoRepository.findAll();

        estadoEntities.forEach(estadoEntity -> {
            Long custoPopulacional = null;
            Long custoPopulacionalReal = null;
            List<CidadeResponse> cidadeResponseList = cidadeService.listarPorEstado(estadoEntity.getId(), true);

            if(!cidadeResponseList.isEmpty()) {
                custoPopulacional = cidadeResponseList.stream().filter(cidadeResponse -> cidadeResponse.getCustoPopulacional() != null ).map(CidadeResponse::getCustoPopulacional).reduce(0L, (x, y) -> x + y);
                custoPopulacionalReal = cidadeResponseList.stream().filter(cidadeResponse -> cidadeResponse.getCustoPopulacionalEmReal() != null ).map(CidadeResponse::getCustoPopulacionalEmReal).reduce(0L, Long::sum);
            }

            estadoResponseList.add(EstadoResponse.builder().nome(estadoEntity.getNome()).custoPopulacional(custoPopulacional).custoPopulacionalEmReal(custoPopulacionalReal).build());

        });

        return  estadoResponseList;
    }

}

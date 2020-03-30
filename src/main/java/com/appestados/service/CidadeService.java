package com.appestados.service;

import com.appestados.model.CidadeEntity;
import com.appestados.model.EstadoEntity;
import com.appestados.model.dto.CidadeResponse;
import io.swagger.models.auth.In;

import java.util.List;

public interface CidadeService {
    CidadeResponse incluir(CidadeEntity cidadeEntity);
    void excluir(Integer idCidade);
    List<CidadeResponse> listarPorEstado(Integer idEstado, Boolean real);
}

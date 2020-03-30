package com.appestados.controller.mapper;

import com.appestados.model.CidadeEntity;
import com.appestados.model.EstadoEntity;
import com.appestados.model.dto.CidadeRequest;
import com.appestados.model.dto.CidadeResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CidadeEntityMapper {
    private CidadeEntityMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static CidadeEntity from (CidadeRequest cidadeRequest) {
        return CidadeEntity.builder().nome(cidadeRequest.getNome())
                .idEstado(cidadeRequest.getIdEstado())
                .populacao(cidadeRequest.getPopulacao())
                .build();

    }



}

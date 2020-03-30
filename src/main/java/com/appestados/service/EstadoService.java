package com.appestados.service;

import com.appestados.model.CidadeEntity;
import com.appestados.model.EstadoEntity;
import com.appestados.model.dto.CidadeResponse;
import com.appestados.model.dto.EstadoResponse;

import java.util.List;

public interface EstadoService {
    List<EstadoEntity> listar();
    List<EstadoResponse> listarComCustoOperacional ();
}

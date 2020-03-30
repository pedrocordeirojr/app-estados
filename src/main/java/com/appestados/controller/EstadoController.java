package com.appestados.controller;

import com.appestados.model.EstadoEntity;
import com.appestados.model.dto.EstadoResponse;
import com.appestados.service.impl.EstadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/estado")
public class EstadoController {
    @Autowired
    private EstadoServiceImpl estadoService;

    @GetMapping
    public List<EstadoEntity> listar(){
        return estadoService.listar();
    }

    @GetMapping("/custo")
    public List<EstadoResponse> listarComCustoPopulacional(){
        return estadoService.listarComCustoOperacional();
    }
}

package com.appestados.controller;

import com.appestados.controller.mapper.CidadeEntityMapper;
import com.appestados.model.dto.CidadeRequest;
import com.appestados.model.dto.CidadeResponse;
import com.appestados.service.impl.CidadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/cidade")
public class CidadeController {
    @Autowired
    private CidadeServiceImpl contasAPagarService;

    @PostMapping
    public CidadeResponse incluirCidade(@RequestBody CidadeRequest cidadeRequest){
        return
                contasAPagarService.incluir(
                        CidadeEntityMapper.from(cidadeRequest)
                );
    }

    @DeleteMapping("/{cidadeId}")
    public void excluirCidade(@PathVariable("cidadeId") Integer cidadeId){
         contasAPagarService.excluir(cidadeId);
    }


}

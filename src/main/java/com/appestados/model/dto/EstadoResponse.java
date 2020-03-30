package com.appestados.model.dto;

import com.appestados.model.EstadoEntity;
import lombok.*;

import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoResponse {

    private String nome;
    private Long custoPopulacional;
    private Long custoPopulacionalEmReal;
}

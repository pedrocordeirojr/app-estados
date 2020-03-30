package com.appestados.model.dto;

import com.appestados.model.EstadoEntity;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CidadeResponse {
    private Integer id;
    private String nome;
    private EstadoEntity estado;
    private Integer populacao;
    private Float custoPopulacional;
    private Float custoPopulacionalEmReal;
}

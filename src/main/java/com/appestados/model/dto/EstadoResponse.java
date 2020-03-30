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
    private Integer id;
    private String nome;
    private Blob bandeira;
}

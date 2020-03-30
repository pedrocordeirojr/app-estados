package com.appestados.model.dto;

import com.appestados.model.EstadoEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CidadeRequest {
    private String nome;
    private Integer populacao;
    private Integer idEstado;
}

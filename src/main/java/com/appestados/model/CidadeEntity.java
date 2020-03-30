package com.appestados.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cidades")
@Builder
public class CidadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    @NotNull
    private String nome;

    @Column(name="estado")
    @NotNull
    private Integer idEstado;

    @Column(name="populacao")
    @NotNull
    private Integer populacao;


}


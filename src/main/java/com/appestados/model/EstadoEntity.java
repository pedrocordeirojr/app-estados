package com.appestados.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="estados")
@Builder
public class EstadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    @NotNull
    private String nome;

    @Column(name="bandeira")
    @NotNull
    private Blob bandeira;

    @Column(name="comboDefault")
    @NotNull
    private Boolean comboDefault;

    @Column(name="exclusao")
    @NotNull
    private Boolean exclusao;

}


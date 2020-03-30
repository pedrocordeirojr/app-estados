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
@Table(name="configuracao")
@Builder
public class ConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="custoOperacional")
    @NotNull
    private Float custoOperacional;

    @Column(name="corte")
    @NotNull
    private Integer corte;

    @Column(name="desconto")
    @NotNull
    private Float desconto;

}


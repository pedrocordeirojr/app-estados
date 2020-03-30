package com.appestados.repository;

import com.appestados.model.CidadeEntity;
import com.appestados.model.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntity, Integer> {
    List<CidadeEntity> findByIdEstado(Integer idEstado);
    CidadeEntity findByNome(String nome);
}

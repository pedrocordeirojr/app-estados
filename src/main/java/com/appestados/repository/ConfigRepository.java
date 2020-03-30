package com.appestados.repository;

import com.appestados.model.ConfigEntity;
import com.appestados.model.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<ConfigEntity, Integer> {
}

package com.willbsouza.desafiopubfuture.repository;

import com.willbsouza.desafiopubfuture.entities.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Integer> {
}

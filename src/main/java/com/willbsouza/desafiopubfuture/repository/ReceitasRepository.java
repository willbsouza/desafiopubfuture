package com.willbsouza.desafiopubfuture.repository;

import com.willbsouza.desafiopubfuture.entities.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Integer> {
}

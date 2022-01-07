package com.willbsouza.desafiopubfuture.repository;

import com.willbsouza.desafiopubfuture.entities.Contas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends JpaRepository<Contas, Integer> {
}

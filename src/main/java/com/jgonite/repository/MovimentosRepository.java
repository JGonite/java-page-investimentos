package com.jgonite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgonite.model.MovimentoAcoesModel;

@Repository
public interface MovimentosRepository extends JpaRepository<MovimentoAcoesModel, Long> {
		
}

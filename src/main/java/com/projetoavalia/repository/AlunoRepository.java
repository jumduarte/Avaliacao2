package com.projetoavalia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoavalia.entities.Aluno;

	public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	}

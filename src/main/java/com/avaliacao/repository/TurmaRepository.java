package com.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	List<Turma> findByNome(String nome);
	List<Turma> findByDescricao(String descricao);
	List<Turma> findByNomeAndDescricao(String nome, String descricao);
}
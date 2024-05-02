package com.avaliacao.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avaliacao.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	List<Aluno> findByCidade(String cidade);
	//List<Aluno> findByNome(String nome);
	List<Aluno> findByRenda(BigDecimal renda);
	List<Aluno> findByRa(String ra);
	List<Aluno> findByCidadeAndRenda(String cidade, BigDecimal renda);
	
	//Buscar todos os alunos com nome "xxxx"
	@Query("SELECT a FROM Aluno a WHERE a.nome = nome")
	List<Aluno> findByNome(@Param("nome") String nome);
	@Query("SELECT a FROM Aluno a WHERE a.nomeCompleto LIKE nomeCompleto")
	List<Aluno> findByNomeLike(@Param("nomeCompleto") String nomeCompleto);
	//Buscar todos os alunos de uma determinada turma
	@Query("SELECT a FROM Aluno a JOIN a.turma WHERE t.id = turmaId")
	List<Aluno> findByTurmaId(@Param("turmaId") Long turmaId);

}
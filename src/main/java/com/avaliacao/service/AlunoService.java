package com.avaliacao.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.entities.Aluno;
import com.avaliacao.repository.AlunoRepository;

@Service
public class AlunoService {

	private final AlunoRepository alunoRepository;

	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public List<Aluno> buscaTodosAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno buscaAlunoPeloId(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElse(null);
	}

	public Aluno salvaAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno alterarAluno(Long id, Aluno alterarAluno) {
		Optional<Aluno> existeAluno = alunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alterarAluno.setId(id);
			return alunoRepository.save(alterarAluno);
		}
		return null;
	}

	public boolean apagarAluno(Long id) {
		Optional<Aluno> existeAluno = alunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
	//Query Metod
	public List<Aluno> buscarAlunosPorCidade(String cidade) {
		return alunoRepository.findByCidade(cidade);
	}
	public List<Aluno> buscarAlunosPorNome(String nome) {
		return alunoRepository.findByNome(nome);
	}
	public List<Aluno> buscarAlunosPorRenda(BigDecimal renda) {
		return alunoRepository.findByRenda(renda);
	}
	public List<Aluno> buscarAlunosPorRa(String ra) {
		return alunoRepository.findByRa(ra);
	}
	//public List<Aluno> buscarAlunosPorCidadeAndRenda(String cidade, String renda) {
	//return alunoRepository.findByCidadeAndRenda(String cidade, String renda);
	//}

	//@query
	public List<Aluno> findByNome(String nome) {
		return alunoRepository.findByNome(nome);
	}
	
	public List<Aluno> findByNomeCompletoLike(String nomeCompleto) {
		return alunoRepository.findByNomeLike(nomeCompleto);
	}
	
	public List<Aluno> findByTurmaId(Long turmaId) {
		return alunoRepository.findByTurmaId(turmaId);
	}

}


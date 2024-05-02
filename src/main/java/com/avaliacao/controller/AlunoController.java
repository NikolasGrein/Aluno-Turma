package com.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.entities.Aluno;
import com.avaliacao.service.AlunoService;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable long id) {
        Aluno aluno = alunoService.buscaAlunoPeloId(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> buscaTodasAlunosControl() {
        List<Aluno> alunos = alunoService.buscaTodosAlunos();
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody Aluno aluno) {
        Aluno salvaAluno = alunoService.salvaAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> alteraAlunoControl(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alteraAluno = alunoService.alterarAluno(id, aluno);
        if (alteraAluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id) {
        boolean apagar = alunoService.apagarAluno(id);
        if (apagar) {
            return ResponseEntity.ok().body("A Aluno foi excluída com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Query Method
    @GetMapping("/cidade/(cidade)")
    public ResponseEntity<List<Aluno>> buscarAlunoPorCidade(@PathVariable String cidade) {
    	List<Aluno> aluno = alunoService.buscarAlunosPorCidade(cidade);
    	return ResponseEntity.ok(aluno);
    }
    @GetMapping("/nome/(nome)")
    public ResponseEntity<List<Aluno>> buscarAlunoPorNome(@PathVariable String nome) {
    	List<Aluno> aluno = alunoService.buscarAlunosPorNome(nome);
    	return ResponseEntity.ok(aluno);
    }
    @GetMapping("/renda/(renda)")
    public ResponseEntity<List<Aluno>> buscarAlunoPorRenda(@PathVariable String renda) {
    	List<Aluno> aluno = alunoService.buscarAlunosPorCidade(renda);
    	return ResponseEntity.ok(aluno);
    }
    @GetMapping("/ra/(ra)")
    public ResponseEntity<List<Aluno>> buscarAlunoPorRa(@PathVariable String ra) {
    	List<Aluno> aluno = alunoService.buscarAlunosPorNome(ra);
    	return ResponseEntity.ok(aluno);
    }
    
	//@query
	@GetMapping("/nome/{nome}")
	public List<Aluno> findAlunosPorNome(@PathVariable String nome) {
		return alunoService.findByNome(nome);
	}
	
	@GetMapping("/nome-completo/{nomeCompleto}")
	public List<Aluno> findAlunosPorNomeCompletoLike(@PathVariable String nomeCompleto) {
		return alunoService.findByNomeCompletoLike(nomeCompleto);
	}
	
	//@query
		@GetMapping("/turma/{turmaId}")
		public List<Aluno> findAlunosPorTurma(@PathVariable Long turmaId) {
			return alunoService.findByTurmaId(turmaId);
		}
}

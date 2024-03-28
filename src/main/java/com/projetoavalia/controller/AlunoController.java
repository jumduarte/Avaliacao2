package com.projetoavalia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoavalia.entities.Aluno;
import com.projetoavalia.services.AlunoService;


@RestController 
@RequestMapping("/Aluno") 

public class AlunoController {
	private final AlunoService AlunoService; 

	@Autowired 
	public AlunoController(AlunoService AlunoService) { 
		this.AlunoService = AlunoService; 

	} 

	@GetMapping("/{id}") 
	public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable Long id){ 
		Aluno aluno = AlunoService.getAlunoById(id); 
		if (aluno != null) { 
			return ResponseEntity.ok(aluno); 
		} 
		else { 

			return ResponseEntity.notFound().build(); 
		} 
	} 
	@GetMapping("/")
	public ResponseEntity<List<Aluno>> buscaTodosAlunoControl(){ 
		List<Aluno> aluno = AlunoService.getAllAlunos(); 
		return ResponseEntity.ok(aluno); 

	} 


	@PostMapping("/") 
	public ResponseEntity<Aluno> salvaAlunosControl(@RequestBody @Validated Aluno aluno){ 
		Aluno salvaAluno = AlunoService.salvarAluno(aluno); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno); 

	} 



	@PutMapping("/{id}") 
	public ResponseEntity<Aluno> alteraAlunosControl(@PathVariable Long id, @RequestBody @Validated Aluno aluno){ 
		Aluno alteraAluno = AlunoService.updateAluno(id, aluno); 
		if (alteraAluno != null) { 
			return ResponseEntity.ok(aluno); 
		} 
		else { 

			return ResponseEntity.notFound().build(); 

		} 

	} 

	@DeleteMapping("/{id}") 
	public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id){ 
		boolean apagar = AlunoService.deleteAluno(id); 
		if(apagar) { 

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 

		} 
		else {

			return ResponseEntity.notFound().build(); 

		} 

	} 
} 


package com.athenas.appback.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.athenas.appback.dtos.PessoaDto;
import com.athenas.appback.entities.Pessoa;
import com.athenas.appback.services.PessoaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody PessoaDto pessoaDto) {
		var pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        service.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso!");
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody PessoaDto pessoaDto) {
		Optional<Pessoa> pessoaOptional = service.findById(id);
		if(!pessoaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não existente");
		}
		Pessoa pessoa = pessoaOptional.get();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        service.save(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		Optional<Pessoa> pessoaOptional = service.findById(id);
		if(!pessoaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não existente");
		}
		service.delete(pessoaOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Pessoa excluida com sucesso.");
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> find(@PathVariable(value = "id") Long id) {
		Optional<Pessoa> pessoaOptional = service.findById(id);
		if(!pessoaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não existente");
		}
		return ResponseEntity.status(HttpStatus.OK).body(List.of(pessoaOptional.get()));
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<Pessoa> pessoas = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(pessoas);
	}
	
	@GetMapping(value = "/{id}/pesoideal")
	public ResponseEntity<Object> findPesoIdeal(@PathVariable(value = "id") Long id) {
		Optional<Pessoa> pessoaOptional = service.findById(id);
		if(!pessoaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não existente");
		}
		return ResponseEntity.status(HttpStatus.OK).body(pessoaOptional.get().calcularPesoIdeal());
	}
	
	@GetMapping(value = "/teste")
	public ResponseEntity<Object> teste() {
		return ResponseEntity.status(HttpStatus.OK).body("Aplicacao funcionando");
	}
}

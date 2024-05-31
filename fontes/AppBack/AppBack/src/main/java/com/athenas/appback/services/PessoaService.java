package com.athenas.appback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.athenas.appback.entities.Pessoa;
import com.athenas.appback.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}

	public Pessoa save(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public Optional<Pessoa> findById(Long id) {
		return repository.findById(id);
	}

	public void delete(Pessoa pessoa) {
		repository.delete(pessoa);
	}
}

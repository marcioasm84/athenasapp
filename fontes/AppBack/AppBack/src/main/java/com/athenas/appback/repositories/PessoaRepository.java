package com.athenas.appback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.athenas.appback.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
}

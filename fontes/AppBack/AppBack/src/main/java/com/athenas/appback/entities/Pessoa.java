package com.athenas.appback.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Márcio
 * 
*/
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	@Column
	private LocalDate dataNascimento;
	@Column
	private String cpf;	
	@Column(length = 1)
	private String sexo;
	@Column
	private Double altura;
	@Column
	private Double peso;

	public Pessoa() {
		
	}
	
	public Pessoa(String pNome, LocalDate pData, String pCpf, String pSexo, Double pAltura, Double pPeso) {
		this.nome = pNome;
		this.dataNascimento = pData;
		this.cpf = pCpf;
		this.sexo = pSexo;
		this.altura = pAltura;
		this.peso = pPeso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Double calcularPesoIdeal() {		
		if(this.sexo.equals("M")) {
			return (72.7 * this.altura) - 58;
		}
		if(this.sexo.equals("F")) {
			return (62.1 * this.altura) - 44.7;
		}
		return null;
	}
}

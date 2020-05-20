package com.qintess.caicaieventos.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Papel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private Integer nivel;
	
	@Column
	private String atribuicao;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JsonIgnore
//	private Cliente cliente;

	@OneToMany(cascade = CascadeType.ALL
			  ,mappedBy = "papel"
			  ,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<Cliente> clientes = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getAtribuicao() {
		return atribuicao;
	}

	public void setAtribuicao(String atribuicao) {
		this.atribuicao = atribuicao;
	}
	
	
	
	
}

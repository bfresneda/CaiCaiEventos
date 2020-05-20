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

@Entity
public class CasaDeShow {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(nullable = false)
	private int id;
	
//	@Column(nullable = false)
	private String nome;
	
//	@Column(nullable = false)
	private String logradouro;
	
//	@Column(nullable = false)
	private int numero;
	
//	@Column(nullable = false)
	private String bairro;
	
//	@Column(nullable = false)
	private String cidade;
	
//	@Column(nullable = false)
	private String estado;
	
//	@Column(nullable = false)
	private int capacidadeTotal;
	
	@Column(columnDefinition="bytea")
	private byte[] imagemCasadeShow;

	@OneToMany(cascade = CascadeType.ALL
			   ,orphanRemoval = true
			   ,mappedBy = "casaDeShow")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<Evento> listaEventos = new ArrayList<>();

	
	
	public CasaDeShow() {
	}

//	@Override 
//	
//	public String toString() {
//		return "CasaDeShow [id=" + id + ", nome=" + nome + ", logradouro=" + logradouro + ", numero=" + numero
//				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", capacidadeTotal="
//				+ capacidadeTotal + ", imagemCasadeShow=" + Arrays.toString(imagemCasadeShow) + "]";
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getCapacidadeTotal() {
		return capacidadeTotal;
	}


	public void setCapacidadeTotal(int capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}

	
	public byte[] getImagemCasadeShow() {
		return imagemCasadeShow;
	}


	public void setImagemCasadeShow(byte[] imagemCasadeShow) {
		this.imagemCasadeShow = imagemCasadeShow;
	}

	public List<Evento> getListaEventos() {
		return listaEventos;
	}
	
	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	
}

package com.qintess.caicaieventos.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evento{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private CasaDeShow casaDeShow;
	
	@OneToMany(cascade = CascadeType.ALL
			,mappedBy = "evento"
			,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	List<ComprarIngresso> listaIngressos = new ArrayList<>();
	
	private String nome;
	
	private String descricao;
	
	private String data;
		
	private int quantidadeIngressos;

	private double preco;
	
	private int quantidadeIngressosDisponiveis;
	
	
	@Column(columnDefinition="bytea")
	private byte[] imagemEvento;
	
	@Transient // esse campo nao será persistido pelo hibernate
	private String imagemEncoded;
	
	public Evento() {
	}
	
	public Evento(String nome, int quantidadeIngressosDisponiveis) {
		super();
		this.nome = nome;
		this.quantidadeIngressosDisponiveis = quantidadeIngressosDisponiveis;
	}


//	@Override
//	public String toString() {
//		return "Evento [id=" + id + ", casaDeShow=" + casaDeShow + ", listaIngressos=" + listaIngressos + ", nome="
//				+ nome + ", descricao=" + descricao + ", data=" + data + ", quantidadeIngressos=" + quantidadeIngressos
//				+ ", preco=" + preco + ", quantidadeIngressosDisponiveis=" + quantidadeIngressosDisponiveis + "]";
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQuantidadeIngressos() {
		return quantidadeIngressos;
	}

	public void setQuantidadeIngressos(int quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeIngressosDisponiveis() {
		return quantidadeIngressosDisponiveis;
	}

	public void setQuantidadeIngressosDisponiveis(int quantidadeIngressosDisponiveis) {
		this.quantidadeIngressosDisponiveis = quantidadeIngressosDisponiveis;
	}

	public List<ComprarIngresso> getListaIngressos() {
		return listaIngressos;
	}

	public void setListaIngressos(List<ComprarIngresso> listaIngressos) {
		this.listaIngressos = listaIngressos;
	}

	public CasaDeShow getCasaDeShow() {
		return casaDeShow;
	}

	public void setCasaDeShow(CasaDeShow casaDeShow) {
		this.casaDeShow = casaDeShow;
	}

	
	public byte[] getImagemEvento() {
		return imagemEvento;
	}

	public void setImagemEvento(byte[] imagemEvento) {
		this.imagemEvento = imagemEvento;
	}

	public String getImagemEncoded() {
		return imagemEncoded;
	}

	public void setImagemEncoded(String imagemEncoded) {
		this.imagemEncoded = imagemEncoded;
	}
	
	
	
}

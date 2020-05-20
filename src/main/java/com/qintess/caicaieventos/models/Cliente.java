package com.qintess.caicaieventos.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Column(nullable = false)
	private String nome;

//	@Column(nullable = false)
	private String email;

//	@Column(nullable = false)
	private String senha;

//	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtNascimento;
	
	@OneToMany(cascade = CascadeType.ALL
				,mappedBy = "cliente"
				,orphanRemoval = true
				,fetch = FetchType.EAGER
				)
	private List<ComprarIngresso> listaIngressos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Papel papel;
	
	
//	@OneToMany(cascade = CascadeType.ALL
//			  ,mappedBy = "cliente"
//			  ,orphanRemoval = true)
//	@LazyCollection(LazyCollectionOption.FALSE)
//	private List<Papel> papeis = new ArrayList<>();

	
	public Cliente() {
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", listaIngressos="
				+ listaIngressos + "]";
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public List<ComprarIngresso> getListaIngressos() {
		return listaIngressos;
	}

	public void setListaIngressos(List<ComprarIngresso> listaIngressos) {
		this.listaIngressos = listaIngressos;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}


	
}

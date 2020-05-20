package com.qintess.caicaieventos.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ComprarIngresso {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Evento evento;
	
	
	private double preco;
	
	private int quantidade;

	public ComprarIngresso() {
	}
	
//	@Override
//	public String toString() {
//		return "CompraIngresso [cliente=" + cliente + ", evento=" + evento + ", id=" + id + ", preco=" + preco
//				+ ", quantidade=" + quantidade + "]";
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}

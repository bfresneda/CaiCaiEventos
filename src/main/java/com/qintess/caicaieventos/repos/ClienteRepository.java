package com.qintess.caicaieventos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.caicaieventos.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	public Cliente findById(int id);
	
	public Cliente findByNomeContaining(String nome);
	
	public void deleteById(int id);
	
	
}

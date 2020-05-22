package com.qintess.caicaieventos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.caicaieventos.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{ // ele recebe o id por meio do objeto Integer
	
	
	public Evento findByNomeContaining(String nome);  // é obrigatório escrever findBy para que o spring entenda

	public Evento findById(int id);	
	
	public void deleteById(int id);
	
	
}

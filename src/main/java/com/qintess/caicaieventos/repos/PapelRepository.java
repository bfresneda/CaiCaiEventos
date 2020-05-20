package com.qintess.caicaieventos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.caicaieventos.models.Papel;

public interface PapelRepository extends JpaRepository<Papel, Integer> {
	
	public Papel findById(int id);
	
	public void deleteById(int id);
	
}

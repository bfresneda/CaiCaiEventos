package com.qintess.caicaieventos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.caicaieventos.models.ComprarIngresso;

public interface ComprarIngressoRepository extends JpaRepository<ComprarIngresso, Integer> {
	
	public ComprarIngresso findById(int id);
	
	public void deleteById(int id);
	
}

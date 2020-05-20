package com.qintess.caicaieventos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.caicaieventos.models.CasaDeShow;

public interface CasaDeShowRepository extends JpaRepository<CasaDeShow, Integer>{
	
	public CasaDeShow findById(int id);
	
	public CasaDeShow findByNomeContaining(String nome);
	
	public void deleteById(int id);
}

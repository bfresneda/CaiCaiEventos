package com.qintess.caicaieventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.caicaieventos.models.CasaDeShow;
import com.qintess.caicaieventos.repos.CasaDeShowRepository;

@Service
public class CasaDeShowService {
	
	@Autowired
	private CasaDeShowRepository casaDeShowRepository;
	
	public CasaDeShow salvar(CasaDeShow casaDeShow) {
		return casaDeShowRepository.save(casaDeShow);
	}
	
	public List<CasaDeShow> buscaTodos(){
		return this.casaDeShowRepository.findAll();
	}
	
	public CasaDeShow buscarPorNome(String nome) {
		return casaDeShowRepository.findByNomeContaining(nome);
	}
	
	public Optional<CasaDeShow> buscarPorId(Integer id){
		return casaDeShowRepository.findById(id);
	}
	
	public void deletarPorId(Integer id) {
		casaDeShowRepository.deleteById(id);
	}

}

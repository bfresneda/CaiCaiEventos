package com.qintess.caicaieventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.caicaieventos.models.ComprarIngresso;
import com.qintess.caicaieventos.repos.ComprarIngressoRepository;

@Service
public class ComprarIngressoService {
	
	@Autowired
	private ComprarIngressoRepository comprarIngressoRepository;
	
	public ComprarIngresso salvar(ComprarIngresso comprarIngresso) {
		return comprarIngressoRepository.save(comprarIngresso);
	}
	
	public List<ComprarIngresso> buscarTodos(){
		return comprarIngressoRepository.findAll();
	}
	
	
	public Optional<ComprarIngresso> buscarPorId(Integer id){
		return comprarIngressoRepository.findById(id);
	}
	
	
	public void deletarPorId(Integer id) {
		comprarIngressoRepository.deleteById(id);
	}
	
	public long ContarVendidos() {
		return comprarIngressoRepository.count();

	}
	
}

package com.qintess.caicaieventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.caicaieventos.models.Papel;
import com.qintess.caicaieventos.repos.PapelRepository;

@Service
public class PapelService {

	@Autowired
	private PapelRepository papelRepository;
	
	public Papel salvar(Papel papel) {
		return papelRepository.save(papel);
	}
	
	public List<Papel> buscarTodos(){
		return papelRepository.findAll();
	}

	public Optional<Papel> buscarPorId(Integer id){
		return papelRepository.findById(id);
	}

	public void deletarPorId(Integer id) {
		papelRepository.deleteById(id);
	}

}

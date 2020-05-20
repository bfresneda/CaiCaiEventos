package com.qintess.caicaieventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.caicaieventos.models.Evento;
import com.qintess.caicaieventos.repos.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public Evento salvar(Evento evento) {
		return eventoRepository.save(evento);
	}

	public List<Evento> buscarTodos(){
		return eventoRepository.findAll(); // nao recebe argumentos
	}
	
	public Evento buscarPorNome(String nome) {
		return eventoRepository.findByNomeContaining(nome); // ele esta chamando o metodo do repository
	}
	
	public Optional<Evento> buscarPorId(Integer id) {
		return eventoRepository.findById(id);
	}
	
	public void deletarPorId(Integer id){
		eventoRepository.deleteById(id);
	}

}

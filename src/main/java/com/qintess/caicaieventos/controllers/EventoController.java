package com.qintess.caicaieventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.caicaieventos.models.Evento;
import com.qintess.caicaieventos.services.EventoService;


@RestController
@RequestMapping("/api")
public class EventoController {
	
	
	@Autowired
	private EventoService eventoService;
	

	//buscar todos os registros 
	@GetMapping("/evento")
	public List<Evento> buscarEvento(){ 
		return eventoService.buscarTodos();
	}
	
	
	//criar um novo registro
	@PostMapping("/evento")
	public void criarEvento(@RequestBody Evento evento) {
		if(evento.getQuantidadeIngressos() <= evento.getCasaDeShow().getCapacidadeTotal()) {
		eventoService.salvar(evento);
		}
		
	}
	
	
	//pesquisar pelo id
	@GetMapping(path = {"/evento/{id}"})
	public ResponseEntity<Evento> buscarPorId(@PathVariable Integer id){
		return eventoService.buscarPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//pesquisar pelo nome
	@GetMapping(path= {"/evento/buscanome/{nome}"})
	public Evento buscarPorNome(@PathVariable String nome) {
		return eventoService.buscarPorNome(nome);
	}
	
	// atualizar um registro na base de dados
	@PutMapping(value="/evento/{id}")
	public ResponseEntity<Evento> atualizar(@PathVariable("id") Integer id,
										    @RequestBody Evento evento) {
		return eventoService.buscarPorId(id)
				.map(record -> {
					record.setNome(evento.getNome());
					record.setDescricao(evento.getDescricao());
					record.setData(evento.getData());
					record.setCasaDeShow(evento.getCasaDeShow());
					record.setQuantidadeIngressos(evento.getQuantidadeIngressos());
					record.setPreco(evento.getPreco());
					record.setCasaDeShow(evento.getCasaDeShow());
					Evento update = eventoService.salvar(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	//deletar um registro pelo id
	@DeleteMapping(value="/evento/{id}")
	public ResponseEntity<Object> deletarPorId(@PathVariable Integer id){
		return eventoService.buscarPorId(id)
				.map(record -> {
					eventoService.deletarPorId(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
}

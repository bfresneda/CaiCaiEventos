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

import com.qintess.caicaieventos.models.CasaDeShow;
import com.qintess.caicaieventos.services.CasaDeShowService;

@RestController
@RequestMapping("/api")
public class CasaDeShowController {

	@Autowired
	private CasaDeShowService casaDeShowService;
	
	//buscar todos os registros
	@GetMapping("/casadeshow")
	public List<CasaDeShow> buscaCasaDeShow(){
		return casaDeShowService.buscaTodos();
	}
	
	//criar um novo registro
	@PostMapping("casadeshow")
	public void criaCasaDeShow(@RequestBody CasaDeShow casaDeShow) {
		casaDeShowService.salvar(casaDeShow);
	}

	//pesquisar pelo id
	@GetMapping(path = {"/casadeshow/{id}"})
	public ResponseEntity<CasaDeShow> buscarPorID(@PathVariable Integer id){
		return casaDeShowService.buscarPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//pesquisar pelo nome
	@GetMapping(path = {"/casadeshow/buscanome/{nome}"})
	public CasaDeShow buscarPorNome(@PathVariable String nome){
		return casaDeShowService.buscarPorNome(nome);
	}
	
	//atualizar um registro na base de dados
	@PutMapping(value="/casadeshow/{id}")
	public ResponseEntity<CasaDeShow> atualizar(@PathVariable("id") Integer id
											   ,@RequestBody CasaDeShow casaDeShow){
		return casaDeShowService.buscarPorId(id)
				.map(record -> {
					if(casaDeShow.getNome() != null) {
					record.setNome(casaDeShow.getNome());}
					if(casaDeShow.getLogradouro() != null) {
					record.setLogradouro(casaDeShow.getLogradouro());}
					if(casaDeShow.getNumero() != 0) {
					record.setNumero(casaDeShow.getNumero());}
					if(casaDeShow.getBairro() != null) {
					record.setBairro(casaDeShow.getBairro());}
					if(casaDeShow.getCidade() != null) {
					record.setCidade(casaDeShow.getCidade());}
					if(casaDeShow.getEstado() != null) {
					record.setEstado(casaDeShow.getEstado());}
					if(casaDeShow.getCapacidadeTotal() != 0) {
					record.setCapacidadeTotal(casaDeShow.getCapacidadeTotal());}
					if(casaDeShow.getListaEventos() != null) {
					record.setListaEventos(casaDeShow.getListaEventos());}
					CasaDeShow update = casaDeShowService.salvar(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	//deletar um registro pelo id
	@DeleteMapping(value="/casadeshow/{id}")
	public ResponseEntity<Object> deletarPorId(@PathVariable Integer id){
		return casaDeShowService.buscarPorId(id)
				.map(record -> {
					casaDeShowService.deletarPorId(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
}

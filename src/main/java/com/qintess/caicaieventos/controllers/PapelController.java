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

import com.qintess.caicaieventos.models.Papel;
import com.qintess.caicaieventos.services.PapelService;

@RestController
@RequestMapping("/api")
public class PapelController {
	
	@Autowired
	private PapelService papelService;
	
	//buscar todos os papeis
	@GetMapping("/papel")
	public List<Papel> buscarPapel(){
		return papelService.buscarTodos();
	}
	
	//criar papel
	@PostMapping("/papel")
	public void criarPapel(@RequestBody Papel papel) {
		papelService.salvar(papel);
	}
	

	//atualizar registros
	@PutMapping(value="/papel/{id}")
	public ResponseEntity<Papel> atualizar(@PathVariable("id") Integer id,
										   @RequestBody Papel papel){
		return papelService.buscarPorId(id)
				.map(record -> {
					if(papel.getNivel() != null) {
					record.setNivel(papel.getNivel());}
					if(papel.getAtribuicao() != null) {
					record.setAtribuicao(papel.getAtribuicao());}
					Papel update = papelService.salvar(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	//deletar registro
	@DeleteMapping(value="/papel/{id}")
	public ResponseEntity<Object> deletarPorId(@PathVariable Integer id){
		return papelService.buscarPorId(id)
				.map(record -> {
					papelService.deletarPorId(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	
	
	
	
	
	
	

}

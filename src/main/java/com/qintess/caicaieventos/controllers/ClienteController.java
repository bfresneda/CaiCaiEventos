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

import com.qintess.caicaieventos.models.Cliente;
import com.qintess.caicaieventos.services.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
//	private PapelService papelService;
//	private Papel papel;
	
	//buscar todos os registros
	@GetMapping("/cliente")
	public List<Cliente> buscarCliente(){
		return clienteService.buscarTodos();
	}
	
	//criar um novo cliente
	@PostMapping("/cliente")
	public void criarEvento(@RequestBody Cliente cliente) {
		clienteService.salvar(cliente);
	}
	
	//pesquisar pelo id
	@GetMapping(path = {"/cliente/{id}"})
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
		return clienteService.buscarPorId(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//pesquisar pelo nome
	@GetMapping(path= {"cliente/buscanome/{nome}"})
	public Cliente buscarPorNome(@PathVariable String nome) {
		return clienteService.buscarPorNome(nome);
	}
	
	///atualizar o registro pelo id
	@PutMapping(value="/cliente/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable("id") Integer id,
										    @RequestBody Cliente cliente) {
		return clienteService.buscarPorId(id)
				.map(record -> {
					if(cliente.getNome() != null) {
					record.setNome(cliente.getNome());}
					if(cliente.getEmail() != null) {
					record.setEmail(cliente.getEmail());}
					if(cliente.getSenha() != null) {
					record.setSenha(cliente.getSenha());}
					if(cliente.getDtNascimento() != null) {
					record.setDtNascimento(cliente.getDtNascimento());}
					Cliente update = clienteService.salvar(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	//Deletar registro pelo id
	@DeleteMapping(value="/cliente/{id}")
	public ResponseEntity<Object> deletarPorId(@PathVariable Integer id){
		return clienteService.buscarPorId(id)
				.map(record -> {
					clienteService.deletarPorId(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
}

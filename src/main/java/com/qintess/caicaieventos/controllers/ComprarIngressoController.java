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
import com.qintess.caicaieventos.models.ComprarIngresso;
import com.qintess.caicaieventos.models.Evento;
import com.qintess.caicaieventos.services.ClienteService;
import com.qintess.caicaieventos.services.ComprarIngressoService;
import com.qintess.caicaieventos.services.EventoService;

@RestController
@RequestMapping("/api")
public class ComprarIngressoController {
	
	@Autowired
	private ComprarIngressoService comprarIngressoService;
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private ClienteService clienteService;
	
	//buscar todos registros
	@GetMapping("compraringresso")
	public List<ComprarIngresso> buscarCompras(){
		return comprarIngressoService.buscarTodos();
	}
	
	
	//Criar uma nova compra
	@PostMapping("/compraringresso/{idCliente}/{idEvento}")
	public void criarCompra(@RequestBody ComprarIngresso comprarIngresso
						   ,@PathVariable ("idCliente") Integer idCliente
						   ,@PathVariable ("idEvento") Integer idEvento) {
		System.out.println("entrei no metodo");

		Cliente cliente = clienteService.buscarPorId(idCliente).orElse(new Cliente());
		Evento evento = eventoService.buscarPorId(idEvento).orElse(new Evento());
		if(comprarIngresso.getQuantidade() <= 4 && comprarIngresso.getQuantidade() > 0 
				&& evento.getQuantidadeIngressosDisponiveis() - comprarIngresso.getQuantidade() >= 0 ) {
				System.out.println("ingressos validos ");
			
				evento.setQuantidadeIngressosDisponiveis
				(evento.getQuantidadeIngressosDisponiveis() - comprarIngresso.getQuantidade());
				comprarIngresso.setCliente(cliente);
				comprarIngresso.setEvento(evento);	
			}
			comprarIngressoService.salvar(comprarIngresso);
		}

	
	
	//alteração de uma compra
	@PutMapping("/compraringresso/{id}")
	public ResponseEntity<ComprarIngresso> atualizarCompra(@PathVariable("id") Integer id
														  ,@RequestBody ComprarIngresso comprarIngresso){
		return comprarIngressoService.buscarPorId(id)
				.map(record -> {
					if(comprarIngresso.getQuantidade() > 0 
						&& record.getQuantidade() + comprarIngresso.getQuantidade() <= 4 
						) {
						int quantidadeNova = record.getQuantidade();
						record.setQuantidade(comprarIngresso.getQuantidade() + quantidadeNova);}
					ComprarIngresso update = comprarIngressoService.salvar(record);
					return ResponseEntity.ok().body(update);					
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
//	//deletar compra
//	@DeleteMapping(value="/compraringresso/{id}")
//	public void deletarPorId(@PathVariable Integer id){
//		comprarIngressoService.deletarPorId(id);
//	}
	
	@DeleteMapping(value="/compraringresso/{id}")
	public ResponseEntity<Object> deletarPorId(@PathVariable Integer id){
		return comprarIngressoService.buscarPorId(id)
				.map(record -> {
					comprarIngressoService.deletarPorId(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
}

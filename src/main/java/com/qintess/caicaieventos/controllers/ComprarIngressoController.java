package com.qintess.caicaieventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.caicaieventos.models.Cliente;
import com.qintess.caicaieventos.models.ComprarIngresso;
import com.qintess.caicaieventos.models.Evento;
import com.qintess.caicaieventos.services.ComprarIngressoService;

@RestController
@RequestMapping("/api")
public class ComprarIngressoController {
	
	@Autowired
	private ComprarIngressoService comprarIngressoService;
	
	private Evento evento;
	private Cliente cliente;
	
	//buscar todos registros
	@GetMapping("compraringresso")
	public List<ComprarIngresso> buscarCompras(){
		return comprarIngressoService.buscarTodos();
	}
	
	//Criar uma nova compra
	@PostMapping("/compraringresso/{quantidade}")
	public void criarCompra(@RequestBody ComprarIngresso comprarIngresso
						   ,@PathVariable ("quantidade") Integer quantidade) {
		if(comprarIngresso.getCliente().getId() == cliente.getId()) {
			if(comprarIngresso.getQuantidade() > 4) {
				System.out.println("Você não pode comprar mais de 4 unidades ");
			}
			if(quantidade > 0){
				evento.setQuantidadeIngressosDisponiveis
				(evento.getQuantidadeIngressosDisponiveis() - quantidade);
				comprarIngresso.setQuantidade
				(comprarIngresso.getQuantidade() + quantidade);
			}
			comprarIngressoService.salvar(comprarIngresso);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

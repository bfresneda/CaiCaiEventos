package com.qintess.caicaieventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.caicaieventos.models.Cliente;
import com.qintess.caicaieventos.repos.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorNome(String nome) {
		return clienteRepository.findByNomeContaining(nome);
	}
	
	public Optional<Cliente> buscarPorId(Integer id){
		return clienteRepository.findById(id);
	}
	
	public void deletarPorId(Integer id) {
		clienteRepository.deleteById(id);
	}
	
	
	
}

package com.qintess.caicaieventos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qintess.caicaieventos.models.CasaDeShow;
import com.qintess.caicaieventos.models.Cliente;
import com.qintess.caicaieventos.models.Evento;
import com.qintess.caicaieventos.models.Papel;
import com.qintess.caicaieventos.repos.CasaDeShowRepository;
import com.qintess.caicaieventos.repos.ClienteRepository;
import com.qintess.caicaieventos.repos.EventoRepository;
import com.qintess.caicaieventos.repos.PapelRepository;

@Configuration
@Profile("test")
public class InputInicial implements CommandLineRunner{
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
	private CasaDeShowRepository casaDeShowRepository;
	@Autowired
	private PapelRepository papelRepository ;
//	@Autowired
//	private ComprarIngressoRepository comprarIngressoRepository;

	@Override
	public void run(String...args) throws Exception{

		
		papelRepository.save(new Papel(1,"ADMIN"));
		papelRepository.save(new Papel(2,"USER"));
		
		clienteRepository.save(new Cliente("Bruno","bruno@email.com","12345678"));
		clienteRepository.save(new Cliente("pedro","pedro@email.com","12345678"));	
		
		casaDeShowRepository.save(new CasaDeShow("Baladinha top","rua da estrada perdida",123));
		casaDeShowRepository.save(new CasaDeShow("Baladinha topezera","rua das marmota",35));
		
		eventoRepository.save(new Evento("Festa do caqui",253,253));
		eventoRepository.save(new Evento("Festa das bolhas",75,75));
	
	}
			
			
}		
			
package br.com.service;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.bluesoft.desafio.repository.PedidoRepository;
import br.com.bluesoft.desafio.service.PedidoService;

public class PedidoServiceTeste {

	@InjectMocks
	private PedidoService pedidoService;

	@Mock
	private PedidoRepository pedidoRepository;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}

	
}

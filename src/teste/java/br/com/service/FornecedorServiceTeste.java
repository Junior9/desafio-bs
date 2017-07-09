package br.com.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.repository.FornecedorRespository;
import br.com.bluesoft.desafio.service.FornecedorService;

public class FornecedorServiceTeste{

	private RestClientTest restClintTest;
	private List<Fornecedor> fornecedores;
	private Map<String,Integer> pedidos;
	private Fornecedor fornecedor;
	
	@InjectMocks
	private FornecedorService fornecedorService;
	
	@Mock
	private FornecedorRespository fornecedorRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		pedidos.put("7894900011517", 1);
		pedidos.put("7891910000197", 1);
		pedidos.put("7892840222949", 1);
	}
	
	@Test
	public void getFornecedoresLista() {
		for (String gtin : pedidos.keySet()) 
			fornecedores = fornecedorService.getFornecedorByGtin(gtin);
		assertEquals(3,fornecedores.size());
	}
	
	@Test
	public void validaQuantidadeMinima(){
		fornecedores = fornecedorService.getFornecedorByGtin("7894900011517");
		List<Fornecedor> fornecedoresValidos = fornecedorService.validaFornecedores(fornecedores,1);
		
	}
	
	@Test
	public void getFornecedores(){
		fornecedores = fornecedorService.getFornecedorByGtin("7894900011517");
		assertEquals(2, fornecedores.size());
		
		fornecedor = fornecedores.get(0);
		assertEquals("56.918.868/0001-20", fornecedor.getCnpj());
		assertEquals(2,fornecedor.getPrecos().size());
		assertEquals("Fornecedor1",fornecedor.getNome());
		
		fornecedor = fornecedores.get(1);
		assertEquals("37.563.823/0001-35", fornecedor.getCnpj());
		assertEquals(2,fornecedor.getPrecos().size());
		assertEquals("Fornecedor2",fornecedor.getNome());
	}
}
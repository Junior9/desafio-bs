package br.com.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Preco;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.repository.PedidoRepository;
import br.com.bluesoft.desafio.repository.ProdutoRepository;
import br.com.bluesoft.desafio.service.FornecedorService;
import br.com.bluesoft.desafio.service.PedidoService;
import br.com.service.util.MockUtil;

public class PedidoServiceTeste {

	private Pedido pedido;
	private List<Pedido> pedidos;
	private Map<String,Integer> mapPedido;
	private MockUtil mockUtil;
	private int quantidade;
	
	@Mock
	private FornecedorService fornecedorService;
	
	@InjectMocks
	private PedidoService pedidoService;

	@Mock
	private PedidoRepository pedidoRepository;
	
	@Mock
	private ProdutoRepository produtoRepository;
	private List<Fornecedor> fornecedores;
	
	@Before
	public void init(){
		mapPedido = new HashMap<>();
		mockUtil = new MockUtil();
		mapPedido.put("7894900011517",1);
		mapPedido.put("7891910000197",10);
		mapPedido.put("7892840222949",7);
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void montaPedidoTest(){
		String gtin = "7894900011517"; 
		fornecedores = mockUtil.listaDeFornecedores();
		Fornecedor fornecedor  = new Fornecedor("56.918.868/0001-20", "Fornecedor 1", mockUtil.listaDePrecos(1,1));
		when(produtoRepository.findOne(gtin)).thenReturn(new Produto(gtin,"REFRIGERANTE COCA-COLA 2LT"));
		when(fornecedorService.getFornecedorByGtin(gtin)).thenReturn(fornecedores);
		
		//when(fornecedorService.melhorFornecedor(fornecedores, quantidade)).thenReturn(new Fornecedor());
		when(fornecedorService.melhorPreco(fornecedor, quantidade)).thenReturn(new Preco(2.5,quantidade));
		
		Pedido pedido = pedidoService.montaPedido(gtin,10);
		assertEquals(1, pedido.getItens());
	} 
}
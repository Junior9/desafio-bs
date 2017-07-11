package br.com.bluesoft.desafio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Item;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Preco;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.data.form.DataFormulario;
import br.com.bluesoft.desafio.repository.PedidoRepository;
import br.com.bluesoft.desafio.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public Iterable<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	public List<Pedido> teste(Map<String,Integer> mapProdutos) {
		return montaPedidos(mapProdutos);
	}

	public List<Pedido> montaPedidos(Map<String, Integer> mapProdutos) {
		List<Pedido> pedidos = new ArrayList<>();
		Map<String, Pedido> mapPedidos = new HashMap<>();
		
		Pedido pedido;
		for (String gtin : mapProdutos.keySet()) {
			pedido = montaPedido(gtin, mapProdutos.get(gtin));
			if(pedido != null)
			  if(mapPedidos.containsKey(pedido.getFornecedor().getNome())){
			    Pedido pedidoExistente = mapPedidos.get(pedido.getFornecedor().getNome());
			    pedidoExistente.addItens(pedido.getItens());
			  }else{
			    mapPedidos.put(pedido.getFornecedor().getNome(),pedido);
			  }
		}
		for (String fornecedor : mapPedidos.keySet()) 
			pedidos.add(mapPedidos.get(fornecedor));
		
		if(pedidos != null)
		  pedidoRepository.save(pedidos);
		
		return pedidos;
	}

	public Pedido montaPedido(String gtin, int quantidade) {
		
		//Validar Gtin antes
		
		if(quantidade > 0){
			Produto produto  = produtoRepository.findOne(gtin);
			List<Fornecedor> fornecedores = fornecedorService.getFornecedorByGtin(gtin);
			Fornecedor melhorFornecedor = fornecedorService.melhorFornecedor(fornecedores, quantidade);
			
			if(melhorFornecedor != null){
			  Preco melhorPreco = fornecedorService.melhorPreco(melhorFornecedor, quantidade);
			  List<Item> itens = new ArrayList<>();
			  itens.add(new Item(produto,melhorPreco.getValor(),quantidade));
			  return new Pedido(melhorFornecedor,produto,itens);
			}
		}
		return null;
	}

	public List<Pedido> montaPedidos(List<DataFormulario> pedidosResquest) {
		List<Pedido> pedidos = new ArrayList<>();
		Map<String, Pedido> mapPedidos = new HashMap<>();
		
		Pedido pedido;
		for (DataFormulario dataForm : pedidosResquest) {
			pedido = montaPedido(dataForm.getGtin(),dataForm.getQuantidade());
			if(pedido != null)
			  if(mapPedidos.containsKey(pedido.getFornecedor().getNome())){
			    Pedido pedidoExistente = mapPedidos.get(pedido.getFornecedor().getNome());
			    pedidoExistente.addItens(pedido.getItens());
			  }else{
			    mapPedidos.put(pedido.getFornecedor().getNome(),pedido);
			  }
		}
		for (String fornecedor : mapPedidos.keySet()) 
			pedidos.add(mapPedidos.get(fornecedor));
		
		if(pedidos != null)
		  pedidoRepository.save(pedidos);
		
		return pedidos;
	}
}
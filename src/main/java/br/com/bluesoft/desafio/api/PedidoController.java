package br.com.bluesoft.desafio.api;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.service.PedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping("pedido/all")
	public  Iterable<Pedido> getAllPedidos(){
		return pedidoService.getAllPedidos();
	}
	
	
	@PostMapping("pedido/salva")
	public String salva(Map<String,Integer> pedidos){
		//return "[{'itens': [{'produto': {'nome': 'Produto3'}, 'quantidade': 10, 'total': 11.99, 'preco': 1.99}, {'produto': {'nome': 'Produto5'}, 'quantidade': 10, 'total': 11.99, 'preco': 1.99}], 'id': 2, 'fornecedor': {'nome': 'Fornecedor2'}}, "
		//		+ "{'itens': [{'produto': {'nome': 'Produto1'}, 'quantidade': 10, 'total': 11.99, 'preco': 1.99}, {'produto': {'nome': 'Produto2'}, 'quantidade': 10, 'total': 11.99, 'preco': 1.99}], 'id': 1, 'fornecedor': {'nome': 'Fornecedor1'}}]";
		return "[{'itens': [{'produto': {'nome': 'Produto3'}, 'quantidade': 10, 'total': 11.99, 'preco': 1.99}, {'produto': {'nome': 'Produto5'}, 'quantidade': 10, 'total': 11.99, 'preco': 1.99}], 'id': 2, 'fornecedor': {'nome': 'Fornecedor2'}}, {'itens': [{'produto': {'nome': 'Produto1'}, 'quantidade': 10, 'total': 11.99, 'preco': 1.99}, {'produto': {'nome': 'Produto2'}, 'quantidade': 10, 'total': 11.99, 'preco': 1.99}], 'id': 1, 'fornecedor': {'nome': 'Fornecedor1'}}]";
	}
}
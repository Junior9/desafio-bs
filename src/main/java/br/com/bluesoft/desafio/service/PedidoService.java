package br.com.bluesoft.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	public Iterable<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	public void teste() {
		List<Fornecedor> fornecedores = fornecedorService.getFornecedorByGtin("7894900011517");
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor.getNome());
		}
	}
}
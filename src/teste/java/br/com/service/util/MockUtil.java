package br.com.service.util;

import java.util.Arrays;
import java.util.List;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Preco;

public class MockUtil {
	
	public List<Fornecedor> listaDeFornecedores() {
		return Arrays.asList(
		new Fornecedor("56.918.868/0001-20","Fornecedor1",listaDePrecos(1,1)),
		new Fornecedor("56.918.868/0001-20","Fornecedor2",listaDePrecos(2,1)));
	}

	public List<Fornecedor> listaDeFornecedores(int quantidadeMinima) {
		return Arrays.asList(
		new Fornecedor("56.918.868/0001-20","Fornecedor1",listaDePrecos(1,quantidadeMinima)),
		new Fornecedor("56.918.868/0001-20","Fornecedor2",listaDePrecos(2,quantidadeMinima)));
	}

	public List<Preco> listaDePrecos(int tipo,int quantidadeMinima) {
		List<Preco> precos;
		if(tipo == 1){
			precos = Arrays.asList(new Preco(2.5, quantidadeMinima),new Preco(2.0, 10));
		}else{
			precos = Arrays.asList(new Preco(2.7, quantidadeMinima),new Preco(1.5, 15));
		}
		return precos;
	}


}

package br.com.bluesoft.desafio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bluesoft.desafio.model.Fornecedor;

@Service
public class FornecedorService {

	private Rest requestRest = new Rest();
	private final static String URL = "https://egf1amcv33.execute-api.us-east-1.amazonaws.com/dev/produto/";
	
	public List<Fornecedor> getFornecedorByGtin(String gtin) {
		List<Fornecedor> listaDeFornecedores = null;
		listaDeFornecedores = requestRest.getFornecedorUrl(URL+gtin,String.class);
		return listaDeFornecedores;
	}

	public List<Fornecedor> validaFornecedores(List<Fornecedor> fornecedores, int i) {
		
		
		return null;
	}

}

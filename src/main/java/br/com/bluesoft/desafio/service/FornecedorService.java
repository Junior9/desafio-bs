package br.com.bluesoft.desafio.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Preco;
import br.com.bluesoft.desafio.repository.FornecedorRespository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRespository fornecedorRepository;
	
	private Rest requestRest = new Rest();
	private final static String URL = "https://egf1amcv33.execute-api.us-east-1.amazonaws.com/dev/produto/";
	
	public List<Fornecedor> getFornecedorByGtin(String gtin) {
		List<Fornecedor> listaDeFornecedores = null;
		listaDeFornecedores = requestRest.getFornecedorUrl(URL+gtin,String.class);
		return listaDeFornecedores;
	}
	
	public void salva(Fornecedor fornecedor){
		fornecedorRepository.save(fornecedor);
	}

	public Fornecedor melhorFornecedor(List<Fornecedor> fornecedores, int quantidadeDoPedido) {
		Fornecedor melhorFornecedor = null;
		Preco melhorPreco = null;
				
		int index = 0;
		if(!fornecedores.isEmpty()){
			melhorPreco = melhorPreco(fornecedores.get(index), quantidadeDoPedido);
			//melhorFornecedor = fornecedores.get(index);
			Preco preco;
			for (Fornecedor fornecedor : fornecedores) {
				preco = melhorPreco(fornecedor, quantidadeDoPedido);
				if(preco != null && melhorPreco.getValor() > preco.getValor()){
					melhorFornecedor = fornecedor;
					melhorPreco = melhorPreco( fornecedor, quantidadeDoPedido );
				}
			}
		}
		if(melhorFornecedor != null ){
		  melhorFornecedor.setPrecos(Arrays.asList(melhorPreco));
		  return melhorFornecedor;
		}
		return null;
	}
	
	public Preco melhorPreco(Fornecedor fornecedor, int quantidade){
		List<Preco> precos = new ArrayList<>();
		for (Preco preco : fornecedor.getPrecos()) {
			if(validaQuantidade(quantidade, preco)){
				precos.add(preco);
			}
		}
		if(!precos.isEmpty()){
			precos.sort(new CompartorPreco());
			return precos.get(0);
		}
		return null;
	}

	private boolean validaQuantidade(int quantidade, Preco preco) {
		return quantidade >= preco.getQuantidade();
	}
	
	private class CompartorPreco implements Comparator<Preco>{
		@Override
		public int compare(Preco preco1, Preco preco2) {
			if(preco1.getValor() < preco2.getValor()){
				return -1;
			}else if(preco1.getValor() > preco2.getValor()){
				return 1;
			}
			return 0;
		}
	}
}

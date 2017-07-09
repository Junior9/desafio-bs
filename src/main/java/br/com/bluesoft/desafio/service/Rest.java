package br.com.bluesoft.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Preco;

public class Rest {
	
	private static RestTemplate restTemplate;

	public Rest(){}

	public List<Fornecedor> getFornecedorUrl(String url, Class<String> clazz) {
		restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(url,clazz);
		System.out.println(json);
		List<Fornecedor> listaDeFornecedores = converteJsonFornecedor(json);
		return listaDeFornecedores;
	}
	
	public List<Fornecedor> converteJsonFornecedor(String json) {
		List<Fornecedor> listaDeFornecedores = new ArrayList<>();
		JSONArray jsonArray;
		List<Preco> listaDePrecos;
		Fornecedor fornecedor;
		try {
			jsonArray = new JSONArray(json);
			for (int x = 0; x < jsonArray.length(); x++) {
				JSONObject jsonFornecedor = jsonArray.getJSONObject(x);
				fornecedor = new Fornecedor();
				fornecedor.setCnpj(jsonFornecedor.getString("cnpj"));
				fornecedor.setNome(jsonFornecedor.getString("nome"));
				listaDePrecos = converteJsonPreco(jsonFornecedor.getJSONArray("precos"));
				fornecedor.setPrecos(listaDePrecos);
				listaDeFornecedores.add(fornecedor);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return listaDeFornecedores;
	}

	private static List<Preco> converteJsonPreco(JSONArray jsonPrecos) throws JSONException {
		Preco precoDTO = null;
		List<Preco> listaDePreco = new ArrayList<Preco>();	
		Double valor;
		int quantidade;
		for(int index=0; index < jsonPrecos.length();index ++){
			JSONObject jsonPreco = jsonPrecos.getJSONObject(index);
			valor = jsonPreco.getDouble("preco");
			quantidade = jsonPreco.getInt("quantidade_minima");
			precoDTO = new Preco(valor, quantidade);
			listaDePreco.add(precoDTO);
		}
		return listaDePreco;
	}
}
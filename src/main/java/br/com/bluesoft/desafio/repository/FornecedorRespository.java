package br.com.bluesoft.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.bluesoft.desafio.model.Fornecedor;

public interface FornecedorRespository extends CrudRepository<Fornecedor,String> {

}

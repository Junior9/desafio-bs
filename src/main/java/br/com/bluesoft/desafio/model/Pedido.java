package br.com.bluesoft.desafio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Fornecedor fornecedor;
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Item> itens;
	
	public Pedido(){}
	
	public Pedido(Fornecedor fornecedor, Produto produto, List<Item> itens) {
		this.fornecedor = fornecedor;
		this.itens = itens;
	}
	public int getId() {
		return id;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public List<Item> getItens() {
		return itens;
	}
}

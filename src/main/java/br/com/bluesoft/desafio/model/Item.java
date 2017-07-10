package br.com.bluesoft.desafio.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Produto produto;
	private Double preco;
	private Double total;
	private int quantidade;
	
	public Item(){}
	
	public Item(Produto produto, Double preco, int quantidade) {
		this.produto = produto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.total = quantidade * preco;
	}
	public int getId() {
		return id;
	}
	public Produto getProduto() {
		return produto;
	}
	public Double getPreco() {
		return preco;
	}
	public Double getTotal() {
		return total;
	}
	
	public int getQuantidade(){
		return this.quantidade;
	}
}

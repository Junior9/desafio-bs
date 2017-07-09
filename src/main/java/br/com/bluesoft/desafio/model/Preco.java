package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preco {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Double valor;
	private int quantidade;

	public Preco(Double valor, int quantidade) {
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public Double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}
}

package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
}

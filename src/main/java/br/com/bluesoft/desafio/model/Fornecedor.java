package br.com.bluesoft.desafio.model;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nome;
	private String cnpj;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Preco> precos;

	public Fornecedor(String nome, String cnpj, List<Preco> listaDePrecos) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.precos = listaDePrecos;
	}

	public Fornecedor() {}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}

	public List<Preco> listaDePrecos() {
		return Collections.unmodifiableList(this.precos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

}
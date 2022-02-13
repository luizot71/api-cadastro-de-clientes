package br.com.app.builders.cadastro.clientes.rest.forms;

import br.com.app.builders.cadastro.clientes.domain.entity.Endereco;

public class FormEndereco {

	private String logradouro;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String pais;
	private String cep;
	
	public FormEndereco() {
	}

	public FormEndereco(String cidade, String logradouro, Integer numero, String bairro, String pais, String cep) {
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.pais = pais;
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Endereco endereco() {
		return new Endereco(this.cidade, this.logradouro, this.numero, this.bairro, this.cep, this.pais);
	}
}

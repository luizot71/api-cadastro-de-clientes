package br.com.app.builders.cadastro.clientes.rest.dto;

import br.com.app.builders.cadastro.clientes.domain.entity.Endereco;

public class DetalheEnderecoDto {

	private String logradouro;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String pais;
	private String cep;

	public DetalheEnderecoDto(Endereco endereco) {
		this.cidade = endereco.getCidade();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.pais = endereco.getPais();
		this.cep = endereco.getCep();
	}

	public String getCidade() {
		return cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getPais() {
		return pais;
	}

	public String getCep() {
		return cep;
	}

}

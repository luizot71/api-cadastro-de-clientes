package br.com.app.builders.cadastro.clientes.rest.dto;

public class EnderecoDto {

	private String cidade;
	private String pais;

	public EnderecoDto() {
	}

	public EnderecoDto(String pais, String cidade) {
		this.pais = pais;
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public String getCidade() {
		return cidade;
	}

}

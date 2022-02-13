package br.com.app.builders.cadastro.clientes.rest.dto;

import br.com.app.builders.cadastro.clientes.domain.entity.Cliente;
import br.com.app.builders.cadastro.clientes.domain.enums.Genero;
import br.com.app.builders.cadastro.clientes.util.IdadeUtils;

public class DetalheClienteDto {

	private Integer id;
	private String nome;
	private String cpf;
	private Integer idade;
	private Genero genero;
	private DetalheEnderecoDto detalheEnderecoDto;

	public DetalheClienteDto(Cliente client) {
		this.id = client.getId();
		this.nome = client.getNome();
		this.cpf = client.getCpf();
		this.idade = IdadeUtils.convertToAge(client.getDataNascimento());
		this.genero = client.getGenero();
		this.detalheEnderecoDto = new DetalheEnderecoDto(client.getEndereco());
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public Genero getGenero() {
		return genero;
	}

	public DetalheEnderecoDto getInfoEnderecoDto() {
		return detalheEnderecoDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DetalheClienteDto other = (DetalheClienteDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

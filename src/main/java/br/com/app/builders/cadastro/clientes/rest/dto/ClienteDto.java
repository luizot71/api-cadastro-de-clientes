package br.com.app.builders.cadastro.clientes.rest.dto;

import br.com.app.builders.cadastro.clientes.domain.entity.Cliente;
import br.com.app.builders.cadastro.clientes.domain.enums.Genero;
import br.com.app.builders.cadastro.clientes.util.IdadeUtils;
import org.springframework.data.domain.Page;

public class ClienteDto {

	private Integer id;
	private String nome;
	private Integer idade;
	private Genero genero;
	private EnderecoDto enderecoDto = new EnderecoDto();
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.idade = IdadeUtils.convertToAge(cliente.getDataNascimento());
		this.genero = cliente.getGenero();
		this.enderecoDto = new EnderecoDto(cliente.getEndereco().getCidade(), cliente.getEndereco().getPais());
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public Genero getGenero() {
		return genero;
	}

	public EnderecoDto getEnderecoDto() {
		return enderecoDto;
	}
	
	public static Page<ClienteDto> toDto(Page<Cliente> client) {
		return client.map(ClienteDto::new);
	}

}

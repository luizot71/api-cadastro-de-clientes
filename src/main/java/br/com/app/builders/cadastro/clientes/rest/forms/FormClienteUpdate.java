package br.com.app.builders.cadastro.clientes.rest.forms;

import br.com.app.builders.cadastro.clientes.domain.enums.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;

public class FormClienteUpdate {

	FormClienteUpdate(){
	}
	
	@Length(min = 3)
	private String nome;
	
	private String cpf;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
	
	private Genero genero;

	private FormEndereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public FormEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(FormEndereco endereco) {
		this.endereco = endereco;
	}

}

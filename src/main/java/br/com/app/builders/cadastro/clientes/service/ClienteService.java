package br.com.app.builders.cadastro.clientes.service;

import br.com.app.builders.cadastro.clientes.domain.entity.Cliente;
import br.com.app.builders.cadastro.clientes.domain.entity.Endereco;
import br.com.app.builders.cadastro.clientes.domain.repository.ClienteRepository;
import br.com.app.builders.cadastro.clientes.exception.ClienteNaoEncontradoException;
import br.com.app.builders.cadastro.clientes.exception.RecursoNaoEncontradoException;
import br.com.app.builders.cadastro.clientes.rest.dto.ClienteDto;
import br.com.app.builders.cadastro.clientes.rest.dto.DetalheClienteDto;
import br.com.app.builders.cadastro.clientes.rest.forms.FormCliente;
import br.com.app.builders.cadastro.clientes.rest.forms.FormClienteUpdate;
import br.com.app.builders.cadastro.clientes.spec.InfoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Page<ClienteDto> findAll(Pageable page){
		Page<Cliente> clientes = repository.findAll(page);
		if(clientes != null) {
			return ClienteDto.toDto(clientes);
		}
		throw new RecursoNaoEncontradoException();
	}
	
	public DetalheClienteDto findById(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		Cliente clienteExiste = cliente.orElseThrow(() -> new ClienteNaoEncontradoException(id));
		return new DetalheClienteDto(clienteExiste);
	}

	public Page<ClienteDto> findByAttribute(String atributo, String valor, Pageable page) {
		Page<Cliente> clients = repository.findAll(Specification.where(InfoCliente.findByAttribute(atributo, valor)), page);
		if(clients.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		return ClienteDto.toDto(clients);
	}
	
	public Cliente save(FormCliente formCliente) {
		Cliente cliente = new Cliente(formCliente);
		
		return repository.save(cliente);
	}
	
	public void update(Integer id, FormClienteUpdate formClienteUpdate) {
		Optional<Cliente> cliente = repository.findById(id);
		Cliente clientFounded = cliente.orElseThrow(() -> new ClienteNaoEncontradoException(id));
		clientFounded.setNome(formClienteUpdate.getNome() == null ? clientFounded.getNome() : formClienteUpdate.getNome());
		clientFounded.setGenero(formClienteUpdate.getGenero() == null ? clientFounded.getGenero() : formClienteUpdate.getGenero());
		clientFounded.setCpf(formClienteUpdate.getCpf() == null ? clientFounded.getCpf() : formClienteUpdate.getCpf());
		clientFounded.setDataNascimento(formClienteUpdate.getDataNascimento() == null ? clientFounded.getDataNascimento() : formClienteUpdate.getDataNascimento());
		if(formClienteUpdate.getEndereco() != null) {
			setAtributoEndereco(formClienteUpdate.getEndereco().endereco(), clientFounded, formClienteUpdate);
		}
	}
	
	public void setAtributoEndereco(Endereco endereco, Cliente clientFounded, FormClienteUpdate clientFormUpdate) {
		clientFounded.getEndereco().setCep(endereco.getCep() == null ? clientFounded.getEndereco().getCep() : clientFormUpdate.getEndereco().getCep());
		clientFounded.getEndereco().setCidade(endereco.getCidade() == null ? clientFounded.getEndereco().getCidade() : clientFormUpdate.getEndereco().getCidade());
		clientFounded.getEndereco().setLogradouro(endereco.getLogradouro() == null ? clientFounded.getEndereco().getLogradouro() : clientFormUpdate.getEndereco().getLogradouro());
		clientFounded.getEndereco().setNumero(endereco.getNumero() == null ? clientFounded.getEndereco().getNumero() : clientFormUpdate.getEndereco().getNumero());
		clientFounded.getEndereco().setBairro(endereco.getBairro() == null ? clientFounded.getEndereco().getBairro() : clientFormUpdate.getEndereco().getBairro());
		clientFounded.getEndereco().setPais(endereco.getPais() == null ? clientFounded.getEndereco().getPais() : clientFormUpdate.getEndereco().getPais());
	}
	
	public void deleteById(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		cliente.orElseThrow(() -> new ClienteNaoEncontradoException(id));
		repository.deleteById(id);
	}
}

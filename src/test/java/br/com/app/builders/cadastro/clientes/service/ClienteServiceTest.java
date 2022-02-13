package br.com.app.builders.cadastro.clientes.service;

import java.time.LocalDate;
import java.util.Optional;

import br.com.app.builders.cadastro.clientes.domain.entity.Cliente;
import br.com.app.builders.cadastro.clientes.domain.enums.Genero;
import br.com.app.builders.cadastro.clientes.domain.repository.ClienteRepository;
import br.com.app.builders.cadastro.clientes.exception.ClienteNaoEncontradoException;
import br.com.app.builders.cadastro.clientes.rest.dto.DetalheClienteDto;
import br.com.app.builders.cadastro.clientes.rest.forms.FormCliente;
import br.com.app.builders.cadastro.clientes.rest.forms.FormEndereco;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

	@InjectMocks
	private ClienteService clienteService;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Test
	@DisplayName("Deve encontrar o cliente pelo ID")
	public void testGetClienteById() {
		FormEndereco formEndereco = new FormEndereco("Rio de Janeiro", "Avenida Rio Branco",
				156,
				"Centro",
				"Brasil",
				"22121-0021");

		FormCliente formCliente = new FormCliente("Joaozinho","343.984.640-77",
				LocalDate.of(1995, 05, 16),
				Genero.HOMEM,
				formEndereco);
		
		Optional<Cliente> client = Optional.of(new Cliente(formCliente));
		Mockito.when(clienteRepository.findById(4)).thenReturn(client);
		DetalheClienteDto clientDetailDto = clienteService.findById(4);
		Assertions.assertThat(clientDetailDto).isEqualTo(new DetalheClienteDto(client.get()));
		Mockito.verify(clienteRepository, Mockito.times(1)).findById(4);
	}
	
	@Test
	@DisplayName("Deve retornar uma exceptio, caso o cliente não seja encontrado")
	public void testClienteNaoEncontrado() {
		Assertions.assertThatExceptionOfType(ClienteNaoEncontradoException.class)
								.isThrownBy(() -> clienteService.findById(3));
	}
}

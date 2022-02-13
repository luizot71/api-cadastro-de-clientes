package br.com.app.builders.cadastro.clientes.rest.controller;

import java.net.URI;

import br.com.app.builders.cadastro.clientes.domain.entity.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
class UsuarioControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TestEntityManager manager;
	
	@BeforeEach
	public void createTestUserBD() {
		Usuario usuario = new Usuario();
		
		usuario.setLogin("luizot");
		usuario.setSenha("$2a$04$mHpT4TriUuB5zaPCyDa4aeMhUqe/EHiXxDTqb1NNhm1Q4HubcTEIS");
		
		manager.persist(usuario);
	}
	
	@Test
	@DisplayName("Deve retornar 200 se os dados de autenticação estiverem corretos")
	public void testSucessoAutenticacao() throws Exception {
		URI uri = new URI("/api/usuarios/auth");
		String json = "{\"login\":\"test\",\"senha\":\"3435\"}";
		
		mockMvc
			.perform(MockMvcRequestBuilders
					.post(uri)
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers
					.status()
					.is(200));
	}
}

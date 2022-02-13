package br.com.app.builders.cadastro.clientes.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import br.com.app.builders.cadastro.clientes.util.IdadeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IdadeUtilsTest {

	@Test
	@DisplayName("Calcula a idade de acordo com a data de nascimento")
	void testCalculaIdade() {
		LocalDate dataNascimento = LocalDate.of(2002, 04, 02);
		Integer age = IdadeUtils.convertToAge(dataNascimento);
		assertEquals(19, age);
	}
}

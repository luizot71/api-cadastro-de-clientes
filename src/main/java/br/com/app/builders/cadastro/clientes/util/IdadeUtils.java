package br.com.app.builders.cadastro.clientes.util;

import java.time.LocalDate;
import java.time.Period;

public class IdadeUtils {

	private IdadeUtils() {
		throw new AssertionError();
	}

	public static Integer convertToAge(LocalDate idade) {
		return Period.between(idade, LocalDate.now()
		).getYears();
	}
}

package br.com.app.builders.cadastro.clientes.spec;

import br.com.app.builders.cadastro.clientes.domain.entity.Cliente;
import br.com.app.builders.cadastro.clientes.domain.entity.Endereco;
import br.com.app.builders.cadastro.clientes.domain.enums.Genero;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;

public class InfoCliente {

	public static Specification<Cliente> findByAttribute(String atributo, String valor) {

		String attributeLower = atributo.toLowerCase();
		String valueLower = valor.toLowerCase();
		Field fieldList[] = Endereco.class.getDeclaredFields();

		if (attributeLower.equals("genero")) {
			switch (valueLower) {
			case "homem":
				return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(attributeLower),
						Genero.HOMEM);
			case "mulher":
				return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(attributeLower),
						Genero.MULHER);
			case "outro":
				return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(attributeLower),
						Genero.OUTRO);
			default:
				break;
			}
		}

		for (int i = 0; i < fieldList.length; i++) {
			Field fld = fieldList[i];
			if (fld.getName().equals(attributeLower)) {
				return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
						.like(criteriaBuilder.lower(root.get("endereco").get(attributeLower)), "%" + valueLower + "%");
			}
		}

		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.get(attributeLower)), "%" + valueLower + "%");
	}
}

package br.com.app.builders.cadastro.clientes.domain.repository;

import br.com.app.builders.cadastro.clientes.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByLogin(String login);
}

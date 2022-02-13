package br.com.app.builders.cadastro.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class CadastroClientesApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CadastroClientesApplication.class, args);
    }
}

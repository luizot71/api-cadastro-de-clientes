# API para Cadastro de Clientes

Api Rest com recursos para a realização de cadastro de clientes, desde que o seja criado e validado via Postman,
porque essa Api faz a validação do Token JWT, portanto para realizar consultas, atualizar os dados por completo ou de forma granular, deletar e consultar de forma paginada ou sem paginação, o usuário precisa estar logado.

Para rodar o projeto é necessário:

*   Jdk-11.0.10.
*   Maven
*   IDE de sua preferência

Nesse projeto foi utilizado:

* Java 11
* Spring Boot
* Bean validation spring boot
  * Spring Data
  * Spring Security
    * Token JWT
* JPA
* Maven
* H2
* Junit
* JPA
* Design Patterns
* Teste Unitário
* Docker

[`Api` directory]: https://github.com/luizot71/cadastro-de-clientes

## Executando o projeto

Na raiz do projeto consta o arquivo do Postman:

Api Cadastro de Clientes.postman_collection.json

No Postman execute as ações abaixo:

    1- Execute a request = Cadastrar usuário da aplicação

    2- Execute a request = Validar usuario na aplicação

    3- Copie o token e insira no Header das demais requisições e as execute

Após validar o usuário poderá acessar os links abaixo:

    1 - http://localhost:8082/swagger-ui.html#/

    2 - http://localhost:8082/v2/api-docs

    3 - http://localhost:8082/health


Usuário e Senha:

    luizot
    9901
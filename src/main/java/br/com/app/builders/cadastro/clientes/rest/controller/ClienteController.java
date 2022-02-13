package br.com.app.builders.cadastro.clientes.rest.controller;

import br.com.app.builders.cadastro.clientes.domain.entity.Cliente;
import br.com.app.builders.cadastro.clientes.domain.repository.ClienteRepository;
import br.com.app.builders.cadastro.clientes.rest.dto.ClienteDto;
import br.com.app.builders.cadastro.clientes.rest.dto.DetalheClienteDto;
import br.com.app.builders.cadastro.clientes.service.ClienteService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Example;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.annotations.Cacheable;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Api("Api Clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService service;

    public ClienteController( ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("{id}")
    @ApiOperation("Obter detalhes de um cliente")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Cliente encontrado"),
        @ApiResponse(code = 404, message = "Cliente não encontrado para o ID informado")
    })
    public Cliente getClienteById(
            @ApiParam(name = "id",
                    value = "ID do cliente a ser obtido. Não pode estar vazio.",
                    example = "1",
                    required = true) @PathVariable Integer id ){
        return clienteRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    @GetMapping("detalhe-cliente/{id}")
    @Cacheable(value = "detalheCliente")
    public ResponseEntity<DetalheClienteDto> getDetalheClienteById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/atributo")
    @Cacheable(value = "atributoCliente")
    public ResponseEntity<Page<ClienteDto>> getByAtributo(@RequestParam(required = true) String attribute,
                                                           @RequestParam(required = true) String value, Pageable page){
        return ResponseEntity.ok(service.findByAttribute(attribute, value, page));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Salva um novo cliente")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Cliente salvo com sucesso"),
            @ApiResponse(code = 400, message = "Erro de validação")
    })
    public Cliente save( @RequestBody @Valid Cliente cliente ){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        clienteRepository.findById(id)
                .map( cliente -> {
                    clienteRepository.delete(cliente );
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody @Valid Cliente cliente ){
        clienteRepository
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clienteRepository.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Cliente não encontrado") );
    }

    @GetMapping(value = "/nao-paginado")
    @Cacheable(value = "cliente")
    public List<Cliente> getClientesSemPaginacao(Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(
                                            ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return clienteRepository.findAll(example);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Page to be loaded", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records", defaultValue = "5"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Ordering of records(attribute,desc ou asc)")
    })
    @GetMapping(value = "/paginado")
    @Cacheable(value = "clientes")
    public ResponseEntity<Page<ClienteDto>> getClientesComPaginacao(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) @ApiIgnore Pageable page){
        return ResponseEntity.ok(service.findAll(page));
    }

}

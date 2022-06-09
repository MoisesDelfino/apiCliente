package com.moises.crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moises.crud.model.Cliente;
import com.moises.crud.repository.ClienteRepository;

import lombok.AllArgsConstructor;


@RestController //Essa anotação diz que essa classe é um controlador Rest, ou seja, ela vai receber as requisições para desenvolvimento dos endpoints
@RequestMapping("/clientes") //Essa anotação mapeia os endpoints para receber requisições iniciadas com "/clientes"
@AllArgsConstructor
public class ClienteController {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Essa anotação diz que, sempre que chegar uma requisição usando o verbo GET  na URI /clientes, o método abaixo responderá essa requisição 
	@GetMapping
	public List<Cliente> listar() {
				return clienteRepository.findAll();
	}
	//Essa anotação diz que, sempre que chegar uma requisição usando o verbo POST  na URI /clientes, o método abaixo responderá essa requisição 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	
}	
package com.moises.crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Cliente cliente){
		if(cliente.getId() == null){
			return new ResponseEntity<String>("Informe o id do cliente", HttpStatus.OK);
		}
		Cliente clienteAtualizado = clienteRepository.saveAndFlush(cliente);

		return new ResponseEntity<Cliente>(clienteAtualizado, HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@RequestBody Cliente cliente){
		if(cliente.getId() == null){
			return new ResponseEntity<String>("Informe o id do cliente", HttpStatus.OK);
		}
		clienteRepository.deleteById(cliente.getId());

		return ResponseEntity.noContent().build();
	}
}
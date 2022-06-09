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
import com.moises.crud.model.Produto;
import com.moises.crud.repository.ProdutoRepository;


@RestController //Essa anotação diz que essa classe é um controlador Rest, ou seja, ela vai receber as requisições para desenvolvimento dos endpoints
@RequestMapping("/produtos") //Essa anotação mapeia os endpoints para receber requisições iniciadas com "/clientes"
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//Essa anotação diz que, sempre que chegar uma requisição usando o verbo GET  na URI /clientes, o método abaixo responderá essa requisição 
	@GetMapping
	public List<Produto> listar() {
				return produtoRepository.findAll();
	}
	//Essa anotação diz que, sempre que chegar uma requisição usando o verbo POST  na URI /clientes, o método abaixo responderá essa requisição 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
}
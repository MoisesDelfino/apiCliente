package com.moises.crud.controller;

import java.util.List;

import com.moises.crud.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Produto produto){
		if(produto.getId() == null){
			return new ResponseEntity<String>("Informe o id do produto", HttpStatus.OK);
		}
		Produto produtoAtualizado = produtoRepository.saveAndFlush(produto);

		return new ResponseEntity<Produto>(produtoAtualizado, HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@RequestBody Produto produto){
		if(produto.getId() == null){
			return new ResponseEntity<String>("Informe o id do produto", HttpStatus.OK);
		}
		produtoRepository.deleteById(produto.getId());

		return ResponseEntity.noContent().build();
	}
	
}
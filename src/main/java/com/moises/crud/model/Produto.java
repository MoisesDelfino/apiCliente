package com.moises.crud.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data //Essa anotação declara getter, setters, equals, hash code...
@Entity
@NoArgsConstructor //Essa anotação mapeia essa classe como uma tabela do banco de dados
public class Produto {
	
	
	@Id //Essa anotação diz que este atributo será a primary key no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Essa anotação define a estratégia de geração de valores para o id de cada registro, delegando a responsabilidade de incrementar o id para o banco de dados
	private Long id;
		
	@Column(nullable = false) //Essa anotação define este atributo como uma coluna do banco de dados, passando que é not null
	private String nome;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private double precoUnitario;

	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
}
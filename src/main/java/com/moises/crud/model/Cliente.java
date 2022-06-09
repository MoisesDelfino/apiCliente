package com.moises.crud.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity //Essa anotação mapeia essa classe como uma tabela do banco de dados
@Data //Essa anotação declara getter, setters, equals, hash code...
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
	
	
	@Id //Essa anotação diz que este atributo será a primary key no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Essa anotação define a estratégia de geração de valores para o id de cada registro, delegando a responsabilidade de incrementar o id para o banco de dados
	private Long id;
		
	@Column(nullable = false) //Essa anotação define este atributo como uma coluna do banco de dados, passando que é not null
	@NotNull(message="O nome não pode ser nulo")
    @NotEmpty(message="O nome não pode ser vazio")
	private String nome;
	
	/*@JoinColumn
	@OneToMany
	private List<Produto> produtos;*/
}

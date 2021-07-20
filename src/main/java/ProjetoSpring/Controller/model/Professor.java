package ProjetoSpring.Controller.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Professor {
	
	
	private String nome;
	@Id
	private String cpf;
	private int idade;
	private Double salario;
	

}

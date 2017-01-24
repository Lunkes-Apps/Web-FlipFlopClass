package com.flipflopclass.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class CadastroUser {

//	@NotEmpty(message="O Nome não pode estar em branco")
    private String nome;
	
//	@Column(unique=true)
//	@Email(message="Formato de email incorreto")
//	@NotEmpty(message="O Email não pode estar em branco")
//	@NotNull
	private String username;
	
//	@Size(min = 6, max = 30, message="A senha deve conter entre 8 a 20 caracteres")
//	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}$", message="A senha deve conter letras,números"
//			+ " e conter entre 8 a 20 caracteres")
//	@NotEmpty(message="Password não pode estar em branco")
//	@NotNull
	private String password;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 

	
}

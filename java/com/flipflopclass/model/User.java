package com.flipflopclass.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	@Email(message="Formato de email incorreto")
	@NotEmpty(message="O Email não pode estar em branco")
	@NotNull
	private String username;
	
	@Size(min = 6, max = 30, message="A senha deve conter entre 8 a 20 caracteres")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}$", message="A senha deve conter letras,números"
			+ " e conter entre 8 a 20 caracteres")
	@NotEmpty(message="Password não pode estar em branco")
	@NotNull
	private String password;
	
	
	private String authorit;
	
	@NotNull
	private boolean enabled;
	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Account account;
	
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public String getAuthorit() {
		return authorit;
	}

	public void setAuthorit(String authorit) {
		this.authorit = authorit;
	}		
	
}

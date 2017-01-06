package br.com.prova.livraria.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	private String email;
	private String senha;
	private boolean ativo;
	
	
	
	public Usuario() {
	}
	public Usuario(String email, String senha, boolean ativo) {
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
	}
	public Usuario(Integer id, String email, String senha, boolean ativo) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

}

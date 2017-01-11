package br.com.prova.livraria.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private boolean ativo;

	private String email;

	private String nome;

	private String senha;

	private String sobrenome;

	//bi-directional many-to-one association to Perfil
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PerfilId")
	private Perfil perfil = new Perfil();;

	public Usuario() {
	}

	public Usuario(boolean ativo, String email, String nome, String senha, String sobrenome, Perfil perfil) {
		this.ativo = ativo;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.sobrenome = sobrenome;
		this.perfil = perfil;
	}
	
	public Usuario(int id, boolean ativo, String email, String nome, String senha, String sobrenome, Perfil perfil) {
		this.id = id;
		this.ativo = ativo;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.sobrenome = sobrenome;
		this.perfil = perfil;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
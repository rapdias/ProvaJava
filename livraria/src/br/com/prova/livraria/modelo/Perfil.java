package br.com.prova.livraria.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Perfil database table.
 * 
 */
@Entity
@NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean ativo;

	private String perfil;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "perfil")
	private List<Usuario> usuarios;

	public Perfil() {
	}

	public Perfil(String perfil, boolean ativo) {
		this.ativo = ativo;
		this.perfil = perfil;
		this.usuarios = usuarios;
	}

	public Perfil(int id, boolean ativo, String perfil, List<Usuario> usuarios) {
		this.id = id;
		this.ativo = ativo;
		this.perfil = perfil;
		this.usuarios = usuarios;
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

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPerfil(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPerfil(null);

		return usuario;
	}

}
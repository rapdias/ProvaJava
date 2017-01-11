package br.com.prova.livraria.modelo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * The persistent class for the Autor database table.
 * 
 */
@Entity
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private boolean ativo;

	private String email;

	private String nome;

	//bi-directional many-to-many association to Livro
	@ManyToMany(mappedBy="autores")
	private List<Livro> livros = new ArrayList<Livro>();

	public Autor() {
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
	
	public void addLivro(Livro livro){
		this.livros.add(livro);
	}
	public void removeLivro(Livro livro) {
		this.livros.remove(livro);
	}
	public List<Livro> getLivros() {
		return this.livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
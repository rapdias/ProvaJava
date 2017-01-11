package br.com.prova.livraria.modelo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * The persistent class for the Livro database table.
 * 
 */
@Entity
@NamedQuery(name="Livro.findAll", query="SELECT l FROM Livro l")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String isbn;
	private String titulo;
	private double preco;
	@Temporal(TemporalType.DATE)
	private Calendar dataLancamento = Calendar.getInstance();
	private boolean ativo;


	//bi-directional many-to-many association to Autor
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="livro_autor"
		, joinColumns={
			@JoinColumn(name="LivroId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="AutorId")
			}
		)
	private List<Autor> autores = new ArrayList<Autor>();

	public Livro() {
	}



	public Livro(String isbn, String titulo, double preco, Calendar dataLancamento, boolean ativo,
			Autor autor) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.ativo = ativo;
		this.autores.add(autor);
	}
	public Livro(int id, String isbn, String titulo, double preco, Calendar dataLancamento, boolean ativo,
			Autor autor) {
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.ativo = ativo;
		this.autores.add(autor);
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

	public Calendar getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void adicionaAutor(Autor autor) {
		this.autores.add(autor);
//		autor.addLivro(this);
	}
	public List<Autor> getAutores() {
		return this.autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public void removeAutor(Autor autor) {
		this.autores.remove(autor);
		autor.removeLivro(this);
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
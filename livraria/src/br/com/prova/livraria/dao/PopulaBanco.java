package br.com.prova.livraria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.livraria.modelo.Autor;
import br.com.prova.livraria.modelo.Livro;
import br.com.prova.livraria.modelo.Usuario;

public class PopulaBanco {
	
	


	public void fillLista() {
		
		LivroDao daoL = new LivroDao();
		AutorDao daoA = new AutorDao();
		UsuarioDao daoU = new UsuarioDao();

		Autor assis = geraAutor("Machado de Assis","machado@machado.com",1);
		daoA.pesist(assis);

		Autor amado = geraAutor("Jorge Amado","jorge@jorge.com",2);
		daoA.pesist(amado);

		Autor coelho = geraAutor("Paulo Coelho","paulo@paulo.com",3);
		daoA.pesist(coelho);

		Autor lobato = geraAutor("Monteiro Lobato","monteiro@monteiro.com",4);
		daoA.pesist(lobato);

		Livro casmurro = geraLivro("978-8-52-504464-8", "Dom Casmurro",
				"10/01/1899", 24.90, assis);
		Livro memorias = geraLivro("978-8-50-815415-9",
				"Memorias Postumas de Bras Cubas", "01/01/1881", 19.90, assis);
		Livro quincas = geraLivro("978-8-50-804084-1", "Quincas Borba",
				"01/01/1891", 16.90, assis);

		daoL.pesist(casmurro);
		daoL.pesist(memorias);
		daoL.pesist(quincas);

		Livro alquemista = geraLivro("978-8-57-542758-3", "O Alquimista",
				"01/01/1988", 19.90, coelho);
		Livro brida = geraLivro("978-8-50-567258-7", "Brida", "01/01/1990",
				12.90, coelho);
		Livro valkirias = geraLivro("978-8-52-812458-8", "As Valkirias",
				"01/01/1992", 29.90, coelho);
		Livro maao = geraLivro("978-8-51-892238-9", "O Diario de um Mago",
				"01/01/1987", 9.90, coelho);

		daoL.pesist(alquemista);
		daoL.pesist(brida);
		daoL.pesist(valkirias);
		daoL.pesist(maao);

		Livro capitaes = geraLivro("978-8-50-831169-1", "Capitaes da Areia",
				"01/01/1937", 6.90, amado);
		Livro flor = geraLivro("978-8-53-592569-9",
				"Dona Flor e Seus Dois Maridos", "01/01/1966", 18.90, amado);

		daoL.pesist(capitaes);
		daoL.pesist(flor);

		Usuario adm = new Usuario();
		adm.setEmail("avanade@avanade.com");
		adm.setSenha("1234");
		adm.setId(1);		
		daoU.pesist(adm);
		
		

	}
	
	public void dropLista(){
		LivroDao daoL = new LivroDao();
		AutorDao daoA = new AutorDao();
		UsuarioDao daoU = new UsuarioDao();
		
		daoL.drop();
		daoA.drop();
		daoU.drop();
	}
	
	
	
	private static Autor geraAutor(String nome,String email, int id) {
		Autor autor = new Autor();
		autor.setNome(nome);
		autor.setEmail(email);
		autor.setId(id);
		return autor;
	}

	private static Livro geraLivro(String isbn, String titulo, String data,
			double preco, Autor autor) {
		Livro livro = new Livro();
		livro.setIsbn(isbn);
		livro.setTitulo(titulo);
		livro.setDataLancamento(parseData(data));
		livro.setPreco(preco);
		livro.adicionaAutor(autor);
		return livro;
	}

	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

}

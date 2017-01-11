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
import br.com.prova.livraria.modelo.Perfil;
import br.com.prova.livraria.modelo.Usuario;

public class PopulaBanco {
	
	


	public void fillLista() {
		LivroDao daoL = new LivroDao();
		AutorDao daoA = new AutorDao();
		UsuarioDao daoU = new UsuarioDao();
		PerfilDao pDao = new PerfilDao();
		if(daoA.listaTodos().size() == 0){

			Autor assis = geraAutor("Machado de Assis","machado@machado.com", true);
			daoA.pesist(assis);

			Autor amado = geraAutor("Jorge Amado","jorge@jorge.com", true);
			daoA.pesist(amado);

			Autor coelho = geraAutor("Paulo Coelho","paulo@paulo.com", true);
			daoA.pesist(coelho);

			Autor lobato = geraAutor("Monteiro Lobato","monteiro@monteiro.com", true);
			daoA.pesist(lobato);
		
			
			Livro casmurro = geraLivro("978-8-52-504464-8", "Dom Casmurro",
					"10/01/1899", 24.90, assis, true);
			Livro memorias = geraLivro("978-8-50-815415-9",
					"Memorias Postumas de Bras Cubas", "01/01/1881", 19.90, assis, true);
			Livro quincas = geraLivro("978-8-50-804084-1", "Quincas Borba",
					"01/01/1891", 16.90, assis, true);

			

			Livro alquemista = geraLivro("978-8-57-542758-3", "O Alquimista",
					"01/01/1988", 19.90, coelho, true);
			Livro brida = geraLivro("978-8-50-567258-7", "Brida", "01/01/1990",
					12.90, coelho, true);
			Livro valkirias = geraLivro("978-8-52-812458-8", "As Valkirias",
					"01/01/1992", 29.90, coelho, true);
			Livro maao = geraLivro("978-8-51-892238-9", "O Diario de um Mago",
					"01/01/1987", 9.90, coelho, true);

			

			Livro capitaes = geraLivro("978-8-50-831169-1", "Capitaes da Areia",
					"01/01/1937", 6.90, amado, true);
			Livro flor = geraLivro("978-8-53-592569-9",
					"Dona Flor e Seus Dois Maridos", "01/01/1966", 18.90, amado, true);

			daoL.pesist(casmurro);
			daoL.pesist(memorias);
			daoL.pesist(quincas);
			daoL.pesist(alquemista);
			daoL.pesist(brida);
			daoL.pesist(valkirias);
			daoL.pesist(maao);
			daoL.pesist(capitaes);
			daoL.pesist(flor);

			Perfil admPerfil = new Perfil("Administrador", true);
			Perfil escritprPerfil = new Perfil("Escritor", true);
			Perfil clientePerfil = new Perfil("Cliente", true);
			pDao.pesist(admPerfil);
			pDao.pesist(escritprPerfil);
			pDao.pesist(clientePerfil);
			
			Usuario adm = new Usuario();
			adm.setEmail("avanade@avanade.com");
			adm.setSenha("1234");
			adm.setNome("usu");
			adm.setSobrenome("sobrenomesssss");
			adm.setAtivo(true);
			adm.setPerfil(admPerfil);
			daoU.pesist(adm);
			
			Usuario adm2 = new Usuario();
			adm2.setEmail("r@r.com");
			adm2.setSenha("1");
			adm2.setNome("Rogerio");
			adm2.setSobrenome("Ap. Dias");
			adm2.setAtivo(true);
			adm2.setPerfil(clientePerfil);
			daoU.pesist(adm2);
		}
	}
	
	
	
	public void dropLista(){
		LivroDao daoL = new LivroDao();
		//AutorDao daoA = new AutorDao();
		UsuarioDao daoU = new UsuarioDao();
		//daoA.drop();
		daoL.drop();
		
		daoU.drop();
	}
	
	
	
	private static Autor geraAutor(String nome,String email,  boolean ativo) {
		Autor autor = new Autor();
		autor.setNome(nome);
		autor.setEmail(email);
		autor.setAtivo(ativo);
		return autor;
	}

	private static Livro geraLivro(String isbn, String titulo, String data,
			double preco, Autor autor, boolean ativo) {
		Livro livro = new Livro();
		livro.setIsbn(isbn);
		livro.setTitulo(titulo);
		livro.setDataLancamento(parseData(data));
		livro.setPreco(preco);
		livro.setAtivo(ativo);
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

package br.com.prova.livraria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.livraria.modelo.Livro;
import br.com.prova.livraria.modelo.Usuario;

public class LivroDao {

	public static ArrayList<Livro> LSLivro = new ArrayList<Livro>();

	public boolean pesist(Livro livro) {
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();
			return false;
		}
	//	LSLivro.add(livro);
	}

	public boolean drop() {
		// TODO Auto-generated method stub
		//LSLivro.clear();
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Livro l  WHERE l.id > 0").executeUpdate();
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
	}

	public List<Livro> listaTodos() {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			return em.createQuery("SELECT l FROM Livro l WHERE l.ativo = true").getResultList();
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			e.printStackTrace();
			return null;
		}
	//	return LSLivro;
	}

	public static void main(String[] args) {
		new LivroDao().drop();
	//	List<Livro> ls = new LivroDao().listaTodos();
		System.out.println("teste ");
	}
	public Livro buscaPorId(Integer id) {
		// TODO Auto-generated method stub
//		for (Livro livro : LSLivro) {
//			if (id == livro.getId()) {
//				return livro;
//
//			}
//		}
//
//		return null;
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			 return em.find(Livro.class, id);
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			return null;
		}
	}

	public boolean adiciona(Livro livro) {
		
		//LSLivro.add(livro);

		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
	}

	public boolean atualiza(Livro livro) {
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.merge(livro);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
		
//		for (Livro l : LSLivro) {
//			if (livro.getId() == l.getId()) {
//
//				l.setTitulo(livro.getTitulo());
//			}
//		}
	}

	public boolean remove(Livro livro) {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			livro.setAtivo(false);
			em.merge(livro);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}

	}
}

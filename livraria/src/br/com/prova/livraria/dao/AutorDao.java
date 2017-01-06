package br.com.prova.livraria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.livraria.modelo.Autor;
import br.com.prova.livraria.modelo.Livro;

public class AutorDao {

	public static ArrayList<Autor> LSAutor = new ArrayList<Autor>();

	public boolean pesist(Autor autor) {
		//LSAutor.add(autor);
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(autor);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
	}

	public boolean drop() {
		// TODO Auto-generated method stub
//		LSAutor.clear();
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Autor a  WHERE a.id > 0").executeUpdate();
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
	}
	public static void main(String[] args) {
		new AutorDao().drop();
	}

	public List<Autor> listaTodos() {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			return em.createQuery("SELECT a FROM Autor a WHERE a.ativo = true").getResultList();
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			e.printStackTrace();
			return null;
		}
		
		//return LSAutor;
	}

	public Autor buscaPorId(Integer autorId) {
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			 return em.find(Autor.class, autorId);
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			return null;
		}

		// TODO Auto-generated method stub
//		for (Autor autor : LSAutor) {
//			if (autorId == autor.getId()) {
//				return autor;
//			}
//		}
//
//		return null;

	}

	public boolean remove(Autor autor) {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			autor.setAtivo(false);
			em.merge(autor);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
	}

	public boolean adiciona(Autor autor) {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(autor);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
	}

	public boolean atualiza(Autor autor) {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.merge(autor);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
	}
}

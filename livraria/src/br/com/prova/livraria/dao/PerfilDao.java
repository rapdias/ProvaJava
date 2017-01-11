package br.com.prova.livraria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.livraria.modelo.Livro;
import br.com.prova.livraria.modelo.Perfil;
import br.com.prova.livraria.modelo.Usuario;

public class PerfilDao {

	public boolean pesist(Perfil perfil) {
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(perfil);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}finally {
			em.close();
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
			//em.createQuery("DELETE FROM Livro l  WHERE l.id > 0").executeUpdate();
			em.createQuery("DELETE FROM  Perfil  WHERE id > 0").executeUpdate();
		//	em.createQuery("DELETE FROM Autor   WHERE id > 0").executeUpdate();
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}finally {
			em.close();
		}
	}

	public List<Perfil> listaTodos() {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			return em.createQuery("SELECT p FROM Perfil p WHERE p.ativo = true").getResultList();
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			e.printStackTrace();
			return null;
		}finally {
			em.close();
		}
	//	return LSLivro;
	}

	public static void main(String[] args) {
		new PerfilDao().drop();
	//	List<Livro> ls = new LivroDao().listaTodos();
		System.out.println("teste ");
	}
	public Perfil buscaPorId(Integer id) {
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
			 return em.find(Perfil.class, id);
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			return null;
		}finally {
			em.close();
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
		}finally {
			em.close();
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
		}finally {
			em.close();
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
		}finally {
			em.close();
		}

	}
}

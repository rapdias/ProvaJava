package br.com.prova.livraria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.prova.livraria.Enum.EnumMsgm;
import br.com.prova.livraria.modelo.Autor;
import br.com.prova.livraria.modelo.Livro;

public class AutorDao {

	public static ArrayList<Autor> LSAutor = new ArrayList<Autor>();

	public boolean pesist(Autor autor) {
		// LSAutor.add(autor);
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(autor);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}

	public boolean drop() {
		// TODO Auto-generated method stub
		// LSAutor.clear();
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Autor a  WHERE a.id > 0").executeUpdate();
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {
		new LivroDao().drop();
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
		} finally {
			em.close();
		}

		// return LSAutor;
	}

	public Autor buscaPorId(Integer autorId) {
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			return em.find(Autor.class, autorId);
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			return null;
		} finally {
			em.close();
		}

		// TODO Auto-generated method stub
		// for (Autor autor : LSAutor) {
		// if (autorId == autor.getId()) {
		// return autor;
		// }
		// }
		//
		// return null;

	}

	public boolean remove(Autor autor) {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			autor.setAtivo(false);
			em.merge(autor);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}

	public String adiciona(Autor autor) {
		// TODO Auto-generated method stub
		

		try {
			if (verificaDuplicidade(autor) == null) {
				EntityManager em = null;
				em = new JPAUtil().getEntityManager();
				em.getTransaction().begin();
				autor.setAtivo(true);
				em.persist(autor);
				em.getTransaction().commit();
				return EnumMsgm.CAD_AUTOR_OK.getMsgm();
			} else {
				return EnumMsgm.ERRO_AUTOR_DUPLICIDADE.getMsgm();
			}
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			//em.getTransaction().rollback();
			return EnumMsgm.ERRO_AUTOR_CAD.getMsgm();
		
		}
	}

	public Object verificaDuplicidade(Autor autor) {
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			return  em.createQuery("SELECT a FROM Autor a WHERE a.ativo = true and a.nome =  '"+ autor.getNome() +"'" )
					.getSingleResult();
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			e.printStackTrace();
			return null;
		}
	}

	public boolean atualiza(Autor autor) {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.merge(autor);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}
}

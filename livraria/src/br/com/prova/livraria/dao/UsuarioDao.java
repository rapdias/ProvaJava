package br.com.prova.livraria.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.prova.livraria.modelo.Autor;
import br.com.prova.livraria.modelo.Livro;
import br.com.prova.livraria.modelo.Usuario;

public class UsuarioDao {
	
	public static ArrayList<Usuario> LSUsuario = new ArrayList<Usuario>();

	public Usuario existe(Usuario usu) {
		Usuario retorno = null;
		
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			return em.createQuery("FROM Usuario u WHERE u.email like :email  AND u.senha like :senha", Usuario.class)
			 .setParameter("email", usu.getEmail()).setParameter("senha", usu.getSenha()).getSingleResult();
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return null;
		}
		
//		for (Usuario u : LSUsuario) {
//			if(usuario.getEmail().equals(u.getEmail()) && usuario.getSenha().equals(u.getSenha()) ){
//				
//				return true;			
//			}
//		}
//		return false;				
	}
	public static void main(String[] args) {
		Usuario u = new UsuarioDao().existe(new Usuario("r@r.com", "1", true));
		System.out.println("asf");
	}
	
	public boolean pesist(Usuario usuario){
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
		//LSUsuario.add(usuario);
	}

	public boolean desabilitarUsuario(Usuario usu){
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			usu.setAtivo(false);
			em.merge(usu);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
	}
	
	public boolean alteraUsuario(Usuario usu){
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.merge(usu);
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
		//LSUsuario.clear();
		EntityManager em = null;
		try{
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Usuario u  WHERE u.id > 0").executeUpdate();
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: LOG DO SISTEMA PARA ESSE ERRO
			em.getTransaction().rollback();	
			return false;
		}
	}
}

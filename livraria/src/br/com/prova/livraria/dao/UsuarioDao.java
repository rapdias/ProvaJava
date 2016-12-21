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

	public boolean existe(Usuario usuario) {
		
		for (Usuario u : LSUsuario) {
			if(usuario.getEmail().equals(u.getEmail()) && usuario.getSenha().equals(u.getSenha()) ){
				
				return true;			
			}
		}
		
		return false;
				
	}
	
	
	public void pesist(Usuario usuario){
		LSUsuario.add(usuario);
	}

	public void drop() {
		// TODO Auto-generated method stub
		LSUsuario.clear();
	}
}

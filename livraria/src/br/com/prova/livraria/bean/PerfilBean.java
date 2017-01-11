package br.com.prova.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.prova.livraria.dao.PerfilDao;
import br.com.prova.livraria.modelo.Perfil;

@ManagedBean
@ViewScoped
public class PerfilBean {
	
	
	private List<Perfil> listaPerfil = new ArrayList<Perfil>();
	
	
	
	public PerfilBean() {
	}

	public List<Perfil> getListaPerfil() {
		return new PerfilDao().listaTodos();
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

	
}

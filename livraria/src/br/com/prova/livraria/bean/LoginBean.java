package br.com.prova.livraria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prova.livraria.dao.PopulaBanco;
import br.com.prova.livraria.dao.UsuarioDao;
import br.com.prova.livraria.modelo.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void init() {

	}

	public String efetuaLogin() {

		PopulaBanco pb = new PopulaBanco();

		pb.fillLista();

		System.out.println("fazendo login do usuario " + this.usuario.getEmail());

		FacesContext context = FacesContext.getCurrentInstance();
		Usuario usuario = new UsuarioDao().existe(this.usuario);

		if (usuario != null) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		} else {

			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Usu�rio n�o encontrado"));

			pb.dropLista();
		}
		return "login?faces-redirect=true";
	}

	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}

package br.com.prova.livraria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prova.livraria.dao.AutorDao;
import br.com.prova.livraria.dao.PerfilDao;
import br.com.prova.livraria.dao.UsuarioDao;
import br.com.prova.livraria.modelo.Autor;
import br.com.prova.livraria.modelo.Perfil;
import br.com.prova.livraria.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	private UsuarioDao daoU = new UsuarioDao();
	private String mensagem = "";
	private boolean retorno = false;
	private Perfil perfil = new Perfil();
	private int idPerfil;

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public String gravar() {
		System.out.println("Gravando usuário " + this.usuario.getNome());

		if (this.usuario.getId() == 0) {
			this.usuario.setPerfil(new PerfilDao().buscaPorId(this.idPerfil));
			this.usuario.setAtivo(true);
			retorno = daoU.pesist(this.usuario);
		} else {
			retorno = daoU.atualiza(this.usuario);
		}

		return "usuario?faces-redirect=true";
	}

	public void remover(Usuario usu) {
		System.out.println("Removendo autor " + usu.getNome());
		daoU.desabilitarUsuario(usu);
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		return daoU.listaTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		usuario.setPerfil(new PerfilDao().buscaPorId(this.idPerfil));
		this.usuario = usuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

}

package br.com.prova.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prova.livraria.Enum.EnumMsgm;
import br.com.prova.livraria.dao.AutorDao;
import br.com.prova.livraria.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	private Integer autorId;

	private AutorDao daoA = new AutorDao();

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public void carregarAutorPelaId() {
		this.autor = daoA.buscaPorId(autorId);
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (this.autor.getId() == 0) {
		//	String m = daoA.adiciona(this.autor);
			
			FacesContext.getCurrentInstance().addMessage("Autor " + autor.getNome(),
					new FacesMessage( daoA.adiciona(this.autor)));
			
			;
		} else {
			daoA.atualiza(this.autor);
		}

		this.autor = new Autor();

		return "autor?faces-redirect=true";
	}

	public void remover(Autor autor) {
		System.out.println("Removendo autor " + autor.getNome());

		if (daoA.remove(autor)) {
			FacesContext.getCurrentInstance().addMessage("Autor " + autor.getNome(),
					new FacesMessage((daoA.remove(autor) ? ("Autor " + autor.getNome() + "\n Excluído com sucesso!")
							: ("Autor " + autor.getNome() + "Er ro ao Excluir!"))));
		}
	}

	public List<Autor> getAutores() {
		return daoA.listaTodos();
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}

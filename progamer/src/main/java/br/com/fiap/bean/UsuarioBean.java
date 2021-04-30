package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

@Named
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();

	public void save() {
		new UsuarioDao().save(this.usuario);
		System.out.println("Salvando..." + this.usuario);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Uhu! Usuário cadastrado com sucesso ;o)"));
	}
	
	public List<Usuario> getUsuarios(){
		return new UsuarioDao().getAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}

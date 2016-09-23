package br.com.foodzone.model;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioWeb implements Serializable{
	private static final long serialVersionUID = 1L;

	// objeto do tipo Usu�rio
	private Usuario logado;

	// que pode ser o id do vendedor ou id do propriet�rio
	private Integer idEntidadeUsuario;

	public Integer getIdEntidadeUsuario() {
		return idEntidadeUsuario;
	}

	public void setIdEntidadeUsuario(Integer idEntidadeUsuario) {
		this.idEntidadeUsuario = idEntidadeUsuario;
	}

	// Guarda o objeto Usu�rio
	public void fazerLogin(Usuario usuario) {
		this.logado = usuario;

		if (usuario != null) {


		}// fim if
	}

	// recupera informa��es do objeto
	// como id
	public Integer getarioId() {
		return logado.getId();
	}

	// recupera informa��es do objeto
	// como nome
	public String getNome() {
		return logado.getNome();
	}

	public void atualizaNomeUsuario() {
		// se usu�rio � um propriet�rio
		// define nome

	}

	public void setNome(String nome) {
		logado.setNome(nome);
	}

	// verifica se est� logado
	public boolean isLogado() {
		return logado != null;
	}

	// sair
	public void logout() {
		this.logado = null;
	}
}

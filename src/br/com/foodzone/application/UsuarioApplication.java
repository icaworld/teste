package br.com.foodzone.application;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.dao.UsuarioDao;
import br.com.foodzone.exception.UsuarioInvalidoException;
import br.com.foodzone.model.Usuario;
import br.com.foodzone.service.UsuarioService;

@Component
public class UsuarioApplication {

	private UsuarioDao usuarioDao;
	private UsuarioService usuarioService;

	public UsuarioApplication() {
		usuarioDao = new UsuarioDao(null);
		usuarioService = new UsuarioService(usuarioDao);
	}

	public Usuario autenticaoLogin(Usuario usuario) throws UsuarioInvalidoException {

		// valida��o
		usuarioService.validacaoLogin(usuario);

		// se v�lido retorna
		return usuarioDao.carregaUsuarioBySenha(	usuario);
	}

	public Usuario restSenha(Usuario usuario) throws UsuarioInvalidoException {
		// se v�lido retorna
		return usuarioDao.carregaUsuarioNewSenha(usuario);
	}

	public Usuario carregaUsuario(Integer idUsuario) {

		return usuarioDao.carregar(idUsuario);
	}

	public void excluirUsuario(Usuario idUsuario) {
		usuarioDao.deletar(idUsuario);
	}

	public void atualizaUsuario(Usuario usuario) {
		usuarioDao.atualizar(usuario);

	}

	public boolean validaUsuarioAdicionar(Usuario usuario) {
		return usuarioDao.validaUsuarioAdicionar(usuario);
	}

	public boolean validaUsuarioEditar(Usuario usuario) {

		return validaUsuarioEditar(usuario);
	}

	public void salvaUsuario(Usuario usuario) {

		usuarioDao.adicionar(usuario);
	}


	public String numeroTotalUsuarios(){
		
		return usuarioDao.numeroUsuarios();
	}
	
}

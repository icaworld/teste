//pacote
package br.com.foodzone.dao;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.model.Usuario;

/*
 Esta classe (UsuarioDao) anotada com @Component notifica para o Vraptor que o 
 framework se encarregar� de gerenciar suas inst�ncias,isto �, ele criar� uma inst�ncia
 e utilizar� como argumento para o construtor controller.
 */

@Component
public class UsuarioDao extends Dao<Usuario> {
	public UsuarioDao(Session session) {
		super(session);
	}

	// vari�vel gerenciador de entidades
	EntityManager gerenciadorEntidades;

	// obj: verificar se j� existe nome de usu�rio
	// Tem diferencia��o de (A) para (a) ao validar
	// valida��o de usu�rio, se nome de usu�rio j� existe ou n�o
	public boolean validaUsuarioAdicionar(Usuario usuario) {

		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nome", usuario.getNome()));
		criteria.list();
		if (!criteria.list().isEmpty()) {
			return true;// usu�rio j� registrado
		} // fim if

		// fecha conex�o
		// gerenciadorEntidades.close();

		return false;// usu�rio n�o registrado

	}// fim validaUsuario()



	// obj: carrega usu�rio, com new senha
	public Usuario carregaUsuarioBySenha(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("senha", usuario.getSenha()));
		criteria.add(Restrictions.eq("nome", usuario.getNome()));
		return (Usuario) criteria.uniqueResult();
	}
		public Usuario carregaUsuarioNewSenha(Usuario usuario) {

		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("pergunta", usuario.getPergunta()));
		criteria.add(Restrictions.eq("email", usuario.getEmail()));
		criteria.add(Restrictions.eq("tipo_pergunta", usuario.getTipoPergunta()));

		// verifica se a lista n�o est� vazia
		if (!criteria.list().isEmpty()) {

			// existe
			// carrega usu�rio
			usuario = (Usuario) criteria.list().get(0);

		} else {

			// n�o existe
			// carrega com null
			usuario = null;
		}

		// retorna usu�rio
		return usuario;

	}// fim carregaUsuario()

	// obj: retorna o n�mero total de usu�rios no sistema
	public String numeroUsuarios() {
		Criteria criteria = this.session.createCriteria(Usuario.class);
		return ""+criteria.list().size();
	}// fim numeroUsuarios()

}// fim class UsuarioDao

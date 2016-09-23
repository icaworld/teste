//pacote
package br.com.foodzone.dao;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.model.TipoEstabelecimento;
import br.com.foodzone.model.Usuario;

/*
 Esta classe (UsuarioDao) anotada com @Component notifica para o Vraptor que o 
 framework se encarregar� de gerenciar suas inst�ncias,isto �, ele criar� uma inst�ncia
 e utilizar� como argumento para o construtor controller.
 */

@Component
public class TipoEstabelecimentoDao extends Dao<TipoEstabelecimento>{
	public TipoEstabelecimentoDao(Session session) {
		super(session);
	}



	// obj: retorna o n�mero total de usu�rios no sistema
	public String numeroCadastro() {
		Criteria criteria = this.session.createCriteria(TipoEstabelecimento.class);
		return ""+criteria.list().size();
	}// fim numeroUsuarios()

}// fim class UsuarioDao

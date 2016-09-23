//pacote
package br.com.foodzone.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.model.Cidade;

/*
 Esta classe (UsuarioDao) anotada com @Component notifica para o Vraptor que o 
 framework se encarregar� de gerenciar suas inst�ncias,isto �, ele criar� uma inst�ncia
 e utilizar� como argumento para o construtor controller.
 */

@Component
public class CidadeDao extends Dao<Cidade>{
	public CidadeDao(Session session) {
		super(session);
	}



	// obj: retorna o n�mero total de usu�rios no sistema
	public String numeroCadastro() {
		Criteria criteria = this.session.createCriteria(Cidade.class);
		return ""+criteria.list().size();
	}// fim numeroUsuarios()

	@SuppressWarnings("unchecked")
	public List<Cidade> listAll() {
		Criteria criteria = this.session.createCriteria(Cidade.class);
		
		return criteria.list();
	}
}// fim class UsuarioDao

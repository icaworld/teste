//pacote
package br.com.foodzone.controller;

//import's
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.foodzone.application.UsuarioApplication;
import br.com.foodzone.intercepts.Liberado;

/* Classe controladora IndexController cont�m 
 as regras de neg�cio, com anota��o @Resource para o
 Vraptor saber que essa classe � um controller
 */

@Resource
public class IndexController {

	Result result; // mostra resultados
	UsuarioApplication usuarioApplication;

	/*
	 * Injetando depend�ncias no controller IndexController inicializando, o
	 * controller se encarregara de inst�nciar para n�s o que precisamos
	 * simplesmente declarando no par�metro do construtor
	 */

	public IndexController(Result result, UsuarioApplication usuarioApplication) {

		this.result = result;
		this.usuarioApplication = usuarioApplication;
	}// fim do contrutor

	// Acesso
	@Liberado
	// tipo de requisi��o
	@Get
	// caminho da requi��o
	@Path("/")
	public void index() {

		// define t�tulo da p�gina
		result.include("titulo", "Sistema FoodZone");

		// define atributo para a jsp
		// Numero total de usu�rios
		result.include("numeroUsuarios", usuarioApplication.numeroTotalUsuarios());

	}// fim index()

}// fim class IndexController

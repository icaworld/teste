package br.com.foodzone.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.foodzone.application.IndicadorApplication;
import br.com.foodzone.model.Indicador;
import br.com.foodzone.model.UsuarioWeb;


/*Classe controladora IndicadorController cont�m 
 as regras de neg�cio, com anota��o @Resource para o
 Vraptor saber que essa classe � um controller*/

@Resource
public class IndicadorController {

	private UsuarioWeb usuarioWeb;// mantem o estado do usu�rio
	private Result result; // mostra resultados
	private Validator validator; // valida��o
	private IndicadorApplication indicadorApplication; // usu�rio app

	// ...
	public IndicadorController(Validator validator, UsuarioWeb usuarioWeb,
			IndicadorApplication indicadorApplication, Result result) {

		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
		this.indicadorApplication = indicadorApplication;

	}// fim do construtor

	// Acesso
	@Get
	// m�todo get
	@Path("/indicador/novo")
	// url de caminho
	// l�gica de neg�cio
	public void novo() {
		// define t�tulo da p�gina
		result.include("titulo", "Adicionar de Indicador");

		// define atributo para a jsp
		// retorna uma lista de estados
//		result.include("estados", estadoApplication.listaTodosEstados());

	}// fim novo()


	@Post
	// m�todo post
	@Path("/indicador/adicionar")
	// url de caminho
	public void adicionar(Indicador indicador) {

		System.out.println("-----------------------"+ indicador.getDataInatividade());
		// define t�tulo da p�gina
		result.include("titulo", "Adicionar Usu�rio");

		try {
//			if(indicadorApplication.validaIndicadorAdicionar(indicador)){
			// processo salvar cliente
			indicadorApplication.salvaIndicador(indicador);
			
			
		} catch (Exception e) {
			// redireciona para a p�gina novo() caso houver erro na valida��o
			validator.onErrorUsePageOf(this).novo();
		}
		
		// define atributo para a jsp
		// adicionado com sucesso
		result.include("sucesso_adicionado", "Indicador " + indicador.getNome()
				+ " adicionado com sucesso!");

		// redirecionando para a p�gina novo()
		result.redirectTo(this).novo();
	}// fim adicionar()


}// fim class IndicadorController

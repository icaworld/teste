package br.com.foodzone.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.foodzone.application.TipoEstabelecimentoApplication;
import br.com.foodzone.model.TipoEstabelecimento;
import br.com.foodzone.model.UsuarioWeb;


/*Classe controladora TipoEstabelecimentoController cont�m 
 as regras de neg�cio, com anota��o @Resource para o
 Vraptor saber que essa classe � um controller*/

@Resource
public class TipoEstabelecimentoController {

	private UsuarioWeb usuarioWeb;// mantem o estado do usu�rio
	private Result result; // mostra resultados
	private Validator validator; // valida��o
	private TipoEstabelecimentoApplication tipoEstabelecimentoApplication; // usu�rio app

	// ...
	public TipoEstabelecimentoController(Validator validator, UsuarioWeb usuarioWeb,
			TipoEstabelecimentoApplication tipoEstabelecimentoApplication, Result result) {

		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
		this.tipoEstabelecimentoApplication = tipoEstabelecimentoApplication;

	}// fim do construtor

	// Acesso
	@Get
	// m�todo get
	@Path("/tipoEstabelecimento/novo")
	// url de caminho
	// l�gica de neg�cio
	public void novo() {
		// define t�tulo da p�gina
		result.include("titulo", "Adicionar Tipo de Estabelecimento");

		// define atributo para a jsp
		// retorna uma lista de estados
//		result.include("estados", estadoApplication.listaTodosEstados());

	}// fim novo()


	@Post
	// m�todo post
	@Path("/tipoEstabelecimento/adicionar")
	// url de caminho
	public void adicionar(TipoEstabelecimento tipoEstabelecimento) {

		// define t�tulo da p�gina
		result.include("titulo", "Adicionar Usu�rio");

		try {
//			if(tipoEstabelecimentoApplication.validaTipoEstabelecimentoAdicionar(tipoEstabelecimento)){
			// processo salvar cliente
			tipoEstabelecimentoApplication.salvaTipoEstabelecimento(tipoEstabelecimento);
			
			
		} catch (Exception e) {
			// redireciona para a p�gina novo() caso houver erro na valida��o
			validator.onErrorUsePageOf(this).novo();
		}
		
		// define atributo para a jsp
		// adicionado com sucesso
		result.include("sucesso_adicionado", "TipoEstabelecimento " + tipoEstabelecimento.getNome()
				+ " adicionado com sucesso!");

		// redirecionando para a p�gina novo()
		result.redirectTo(this).novo();
	}// fim adicionar()


}// fim class TipoEstabelecimentoController

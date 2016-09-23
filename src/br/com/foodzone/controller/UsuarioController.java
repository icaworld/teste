package br.com.foodzone.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.foodzone.application.UsuarioApplication;
import br.com.foodzone.exception.UsuarioInvalidoException;
import br.com.foodzone.model.Usuario;
import br.com.foodzone.model.UsuarioWeb;

/*Classe controladora UsuarioController cont�m 
 as regras de neg�cio, com anota��o @Resource para o
 Vraptor saber que essa classe � um controller*/

@Resource
public class UsuarioController {

	private UsuarioWeb usuarioWeb;// mantem o estado do usu�rio
	private Result result; // mostra resultados
	private Validator validator; // valida��o
	private UsuarioApplication usuarioApplication; // usu�rio app

	// ...
	public UsuarioController(Validator validator, UsuarioWeb usuarioWeb,
			UsuarioApplication usuarioApplication, Result result) {

		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
		this.usuarioApplication = usuarioApplication;

	}// fim do construtor

	// p�gina de login
	@Get("/login")
	public void loginForm() {

		// define t�tulo da p�gina
		result.include("titulo", "Login - Sistema FoodZone");

	}// fim login()


	// p�gina de reset
	@Get("/reset")
	public void resetForm() {

		// define t�tulo da p�gina
		result.include("titulo", "Login - Sistema FoodZone");

	}// fim login()

	// a��o de login
	@Post("/login")
	public void login(Usuario usuario) {

		Usuario usuarioValido = null;

		try {

			// condi��o que permite fazer login
			usuarioValido = usuarioApplication.autenticaoLogin(usuario);

		} catch (UsuarioInvalidoException e) {

			validator.add(new ValidationMessage(e.getMessage(), null));

		} finally {

			// redireciona para a p�gina loginForm() caso houver erro na
			// valida��o
			validator.onErrorUsePageOf(UsuarioController.class).loginForm();
			
			// permite fazer login sem erros em sess�o
			usuarioWeb.fazerLogin(usuarioValido);

		}

		// redirecionando para a index
		result.redirectTo(IndexController.class).index();

	}// fim login()

	// a��o de newSenha
	@Post("/newSenha")
	public void newSenha(Usuario usuario) {
		Usuario usuarioValido = null;
		try {
			// condi��o que permite fazer login
			usuarioValido = usuarioApplication.restSenha(usuario);
			
		} catch (UsuarioInvalidoException e) {
			
			validator.add(new ValidationMessage(e.getMessage(), null));
			
		} finally {
			
			// redireciona para a p�gina loginForm() caso houver erro na
			// valida��o
			validator.onErrorUsePageOf(UsuarioController.class).resetForm();
			
			// permite fazer login sem erros em sess�o
			usuarioWeb.fazerLogin(usuarioValido);
			
		}
		
		// redirecionando para a index
		result.redirectTo(IndexController.class).index();
		
	}// fim login()

	// a��o de sair do sistema
	@Path("/logout")
	public void logout() {

		// permite sair
		usuarioWeb.logout();

		// redirecionando para a p�gina de login
		result.redirectTo(UsuarioController.class).loginForm();

	}// fim logout()
	
	// Acesso
	@Get
	// m�todo get
	@Path("/usuario/novo")
	// url de caminho
	// l�gica de neg�cio
	public void novo() {
		// define t�tulo da p�gina
		result.include("titulo", "Adicionar Usu�rios");

		// define atributo para a jsp
		// retorna uma lista de estados
//		result.include("estados", estadoApplication.listaTodosEstados());

	}// fim novo()


	@Post
	// m�todo post
	@Path("/usuario/adicionar")
	// url de caminho
	public void adicionar(Usuario usuario) {

		// define t�tulo da p�gina
		result.include("titulo", "Adicionar Usu�rio");

		try {
			if(usuarioApplication.validaUsuarioAdicionar(usuario)){
			// processo salvar cliente
			usuarioApplication.salvaUsuario(usuario);
			
			}
		} catch (Exception e) {
			// redireciona para a p�gina novo() caso houver erro na valida��o
			validator.onErrorUsePageOf(this).novo();
		}
		
		// define atributo para a jsp
		// adicionado com sucesso
		result.include("sucesso_adicionado", "Usuario " + usuario.getNome()
				+ " adicionado com sucesso!");

		// redirecionando para a p�gina novo()
		result.redirectTo(this).novo();
	}// fim adicionar()


}// fim class UsuarioController

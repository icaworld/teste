<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Utilizando taglib core c do JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Utilizando tag jsp "include" - p/a incluir a p�gina topo.jsp dentro desta p�gina -->
<jsp:include flush="true" page="../partes/topo.jsp"></jsp:include>
<jsp:useBean id="data" class="java.util.Date" />
<div id="search">
	<form action="lista-buscar" method="post">
		<input autocomplete="off" required="required" type="text" name="busca"
			placeholder="Pesquisar usuario...">

		<button type="submit" class="tip-left">
			<i class="icon-search icon-white"></i>
		</button>
	</form>
</div>
<!-- In�cio conte�do principal -->

<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="<c:url value="/"/>" class="tip-bottom"><i
				class="icon-home"></i>In�cio</a><a href="#" class="current">${titulo}</a>
		</div>
		<h1>${titulo}</h1>
	</div>

	<!-- Alerta de erro  -->
	<c:if test="${errors != null}">
		<div class="alert alert-error alert-block">
			<a class="close" data-dismiss="alert" href="#">�</a>
			<h4 class="alert-heading">Error!</h4>
			<ul>
				<c:forEach items="${errors}" var="error">
					<li>${error.message}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	<!-- Fim alerta de erro -->

	<!-- Alerta de sucesso no cadastro -->
	<c:if test="${sucesso_adicionado != null}">
		<div class="alert alert-success alert-block">
			<a class="close" data-dismiss="alert" href="#">�</a>
			<h4 class="alert-heading">
				Sucesso! <a class="btn btn-success btn-mini"
					href="<c:url value="/usuario/listar"/>"> Listar
					Estabelecimentos</a>
			</h4>
			${sucesso_adicionado}
		</div>
	</c:if>
	<!-- Fim sucesso no cadastro  -->

	<form id="indicadorForm" action="adicionar" method="post"
		class="form-horizontal">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i>
							</span>
							<h5>Cadastro b�sico</h5>
						</div>
						<div class="widget-content nopadding">
							<div class="control-group">
								<label class="control-label">Nome :</label>
								<div class="controls">
									<input type="text" name="indicador.nome" required="required"
										class="span20" placeholder="Ex: Qualidade do servi�o prestado" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Data Inatividade:</label>
								<div class="controls">
									<input type="date" name="indicador.dataInatividade"/>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<button type="submit" class="btn btn-success">Salvar</button>
						</div>
					</div>


				</div>
			</div>

		</div>
	</form>
</div>
<!-- Fim conte�do principal -->
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.3.2.js"></script> --%>
<!-- Utilizando tag jsp "include" - p/a incluir a p�gina rodape.jsp dentro desta p�gina -->
<jsp:include page="../partes/rodape.jsp" flush="true"></jsp:include>

<!-- valida��o dos campos -->
<script type="text/javascript">
	$('#indicadorForm').validate({
		rules : {
			"indicador.nome" : {
				required : true,
				minlength : 2
			}
		}
	});
</script>


<!-- datapiker jquery -->
<script type="text/javascript">
	$(function() {
		$(".datepicker").datepicker(
				{
					changeMonth : true,
					changeYear : true,
					showButtonPanel : true,
					dateFormat : 'dd-mm-yy',
					dayNames : [ 'Domingo', 'Segunda', 'Ter�a', 'Quarta',
							'Quinta', 'Sexta', 'S�bado' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'S�b', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Mar�o', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
					nextText : 'Pr�ximo',
					prevText : 'Anterior',
					currentText : 'Hoje',
					closeText : 'Fechar'
				});
	});
</script>


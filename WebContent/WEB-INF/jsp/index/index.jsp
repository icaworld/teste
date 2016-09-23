<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Utilizando taglib core c do JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Utilizando tag jsp "include" - p/a incluir a p�gina topo.jsp dentro desta p�gina -->
<jsp:include page="../partes/topo.jsp"></jsp:include>

<!-- In�cio conte�do principal -->
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="<c:url value="/"/>" 
				class="tip-bottom"><i class="icon-home"></i> In�cio</a>
		</div>
	</div>

	<!-- Alerta de aten��o  -->
	<c:if test="${atencao != null}">
		<div class="alert alert-block">
			<a class="close" data-dismiss="alert" href="#">�</a>
			<h4 class="alert-heading">Aten��o!</h4>
			<ul>

				<li>${atencao}</li>

			</ul>
		</div>
	</c:if>
	<!-- Fim alerta de aten��o -->

	<div class="quick-actions_homepage">
		<ul class="quick-actions">
			<li><a href="<c:url value="/usuario/novo"/>"> <i class="icon-user"></i>Cadastrado Usu�rios
			</a></li>
		</ul>
	</div>
	<div class="quick-actions_homepage">
		<ul class="quick-actions">
			<li><a href="<c:url value="/tipoEstabelecimento/novo"/>"> <i class="icon-user"></i>Cadastrado de Tipos de Estabelecimentos
			</a></li>
		</ul>
	</div>
	<div class="quick-actions_homepage">
		<ul class="quick-actions">
			<li><a href="<c:url value="/indicador/novo"/>"> <i class="icon-user"></i>Cadastrado de Indicadores
			</a></li>
		</ul>
	</div>
	<div class="quick-actions_homepage">
		<ul class="quick-actions">
			<li><a href="<c:url value="/estabelecimento/novo"/>"> <i class="icon-user"></i>Cadastrado de Estabelecimento
			</a></li>
		</ul>
	</div>

</div>
<!-- Fim conte�do principal -->


<!-- Utilizando tag jsp "include" - p/a incluir a p�gina rodape.jsp dentro desta p�gina -->
<jsp:include page="../partes/rodape.jsp"></jsp:include>

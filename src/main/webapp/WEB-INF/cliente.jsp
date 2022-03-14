<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>

<body>
	<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><c:out value="${titulo}"></c:out></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link" aria-current="page" href="/">Home</a>
        <a class="nav-link active" href="#">Registro</a>
        <a class="nav-link" href="/usuario/showlogin">Login</a>
      </div>
    </div>
  </div>
</nav>
	<div class="container">
		<c:if test="${msgError != null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msgError}"></c:out>
			</div>
		</c:if>
		<h1>Formulario de Clientes</h1>
		<form:form action="/cliente/crear" method="post" modelAttribute="cliente">
			<form:label path="nombre">Nombre</form:label><br>
			<form:errors path="nombre" class="text-danger"></form:errors>
			<form:input path="nombre" class="form-control"/>
			<br>
			<form:label path="apellido">Apellido</form:label><br>
			<form:input path="apellido" class="form-control"/>
			<br>
			<form:label path="correo">Correo</form:label>
			<form:input path="correo" class="form-control"/>
			<br>
			
			<input type="submit" class="btn btn-primary" value="Enviar">

		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>

</html>
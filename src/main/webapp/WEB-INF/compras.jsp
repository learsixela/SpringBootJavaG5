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
<title>Compras</title>
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
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link" aria-current="page" href="/">Home</a> <a
						class="nav-link active" href="#">Registro</a> <a class="nav-link"
						href="/usuario/showlogin">Login</a>
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
		<h1>Formulario de compras</h1>
		<form:form action="/compra/crear" method="post"
			modelAttribute="compra">
			<form:label path="cliente">Cliente</form:label>
			<br>
			<form:select path="cliente" class="form-select">
				<c:forEach items="${listaClientes}" var="cliente">
					<form:option value="${cliente.id}"><c:out value="${cliente.nombre}"></c:out> </form:option>
				</c:forEach>
			</form:select>
			<br>
			<form:label path="fecha">Fecha</form:label>
			<br>
			<form:input type="date" path="fecha" class="form-control" />
			<br>
			<form:label path="monto">Monto</form:label>
			<br>
			<form:input path="monto" class="form-control" />
			<br>
			<br>
			<input type="submit" class="btn btn-primary"
				value="Crear compra">

		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>

</html>
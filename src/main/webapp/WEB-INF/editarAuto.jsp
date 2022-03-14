<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Auto</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Dinamic Web Project</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/auto/home">Home</a></li>
				</ul>
				<form class="d-flex">
					<div class="btn-group dropstart">
						<button type="button" class="btn btn-secondary dropdown-toggle"
							data-bs-toggle="dropdown" aria-expanded="false">
							Usuario</button>
						<ul class="dropdown-menu" style="">
							<li><a class="dropdown-item" href="#">Editar</a></li>
							<li><a class="dropdown-item" href="#">Inicio</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Cerrar Sesión</a></li>
						</ul>
					</div>
				</form>
			</div>
		</div>
	</nav>
	<div class="container">
	<form:form action="/auto/actualizar/${auto.id}" method="post" modelAttribute="auto">
		<form:label path="marca">Marca:</form:label><br>
		<form:input path="marca" class="form-control"/><br>
		
		<form:label path="motor">Motor</form:label><br>
		<form:input path="motor" class="form-control"/><br>
		
		<form:label path="color">Color</form:label><br>
		<form:input path="color" class="form-control"/><br>
		
		<form:label path="velocidad">Velocidad</form:label><br>
		<form:input path="velocidad" class="form-control"/><br>
		
		<input type="submit" class="btn btn-outline-primary" value="Editar Auto">
	
	</form:form>
	
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
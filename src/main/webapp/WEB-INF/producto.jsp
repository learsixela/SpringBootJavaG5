<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Producto</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>Crear Producto</h1>
	<form:form action="/producto/insertar" method="post" modelAttribute="producto">
		<form:label path="nombre">Nombre:</form:label><br>
		<form:input path="nombre" class="form-control"/><br>
		
		<form:label path="descripcion">Descripcion</form:label><br>
		<form:input path="descripcion" class="form-control"/><br>
		
		<form:label path="precio">Precio</form:label><br>
		<form:input path="precio" class="form-control"/><br>
		
		<input type="submit" class="btn btn-outline-primary" value="Insertar Producto">
	
	</form:form>
	
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Auto</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>Crear Auto</h1>
	<form:form action="/autito/insertar" method="post" modelAttribute="auto">
		<form:label path="marca">Marca:</form:label><br>
		<form:input path="marca" class="form-control"/><br>
		
		<form:label path="motor">Motor</form:label><br>
		<form:input path="motor" class="form-control"/><br>
		
		<form:label path="color">Color</form:label><br>
		<form:input path="color" class="form-control"/><br>
		
		<form:label path="velocidad">Velocidad</form:label><br>
		<form:input path="velocidad" class="form-control"/><br>
		
		<input type="submit" class="btn btn-outline-primary" value="Insertar Auto">
	
	</form:form>
	
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
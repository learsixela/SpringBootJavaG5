<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<a class="btn btn-outline-primary" href="/autito/crear" role="button">Crear Auto</a>
	<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Marca</th>
					<th scope="col">Motor</th>
					<th scope="col">Color</th>
					<th scope="col">Velocidad</th>
					<th scope="col-2">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaAutos}" var="auto">
					<tr>
						<th scope="row">${auto.id}</th>
						<td>${auto.marca}</td>
						<td>${auto.motor}</td>
						<td>${auto.color}</td>
						<td>${auto.velocidad}</td>
						<td>
							<a class="btn btn-outline-info" href="/autito/editar/${auto.id}" role="button">Editar</a>
						 	<a class="btn btn-outline-danger" href="/autito/eliminar/${auto.id}" role="button">Eliminar</a>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
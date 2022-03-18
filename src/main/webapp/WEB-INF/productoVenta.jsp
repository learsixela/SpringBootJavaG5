<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Lista de Autos</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<title>Home::</title>
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
							data-bs-toggle="dropdown" aria-expanded="false">Usuario</button>
						<ul class="dropdown-menu" style="">
							<li><a class="dropdown-item" href="#">Editar</a></li>
							<li><a class="dropdown-item" href="#">Inicio</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="/usuario/logout">Cerrar
									Sesión</a></li>
						</ul>
					</div>
				</form>
			</div>
		</div>
	</nav>

	<div class="container">

		<form action="/productoVenta/insertar/${venta.id}" method="post">
			<div class="mb-3">
				<label for="producto" class="form-label">Producto</label> <select
					name="producto">
					<c:forEach items="${listaProducto}" var="prod">
						<option value="${prod.id}">
							<c:out value="${prod.nombre}"></c:out>
						</option>
					</c:forEach>
				</select>

			</div>
			<div class="mb-3">
				<label for="cantidad" class="form-label">Cantidad</label> <input
					type="number" class="form-control" id="cantidad" name="cantidad">
			</div>

			<button type="submit" class="btn btn-primary">Agregar
				Producto</button>
		</form>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Cantidad</th>
					<th scope="col">Precio</th>
					<th scope="col">Total</th>
					<th scope="col">Producto</th>
					<th scope="col">Venta</th>
					<th scope="col">Accion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaProductoVenta}" var="pvta">

					<tr>
						<th scope="row"><c:out value="${pvta.id}"></c:out></th>
						<td><c:out value="${pvta.cantidad}"></c:out></td>
						<td><c:out value="${pvta.precioProducto}"></c:out></td>
						<td><c:out value="${pvta.precioVenta}"></c:out></td>
						<td><c:out value="${pvta.producto.nombre}"></c:out></td>
						<td><c:out value="${pvta.venta.id}"></c:out></td>
						<td><a
							href="/productoVenta/${venta.id}/eliminar/${pvta.id}">
								<button type="button" id="btn4" class="btn btn-danger">Eliminar</button>
						</a></td>

					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4"></td>
					<td colspan="3">Total: $ <c:out value="${venta.montoTotal}"></c:out></td>
					<td></td>
				</tr>
			</tfoot>
		</table>
		<br>
		<hr>
	</div>
	<!-- Footer -->
	<footer class="container-fluid bg-4 text-center">
		<p>
			Desafio Latam <a href="https://www.desafiolatam.com">www.desafiolatam.com</a>
		</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>
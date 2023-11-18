<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<title>Home page Fintech</title>
<body>

	<form action="despesa" name="despesa" method="post">
		<label>Cadastro de despesas</label>
		<div style="margin-top: 20px;">
			<div>
				<label>Informe o tipo</label>
			</div>
			<div>
				<input type="text" name="tipoText">
			</div>
		</div>
		<div style="margin-top: 20px;">
			<div>
				<label>Informe o valor</label>
			</div>
			<div style="">
				<input type="number" name="valorText">
			</div>
		</div>

		<div style="margin-top: 20px;">
			<input type="submit" />
		</div>
	</form>


	<label>Lista de despesas</label>
	<table>
		<!-- here should go some titles... -->
		<tr>
			<th>Id</th>
			<th>Tipo</th>
			<th>Valor</th>
		</tr>
		<c:forEach items="${despesas}" var="item">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.tipo}" /></td>
				<td><c:out value="${item.valor}" /></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>
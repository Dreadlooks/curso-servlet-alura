<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Company</title>
</head>
<c:if test="${not empty empresa}">
	<p>Empresa ${empresa} cadastrada com sucesso!</p>
	<br />
</c:if>
<body>
	<table border="1px solid black">
		<tr>
			<td>Empresas</td>
			<td>Data de abertura</td>
			<td>Atualizar</td>
			<td>Remover</td>
		</tr>

		<c:forEach items="${list}" var="company">
			<tr>
				<td>${company.name}</td>
				<td><fmt:formatDate value="${company.openingDate.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="/curso-servlet-alura/company-detail?id=${company.id}">atualiza</a></td>
				<td><a href="/curso-servlet-alura/company-remove?id=${company.id}">remove</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updating Company</title>
</head>
<body>
	<form action="update-company" method="post">
		<input type="hidden" id="id" name="id" value="${company.id}"> 
		
		<label for="name">Nome da empresa:</label> <input type="text" 
			id="name" name="name" value="${company.name}"> 
			
			<br /> <br /> 
			
			<label for="openingDate">Data de abertura:</label> 
			<input type="text" id="openingDate" name="openingDate"
			 value="<fmt:formatDate value="${company.openingDate.time}"
			 pattern="dd/MM/yyyy"/>">
			  
			<br /> 
			<input type="submit" value="Enviar">
	</form>
</body>
</html>
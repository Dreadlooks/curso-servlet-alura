<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form fj-21</title>
</head>
<body>
<form action="newCompany" method="post">
	<label for="name">Nome da empresa:</label>
	<input type="text" id="name" name="name">
	<br/>
	<br/>
	<label for="openingDate">Data de abertura:</label>
	<input type="date" id="openingDate" name="openingDate">
	<br/>
	<input type="submit" value="Enviar">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = (String) request.getAttribute("company");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Company</title>
</head>
<body>
	<%-- <p>Empresa <%= name %> cadastrada com sucesso!</p> --%>
	<p>Empresa ${company} cadastrada com sucesso!</p>
</body>
</html>
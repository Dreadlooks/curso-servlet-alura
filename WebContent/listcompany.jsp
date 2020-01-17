<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List, 
br.com.alura.generator.models.Company"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de empresas</title>
</head>
<body>
	<table border="1px solid black">
		<tr>
			<td>Empresas</td>
		</tr>
			<%
				List<Company> list = (List<Company>) request.getAttribute("list");
				for (Company company : list) {
			%>
			<tr>
				<td><%=company.getName()%></tr>
			</tr>
			<%
				}
			%>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>${i}</p>
	</c:forEach>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<%--  Utilizamos los tags jstl para utilizar rutas dinámicas   --%>
 <a href="<c:url value="/profesor"/>">Agregar profesor</a>
</body>
</html>
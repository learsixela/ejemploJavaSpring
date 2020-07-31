<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 31-07-2020
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Profesor</title>
</head>
<body>
<h1>
    <c:out value="${profesorModelo}"></c:out>
    <a href="<c:url value="/"/>">Volver</a>
</h1>
<%--
    '${pageContext.request.contextPath}' establece una ruta dinámica antes
    de definir la ruta del controller. En esencia es lo mismo que el tag
    JSTL.
--%>
<form:form action="${pageContext.request.contextPath}/profesor/add" method="post" modelAttribute="profesorModelo">
    <label for="name">Nombre:</label>
    <form:input id="name" path="nombrecito"></form:input>
    Edad:   <form:input path="age"></form:input>
    <button type="submit">Registrarme</button>
</form:form>
</body>
</html>

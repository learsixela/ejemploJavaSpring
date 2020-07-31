<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 31-07-2020
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/profesor/update/done" method="post" modelAttribute="profesorModelo">
    <%--
        Utilizamos campos invisibles para poder traspasar el id y cursos
        del profesor a actualizar
    --%>
    <form:input path="id" cssStyle="display: none"></form:input>
    <form:input path="cursosLista" cssStyle="display: none"></form:input>

    <label for="name">Nombre:</label>
    <form:input id="name" path="nombrecito"></form:input>
    Edad:   <form:input path="age"></form:input>
    <button type="submit">Actualizar</button>
</form:form>
</body>
</html>

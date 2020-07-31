<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 31-07-2020
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Adherido</title>
</head>
<body>
<h1>
    <%--  Utilizamos el objeto de sesión guardado  --%>
    <c:out value="Hola, ${sessionScope.profesorSession}"></c:out>
</h1>
<a href="<c:url value="/profesor/logout"/> ">Logout</a>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Edad</th>
        <th>Cursos</th>
        <th colspan="2">Acciones</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%--   Utilizamos el objeto almacenado en el model    --%>
        <td>${profesorModelo.id}</td>
        <td>${profesorModelo.nombrecito}</td>
        <td>${profesorModelo.age}</td>
        <td>${profesorModelo.cursosLista}</td>
        <td colspan="2">
            <a href="<c:url value="/profesor/update"/>">Actualizar</a>
            <a href="<c:url value="/profesor/delete"/>">Borrar</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>

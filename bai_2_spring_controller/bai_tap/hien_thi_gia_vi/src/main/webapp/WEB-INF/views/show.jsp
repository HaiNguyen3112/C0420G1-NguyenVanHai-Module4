<%--
  Created by IntelliJ IDEA.
  User: Minh Nguyen
  Date: 21/8/2020
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/sandwich/save">
    <p>
        <input type="checkbox" name="condiment" value="Lettuce">Lettuce</input>
        <input type="checkbox" name="condiment" value="Tomato">Tomato</input>
        <input type="checkbox" name="condiment" value="Mustard">Mustard</input>
        <input type="checkbox" name="condiment" value="Sprouts">Sprouts</input>
    </p>
    <input type="submit" name="submit" value="Save">
    <hr>
    <h2>Condiment List</h2>
    <c:forEach var="condiment" items="${condiments}">
        <c:out value="${condiment}"></c:out> <br>
    </c:forEach>
</form>



</body>
</html>

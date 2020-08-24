<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Minh Nguyen
  Date: 24/8/2020
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>List Email</h3>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
    </tr>
    <c:forEach var="email" items="${emailMap}">
        <tr>
            <td>${email.getId()}</td>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>

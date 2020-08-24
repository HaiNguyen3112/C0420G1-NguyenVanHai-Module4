<%--
  Created by IntelliJ IDEA.
  User: Minh Nguyen
  Date: 22/8/2020
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h2>List Email</h2>
<form:form action="/addEmail" method="post" modelAttribute="email">
    <table>
        <tr>
            <td>
                <form:hidden path="id"/>
            </td>
        </tr>
        <tr>
            <td>Language</td>
            <td>
                <form:select path="language" items="${languageList}"/>
<%--                <select name="language">--%>
<%--                    <option>English</option>--%>
<%--                    <option>Vietnamese</option>--%>
<%--                    <option>Japanese</option>--%>
<%--                    <option>Chinese</option>--%>
<%--                </select>--%>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>
                <form:select path="pageSize" items="${pageSizeList}"/>
<%--                <select name="pageSize">--%>
<%--                    <option>5</option>--%>
<%--                    <option>10</option>--%>
<%--                    <option>15</option>--%>
<%--                    <option>25</option>--%>
<%--                    <option>50</option>--%>
<%--                    <option>100</option>--%>
<%--                </select>--%>
            </td>
        </tr>
        <tr>
            <td>Spams Filter</td>
            <td>
                <form:checkbox path="spamsFilter" />
<%--                <input type="checkbox" name="spamsFilter" >Enable spams filter</input>--%>
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea path="signature"/>
<%--                <textarea name="signature"></textarea>--%>
            </td>
        </tr>
        <tr>
            <td><input type="submit" name="sumit" value="Update"></td>
            <td>
                <a href="/create"><input type="button" value="Delete"></a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Minh Nguyen
  Date: 21/8/2020
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator/result">
<table>

    <input type="text" name="value1">
    <input type="text" name="value2">

    <tr>
        <td><input type="submit" name="cal" value="Addition(+)"></td>
        <td><input type="submit" name="cal" value="Subtraction(-)"></td>
        <td><input type="submit" name="cal" value="Multiplication(*)"></td>
        <td><input type="submit" name="cal" value="Division(/)"></td>
    </tr>
</table>
</form>
<p>Result ${calcu}: ${result}</p>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kbual
  Date: 12/16/2023
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login-form" method="post">
    <label>Username : </label> <input type="text" name="username"/>
    <label>Password : </label> <input type="password" name="password"/>
    <h3>${message}</h3>
    <input type="submit" value="Submit">
    <a href="customer-list">Customer List</a>
</form>
<hr>
</body>
</html>

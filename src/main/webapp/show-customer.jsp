<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kbual
  Date: 12/18/2023
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Customer</title>
</head>
<body>
    <h1>List Customer</h1>
    <h4>${message}</h4>
    <c:if test="${username != null}">
        <form action="logout" method="post">
            <input type="submit" value="LOGOUT">
        </form>
    </c:if>
    <div>
        <c:forEach items="${customers}" var="customerItem">
            <p>${customerItem.customer.customerName}</p>
            <p>${customerItem.quantity}</p>
        </c:forEach>
    </div>
</body>
</html>

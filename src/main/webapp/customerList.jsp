<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kbual
  Date: 12/16/2023
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <h2>Customer List::</h2>
    <c:if test="${username != null}">
        <form action="logout" method="post">
            <input type="submit" value="LOGOUT">
        </form>
    </c:if>
    <hr>
    <h3>Find By Name</h3>
    <form action="customer-list" method="post">
        <input type="text" name="name">
        <input type="submit" value="Search">
    </form>
    <div>
        <form action="view-cart" method="get">
            <input type="submit" value="SHOW LIST">
        </form>
    </div>
    <h3>${message}</h3>
    <div>
        <c:if test="${customer == null}">
            <c:forEach items="${customers}" var="customer">
            <h5>${customer.customerName}</h5>
                <form action="add-to-cart" method="post">
                    <input type="hidden" name="customerNumber" value="${customer.customerNumber}">
                    <input type="submit" value="ADD TO CART">
                </form>
            </c:forEach>
        </c:if>

        <c:if test="${customer != null}">
            <h5>${customer.customerName}</h5>
            <form action="add-to-cart" method="post">
                <input type="hidden" name="customerNumber" value="${customer.customerNumber}">
                <input type="submit" value="ADD TO CART">
            </form>
        </c:if>
    </div>
</body>
</html>

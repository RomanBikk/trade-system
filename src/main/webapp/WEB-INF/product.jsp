<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23.09.2019
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <%@include file="header.jsp"%>
</head>
<body>
Products:<br><br>
<table>
    <tr>
    <th>ID</th>
    <th>NAME</th>
    </tr>
<c:forEach var="product" items="${products}">
    <tr>
        <td> ${product.id}</td>
        <td> ${product.name}</td>
        <td> ${product.description}</td>
        <td>${product.categoryId}</td>
    </tr>
</c:forEach>
</table>
<br>
Product saving: <br><br>
<form id ="product_save" method="post">
    Product name: <input type="text" name="name"><br><br>
    Description: <input type="text" name="description"><br><br>
    <select name="category">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
</form>

</body>
</html>

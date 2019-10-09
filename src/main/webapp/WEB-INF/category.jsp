<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.09.2019
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
 <%@include file="header.jsp"%>
</head>
<body>
Categories:<br><br>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td> ${category.id}</td>
            <td> ${category.name}</td>
        </tr>
    </c:forEach>
</table>
<br>
Category saving: <br><br>
<form id ="category_save" method="post">
    Category name: <input type="text" name="name"><br><br>
    <input id="send category" type="submit">
</form>

</body>
</html>


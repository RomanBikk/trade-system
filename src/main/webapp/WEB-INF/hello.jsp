<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18.09.2019
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello, ${sessionScope.name} (session scope)
Hello, ${requestScope.name} (request scope)
</body>
</html>

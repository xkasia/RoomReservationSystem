<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.01.2019
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="../elements/menu.jsp"/>

<h1> Your Data:</h1>

<div>First name: ${user.firstName}</div>

<div>Last Name: ${user.lastName}</div>

<div>Login: ${user.login}</div>

<div>Password: ${user.password}</div>

<li><a href="update">Update your Data.</a></li>

<li><a href="delete">Delete account.</a></li>


</body>
</html>

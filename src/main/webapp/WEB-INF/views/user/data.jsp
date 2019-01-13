

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Your data</title>
<jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>

<div class="container">

<div class="row center"><h2>Your data:</h2>

<div>First name: ${user.firstName}</div>

<div>Last Name: ${user.lastName}</div>

<div>Login: ${user.login}</div>

<div>Password: ${user.password}</div>

</br>
</br>

<a href="update">Update your Data.</a> </br>

<a href="delete">Delete account.</a>
</div>

</div>
</body>
</html>



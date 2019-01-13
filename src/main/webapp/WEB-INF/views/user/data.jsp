

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<jsp:include page="../elements/menu.jsp"/>--%>

<%--<h1> Your Data:</h1>--%>

<%--<div>First name: ${user.firstName}</div>--%>

<%--<div>Last Name: ${user.lastName}</div>--%>

<%--<div>Login: ${user.login}</div>--%>

<%--<div>Password: ${user.password}</div>--%>

<%--<li><a href="update">Update your Data.</a></li>--%>

<%--<li><a href="delete">Delete account.</a></li>--%>


<%--</body>--%>


<%--</html>--%>

<%--</body>--%>

<%--</html>--%>



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

<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.01.2019
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>


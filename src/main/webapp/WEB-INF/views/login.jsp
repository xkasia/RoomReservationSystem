<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.01.2019
  Time: 07:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<jsp:include page="elements/menu.jsp"/>

<h1>Login</h1>
<p>Please give your data</p>
<title>Register form</title>
<form method="post" action="/home/login">
    Login <input name="login", type="text", maxlength="100", required="required"> </br>  </br>
    Password <input name="password", type="password", minlength="6", maxlength="100", required="required"> </br>  </br>
    <fieldset>
        <input type="submit" value="Login"/> <input type="reset" value="Reset"/>
    </fieldset>
</form>
Create account.
</body>
</html>

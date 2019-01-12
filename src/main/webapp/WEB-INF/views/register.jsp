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

<h1>Register</h1>
<p>Please fill in this form to create an account.</p>
<title>Register form</title>
<form method="post" action="/home/register">
    Name <input name="firstName", type="text", maxlength="50", required="required">  </br>  </br>
    Last Name <input name="lastName", type="text", maxlength="100", required="required"> </br>  </br>
    Password <input name="password", type="password", minlength="6", maxlength="100", required="required"> </br>  </br>
    login <input name="login", type="text", maxlength="100", required="required" > </br>  </br>
    <fieldset>
        <input type="submit" value="Register"/>
    </fieldset>
</form>
</body>
</html>

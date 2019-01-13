

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h2>Create account</h2>
        <form method="post" action="/home/login">
            Login <input name="login", type="text", maxlength="100", required="required"> </br>  </br>
            Password <input name="password", type="password", minlength="6", maxlength="100", required="required"> </br>  </br>
            <fieldset>
                <input type="submit" value="Login"/> <input type="reset" value="Reset"/>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>


<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login page</title>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h2>Login</h2>
        <f:form modelAttribute="user" method="post" action="/login">
            <p>Login:* <f:input path="login" type="text"/>
                <f:errors path="login"/> </p>
            <p>Password:* <f:input path="password" type="password"/>
                <f:errors path="password"/> </p>
            <p><input type="submit" value="Submit"/></p> </f:form>
        </br>
        <h6 style="color:red;">${errorMsg}</h6>
    </div>
</div>
</body>
</html>



<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login page</title>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/>
<div class="container">
    <div class="row center">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <title>Register form</title>

        <f:form modelAttribute="user" method="post" action="/register">
            <p>First name:*<f:input path="firstName" type="text"/>
                <f:errors path="firstName"/> </p>
            <p>Last name:*<f:input path="lastName" type="text"/>
                <f:errors path="lastName"/> </p>
            <p>Password:* <f:input path="password" type="password"/>
                <f:errors path="password"/> </p>
            <p>Login:* <f:input path="login" type="text"/>
                <f:errors path="login"/> </p>
            <p><input type="submit" value="Submit"/></p> </f:form>
        </br>
        <h6 style="color:red;">${errorMsg}</h6>
    </div>
</div>
</body>
</html>

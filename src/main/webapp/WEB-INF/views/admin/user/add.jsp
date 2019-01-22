
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div class="container">
    <div class="row center">
        <h3>Please fill in this form to create new user.</h3>
        <title>Register form</title>
        <f:form modelAttribute="user" method="post" action="/admin/user/add">
            <p>First name:*<f:input path="firstName" type="text"/>
                <f:errors path="firstName"/> </p>
            <p>Last name:*<f:input path="lastName" type="text"/>
                <f:errors path="lastName"/> </p>
            <p>Password:* <f:input path="password" type="password"/>
                <f:errors path="password"/> </p>
            <p>Login:* <f:input path="login" type="text"/>
                <f:errors path="login"/> </p>
            <p><input type="submit" value="Create"/></p> </f:form>

        <h6 style="color:red;">${errorMsg}</h6>
    </div>
</div>
</body>
</html>

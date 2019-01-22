
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update data</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h4>Please give new data</h4>
        <title>Update form</title>
        <f:form modelAttribute="updatedUser" method="post" action="/admin/user/update">
            <p>Current first name: ${user.firstName}: <f:input path="firstName" type="text"/>
                <f:errors path="firstName"/> </p>
            <p>Current last name: ${user.lastName}: <f:input path="lastName" type="text"/>
                <f:errors path="lastName"/> </p>
            <p>Current password: ${user.password}: <f:input path="password" type="password"/>
                <f:errors path="password"/> </p>
            <p><input type="submit" value="Update"/></p> </f:form>
    </div>
</div>
</body>
</html>

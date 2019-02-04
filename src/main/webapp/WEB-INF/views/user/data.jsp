
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Your data</title>
<jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>

<div class="container">

<div class="row center"><h2>Your data:</h2>

First name: ${user.firstName}</br>

Last Name: ${user.lastName}</br>

Login: ${user.login}</br>

Password: ${user.password}</br>

</br>
</br>

<a href="update">Update your Data.</a> </br>

<a href="delete">Delete account.</a>

    <h6 style="color:limegreen;">${updateUserMsg}</h6>
</div>

</div>
</body>
</html>



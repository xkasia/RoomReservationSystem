<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.01.2019
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>

<jsp:include page="../elements/menu.jsp"/>

<p>Are you sure, that you want to delete your account?</p>
<body>
<form method="post" action="/user/delete">
        <input type="radio" name="delete" value="yes" id = "yes"> Yes, delete my account.<br>
        <input type="radio" name="delete" value="no" id = "no" checked> No. <br>

    <fieldset>
        <input type="submit" value="Submit"/>
    </fieldset>
</form>

</body>
</html>

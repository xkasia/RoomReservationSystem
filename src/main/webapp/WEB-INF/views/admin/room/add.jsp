<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 11.01.2019
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>

<jsp:include page="../../elements/menu.jsp"/>

<h1>Create new room.</h1>
<p>Please fill in this form to create new room.</p>
<title>Register form</title>
<form method="post" action="/admin/room/add">
    Name <input name="name", type="text", maxlength="50", required="required">  </br>  </br>
    Location <input name="location", type="text", maxlength="256"> </br>  </br>
    Number of seats <input name="numberOfSeats", type="number", maxlength="100" required="required", min="0"> </br>  </br>
    <p>Does this room have projector?</p>
    <input type="radio" name="projector" value="yes" id = "yes"> Yes.<br>
    <input type="radio" name="projector" value="no" id = "no" checked> No. <br>
    Phone number <input name="phoneNumber", type="text", maxlength="100"> </br>  </br>
    <fieldset>
        <input type="submit" value="Create"/>
    </fieldset>
</form>


</body>
</html>


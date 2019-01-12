<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 11.01.2019
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Update</title>
</head>
<body>


<jsp:include page="../../elements/menu.jsp"/>

<p>Please give new data</p>

<form method="post" action="/admin/room/update">
    Name <input name="name", type="text", maxlength="50", required="required">  </br>  </br>
    Location <input name="location", type="text", maxlength="256"> </br>  </br>
    Number of seats <input name="numberOfSeats", type="number", maxlength="100", min="0"> </br>  </br>
    <p>Does this room have projector?</p>
    <input type="radio" name="projector" value="yes" id = "yes"> Yes.<br>
    <input type="radio" name="projector" value="no" id = "no" checked> No. <br>
    Phone number <input name="phoneNumber", type="text", maxlength="100"> </br>  </br>
    <fieldset>
        <input type="submit" value="Update"/>
    </fieldset>
</form>


</body>
</html>

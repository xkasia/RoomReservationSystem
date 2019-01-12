<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 11.01.2019
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Reserve room</title>
    <jsp:include page="../elements/menu.jsp"/>
</head>
<body>

<form method="post" action="/reservation/make">

    <div>
            <P>Select Room to book.</P>
            <c:forEach items="${room}" var="r">
            <input type="radio" name="name" value="${r.name}" id = "name" required="required">
               <li>Name:  ${r.name}</li>
                <li>Location : ${r.location}</li>
                <li>Number of Seats: ${r.numberOfSeats}</li>
                <li>Projector: ${r.projector  ? 'Yes' : 'No'}</li>
                <li>Phone number: ${r.phoneNumber}</li>
                <br>
            </c:forEach>
        </select>
    </div>

    <div>
        Reservation start date:
        <input type="datetime-local" name="startTime" required = required> </br>
        Reservation end date:
        <input type="datetime-local" name="endTime" required="required">

    </div>

    <fieldset>
        <input type="submit" value="Submit"/>
    </fieldset>
</form>

</body>
</html>

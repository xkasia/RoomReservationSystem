<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ALL RESERVATIONS</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>
<div class="container">
    <form method="post" action="/reservation/show/all">
        <div>
            </br>
            Reservations from date:
            <input type="datetime-local" name="startTime"> </br>
            Reservations to date:
            <input type="datetime-local" name="endTime">
        </div>
        <fieldset>
            <input type="submit" value="Submit"/>
        </fieldset>
    </form>
    <div class="row center"><h2>All Reservations</h2>
        <table>
            <thead>
            <tr>
                <th>Room Name</th>
                <th>Owner</th>
                <th>Start time</th>
                <th>End time</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reservations}" var="reservation">
                <tr>
                    <td>${reservation.room.name}</td>
                    <td>${reservation.user.firstName} ${reservation.user.lastName}</td>
                    <td>${reservation.reservationStart}</td>
                    <td>${reservation.reservationEnd}</td>
                    <td>
                        <a href="/reservation/delete/${reservation.id}">Delete.</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

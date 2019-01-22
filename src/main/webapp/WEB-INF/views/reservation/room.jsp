
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Room bookng schedule </title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>

<div>
    <form method="post" action="/reservation/show/room">
        <div>
            <P>Please choose the room in order to show his booking schedule:</P>
            <div class="input-field s6">
                <select class="browser-default waves-effect waves-light btn" required="required" name="name" id="name">=
                    <option value="" disabled="" selected="">Choose your option</option>
                    <c:forEach items="${room}" var="r">
                        <option value="${r.name}"> ${r.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div>
            Reservation start date:
            <input type="datetime-local" name="startTime"> </br>
            Reservation end date:
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
                    <td><a href="/user/delete/reservation/${reservation.id}">Delete.</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>
</body>
</html>

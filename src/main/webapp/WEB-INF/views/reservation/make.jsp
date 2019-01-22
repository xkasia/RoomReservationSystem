
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Reserve room</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>

<div>
<form method="post" action="/reservation/make">
            <div>
                <P>Select Room to book.</P>
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
                <input type="datetime-local" name="startTime" required = required> </br>
                Reservation end date:
                <input type="datetime-local" name="endTime" required="required">
            </div>
            <fieldset>
                <input type="submit" value="Submit"/>
            </fieldset>
        </form>

    <h6 style="color:red;">${bookingErrorMsq}</h6>

    <div class="row center"><h2>Available Rooms</h2>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Location</th>
                <th>Number of seats</th>
                <th>Projector</th>
                <th>Phone number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${room}" var="room">
                <tr>
                    <td>${room.id}.</td>
                    <td>${room.name}</td>
                    <td>${room.location}</td>
                    <td>${room.numberOfSeats}</td>
                    <td>${room.projector  ? 'Yes' : 'No'}</td>
                    <td>${room.phoneNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>
</body>
</html>

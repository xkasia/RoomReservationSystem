<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL RESERVATIONS</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>
<div class="container">
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
                    <td>${reservation.user.login}</td>
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

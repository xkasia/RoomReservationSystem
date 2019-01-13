<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 13.01.2019
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL RESERVATIONS</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h2>Your Reservations</h2>
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
                    <td><a href="/user/delete/reservation/${reservation.id}">Delete.</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>










<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--</head>--%>
<%--<body>--%>

<%--<jsp:include page="../../elements/menu.jsp"/>--%>

<%--<div class="row center"><h2>Your RESERVATIONS</h2>--%>

    <%--<table>--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th>Room Name</th>--%>
            <%--<th>Owner</th>--%>
            <%--<th>Start time</th>--%>
            <%--<th>End time</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody>--%>
        <%--<c:forEach items="${reservations}" var="reservation">--%>
            <%--<tr>--%>
                <%--<td>${reservation.room.name}</td>--%>
                <%--<td>${reservation.user.login}</td>--%>
                <%--<td>${reservation.reservationStart}</td>--%>
                <%--<td>${reservation.reservationEnd}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <%--</tbody>--%>
    <%--</table>--%>
<%--</div>--%>

<%--</body>--%>

<%--</html>--%>

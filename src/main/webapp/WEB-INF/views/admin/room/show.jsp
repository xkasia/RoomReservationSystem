<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 11.01.2019
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>


<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Rooms</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h2>All Rooms</h2>
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
                    <td><a href="/admin/room/update/${room.id}">Update.</a></td>
                    <td><a href="/admin/room/delete/${room.id}">Delete.</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <a href="/admin/room/add">Add new room.</a>
    </div>
</div>
</body>
</html>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<html>--%>
<%--<head>--%>

    <%--<jsp:include page="../../elements/menu.jsp"/>--%>

    <%--<div class="row center"><h2>ALL ROOMS</h2>--%>
        <%--<table>--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th>Id</th>--%>
                <%--<th>Name</th>--%>
                <%--<th>Location</th>--%>
                <%--<th>Number of seats</th>--%>
                <%--<th>Projector</th>--%>
                <%--<th>Phone number</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--<c:forEach items="${room}" var="room">--%>
                <%--<tr>--%>
                    <%--<td>${room.id}.</td>--%>
                    <%--<td>${room.name}</td>--%>
                    <%--<td>${room.location}</td>--%>
                    <%--<td>${room.numberOfSeats}</td>--%>
                    <%--<td>${room.projector  ? 'Yes' : 'No'}</td>--%>
                    <%--<td>${room.phoneNumber}</td>--%>
                    <%--<td><a href="/admin/room/update/${room.id}">Update.</a></td>--%>
                    <%--<td><a href="/admin/room/delete/${room.id}">Delete.</a></td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>
        <%--</table>--%>

        <%--<a href="/admin/room/add">Add new room.</a>--%>
    <%--</div>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>

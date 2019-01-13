<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 11.01.2019
  Time: 08:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Users</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h2>All Users</h2>
        <table>
            <thead>
            <tr>
                <th>Lp.</th>
                <th>First name</th>
                <th>Last Name</th>
                <th>Login</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${user}" var="user" varStatus="status">
                <tr>
                    <td>${status.index + 1}.</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.login}</td>
                    <td><a href="/admin/user/update/${user.login}">Update.</a>
                    </td>
                    <td><a href="/admin/user/delete/${user.login}">Delete.</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

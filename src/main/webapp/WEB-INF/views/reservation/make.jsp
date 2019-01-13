<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 11.01.2019
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>


<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</div>
</div>
</body>
</html>

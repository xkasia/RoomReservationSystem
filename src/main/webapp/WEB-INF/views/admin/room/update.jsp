

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Update room</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>

<div class="container">
    <div class="row center">
        <h1>Update room.</h1>
        <p>Please give new data.</p>

        <f:form modelAttribute="roomUpdated" method="post" action="/admin/room/update">
            <p>Location:<f:input path="location" type="text"/>
                <f:errors path="location"/> </p>
            <p>Number of seats: <f:input path="numberOfSeats" type="number"/>
                <f:errors path="numberOfSeats"/> </p>

            <p>Does this room have projector?</p>
            <div class="input-field s6">
                <select class="browser-default waves-effect waves-light btn"
                        name="projector" id="projector"  <f:input path="projector"/>  <f:errors path="numberOfSeats"/>>
                    <option value="" disabled="" selected="">Choose option
                    </option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
            </div>

            <p>Phone number: <f:input path="phoneNumber" type="text"/>
                <f:errors path="phoneNumber"/> </p>
            <p><input type="submit" value="Update"/></p> </f:form>
    </div>
</div>
</body>
</html>



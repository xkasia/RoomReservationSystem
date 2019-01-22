<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add room</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>

<div class="container">
    <div class="row center">
        <h1>Create new room.</h1>
        <p>Please fill in this form to create new room.</p>

        <f:form modelAttribute="room" method="post" action="/admin/room/add">
            <p>Name:*<f:input path="name" type="text" />
                <f:errors path="name"/> </p>
            <p>Location:<f:input path="location" type="text"/>
                <f:errors path="location"/> </p>
            <p>Number of seats:* <f:input path="numberOfSeats" type="number"/>
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
            <p><input type="submit" value="Create"/></p> </f:form>
        <h6 style="color:red;">${errorMsg}</h6>
    </div>
</div>
</body>
</html>

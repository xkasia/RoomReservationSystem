<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 11.01.2019
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <form method="post" action="/admin/room/update">

            Name <input name="name" , type="text" , maxlength="50" ,
                        required="required">  </br>  </br>
            Location <input name="location" , type="text" ,
                            maxlength="256"> </br>  </br>
            Number of seats <input name="numberOfSeats" , type="number" ,
                                   min="0" , max="100"> </br>  </br>
            <p>Does this room have projector?</p>
            <div class="input-field s6">
                <select class="browser-default waves-effect waves-light btn"
                        name="projector" id="projector">=
                    <option value="" disabled="" selected="">Choose option
                    </option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
            </div>
            Phone number <input name="phoneNumber" , type="text" ,
                                maxlength="100"> </br>  </br>
            <fieldset>
                <input type="submit" value="Create"/>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>



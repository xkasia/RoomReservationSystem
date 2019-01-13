<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 13.01.2019
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div>
    <form method="post" action="/user/delete/reservation">
        <div>
            <p>Are you sure, that you want to delete this reservation?</p>
            <div class="input-field s6">
                <select class="browser-default waves-effect waves-light btn" required="required" name="delete" id="delete">=
                    <option value="" disabled="" selected="">Choose option</option>
                    <option value="yes">Yes, delete reservation.</option>
                    <option value="no">No.</option>
                </select>
            </div>
        </div>
        <fieldset>
            <input type="submit" value="Submit"/>
        </fieldset>
    </form>

</div>
</div>
</body>
</html>

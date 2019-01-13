<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 11.01.2019
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update data</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div class="container">
    <div class="row center"><h4>Please give new data</h4>
        <title>Register form</title>
        <form method="post" action="/admin/user/update">
            Name <input name="firstName", type="text", maxlength="50">  </br>  </br>
            Last Name <input name="lastName", type="text", maxlength="100"> </br>  </br>
            Password <input name="password", type="password", minlength="6", maxlength="100"> </br>  </br>
            <fieldset>
                <input type="submit" value="Update"/>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>




<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Update</title>--%>
<%--</head>--%>
<%--<body>--%>


<%--<jsp:include page="../../elements/menu.jsp"/>--%>

<%--<p>Please give new data</p>--%>

<%--<form method="post" action="/admin/user/update">--%>
    <%--Name <input name="firstName", type="text", maxlength="50">  </br>  </br>--%>
    <%--Last Name <input name="lastName", type="text", maxlength="100"> </br>  </br>--%>
    <%--Password <input name="password", type="password", minlength="6", maxlength="100"> </br>  </br>--%>
    <%--login <input name="login", type="text", maxlength="100", required="required" > </br>  </br>--%>
    <%--<fieldset>--%>
        <%--<input type="submit" value="Update"/>--%>
    <%--</fieldset>--%>
<%--</form>--%>


<%--</body>--%>
<%--</html>--%>

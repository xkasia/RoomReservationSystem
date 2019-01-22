
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete</title>
    <jsp:include page="../../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../../elements/menu.jsp"/>
<div>
    <form method="post" action="/admin/room/delete">
        <div>
            <p>Are you sure, that you want to delete your this room?</p>
            <div class="input-field s6">
                <select class="browser-default waves-effect waves-light btn"
                        required="required" name="delete" id="delete">=
                    <option value="" disabled="" selected="">Choose option
                    </option>
                    <option value="yes">Yes, delete room.</option>
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



<html>
<head>
    <title>Strona główna</title>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/>

<div class="row center">
    <h3>${successMsg} Welcome in the Room Reservation System!</h3>
    <h6 style="color:limegreen;">${logoutMsg}</h6>
    <h6 style="color:limegreen;">${deleteUserMsg}</h6>
</div>
</body>
</html>

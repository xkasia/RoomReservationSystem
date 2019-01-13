<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.01.2019
  Time: 07:34
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="light-blue">
    <div class="nav-wrapper container" role="navigation">
        <a id="logo-container" href="/home">Home</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="/home/about">About system</a></li>
            <%--<li><a href="/home/contact">Contact</a></li>--%>
            <li><a href="/user/data">Account</a></li>
            <li><a href="/reservation/make">Book room</a></li>
            <li><a href="/reservation/show/all">All reservtions</a></li>
            <li><a href="/user/show/reservations">My reservtions</a></li>
            <li><a href="/admin/user/show">Show Users</a></li>
            <li><a href="/admin/room/show">Show Rooms</a></li>
        </ul>
        <ul class="right">
            <li><a href="/home/login">Zaloguj</a></li>
            <li><a href="/home/logout">Wyloguj</a></li>
            <li><a href="/home/register">Register</a></li>
        </ul>
    </div>
</nav>
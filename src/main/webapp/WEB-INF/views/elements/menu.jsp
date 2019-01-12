<%--
  Created by IntelliJ IDEA.
  User: Katarzyna
  Date: 10.01.2019
  Time: 07:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div><h1>Room Reservation System</h1></div>
<div>
    <p><a href="/home/login">Login</a> <a href="/home/logout">Logout</a></p>
    <p><a href="/home/register">Register</a> </p>
</div>
<div>
    <ol><h2>Menu</h2>
        <li><a href="/home">Home page</a></li>
        <li><a href="/home/about">About system</a></li>
        <li><a href="/home/contact">Contact</a></li>

        FOR USER
        <li><a href="/user/data">Your Account</a></li>
        <li><a href="/reservation/make">Reserve a room</a></li>


        FOR ADMIN
        <li><a href="/admin/user/show">Show Users</a></li>
        <li><a href="/admin/room/show">Show Rooms</a></li>

    </ol>
</div>

<%-- 
    Document   : profile
    Created on : Oct 4, 2021, 6:11:48 PM
    Author     : Sandro
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="with=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>        
        <link rel="stylesheet" href="./style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
        <title>Profile Page</title>
    </head>
    <body>
        <div class="navbar">
            <a href="do.maps"><img src ="img/logo.png"></a>
            <div class="dropdown">
                <button class="dropbtn"><c:out value="${acc.getUsername()}" /> <%-- Make this fetch username --%>
                <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="do.onProfile">Profile Settings</a>
                    <a href="do.onActivities">User Activities</a>
                    <a href="do.onCheckOut">Checkout</a>
                    <a href="do.viewLocations">View Locations</a>
                    <a href="do.logout">Logout</a>
                </div>
            </div>
        </div>
        <div class="viewprofile">
            <div class="profilecontain">
                <div class="sqlprof">
                    <h1> User Profile</h1>
                    <h3>Username</h3>
                    <h4><c:out value="${acc.getUsername()}" /></h4>
                    <h3>Email</h3>
                    <h4><c:out value="${acc.getEmail()}" /></h4>
                    <h3>Address</h3>
                    <h4><c:out value="${acc.getAddress()}" /><br>
                </div>
                <a href ="do.editProfile" class="Edit">Edit Profile</a>
                <a href="do.maps" class="Edit">Home</a>
            </div>
        </div>
    </body>
</html>

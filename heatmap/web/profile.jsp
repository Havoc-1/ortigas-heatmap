<%-- 
    Document   : profile
    Created on : Oct 4, 2021, 6:11:48 PM
    Author     : Sandro
--%>

<%@page import="asia.uap.SQLThing"%>
<%@page import="asia.uap.Accounts"%>
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
                <button class="dropbtn">Wilbert De La Cruz <%-- Make this fetch username --%>
                <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="profile.jsp">Profile Settings</a>
                    <a href="do.logout">Log Out</a>
                </div>
            </div>
        </div>
        <div class="viewprofile">
            <div class="profilecontain">
                <div class="sqlprof">
                    <%
                    SQLThing db = new SQLThing();
                    int uid = (int) session.getAttribute("currentUserUID");
                    Accounts account = db.getAccount(uid);
                    String user = account.getUsername();
                    String email = account.getEmail();
                    String address = account.getAddress();
                    %>
                    <h1> User Profile</h1>
                    <h3>Username</h3>
                    <h4><%out.print(user);%></h4>
                    <h3>Email</h3>
                    <h4><%out.print(email);%></h4>
                    <h3>Address</h3>
                    <h4><%out.print(address);%></h4> <br>
                    <a href ="do.editProfile" class="Edit">Edit Profile</a> <br>
                    <a href="home.jsp" class="Edit">Home</a>
                </div>
            </div>
        </div>
    </body>
</html>

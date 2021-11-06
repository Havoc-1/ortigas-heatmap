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
        <title>Profile Page</title>
    </head>
    <body>
        <%
        SQLThing db = new SQLThing();
        int uid = (int) session.getAttribute("currentUserUID");
        Accounts account = db.getAccount(uid);
        String user = account.getUsername();
        String abtMe = account.getAbout_Me();
        String url = account.getUrl_Photo();
        %>
        <h1> User Profile</h1>
        <h3>Username = <%out.print(user);%></h3>
        <h3>About Me = <%out.print(abtMe);%></h3>
        <h3>URL Photo = <%out.print(url);%></h3>
        <a href ="do.editProfile">Edit Profile</a>
    </body>
</html>

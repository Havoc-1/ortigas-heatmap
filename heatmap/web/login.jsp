<%-- 
    Document   : login
    Created on : Oct 4, 2021, 3:48:39 PM
    Author     : Sandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="with=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css"/>
        <title>Login Page</title>
    </head>
    <body>
        <div class ="center">
        <h1>Log In: </h1>
        <form action="do.authenticate" method="POST">
            <div class="txt_field">
            <lable>Username</label>
            <input type="text" name="userLogin" required>
            <span></span>
            <input type="password" name="passLogin" placeholder="Password" required>
            <input type="submit" value="Submit">
        <a href="add.jsp">Sign up</a> <br />
        <a href="index.jsp">Home</a> <br />
        </form>
        </div>
    </body>
</html>

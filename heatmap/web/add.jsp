<%-- 
    Document   : add
    Created on : Oct 4, 2021, 3:55:40 PM
    Author     : Sandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sign Up:</h1>
        <form action="do.register" method="POST">
            <input type="text" name="user" placeholder="Username" required>
            <input type="password" name="pass" placeholder="Password" required>
            <input type="text" name="email" placeholder="Email" required>
            <input type="submit" value="Submit">
        </form>
            <%-- ADD INPUT TYPE FOR ANOTHER ENTRY --%>
    </body> 
</html>

<%-- 
    Document   : fpass
    Created on : Oct 4, 2021, 10:28:13 PM
    Author     : Sandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
         <div align ="center">
            <h1>Forgot Password</h1>
            <form action="do.forgor" method="post" >
                <label for = "forgotUser">Enter username</label><br>
                <input type ="text" name="forgotUser" required><br>
                <input type ="submit" value="Submit">
            </form>
        </div>
    </body>
</html>

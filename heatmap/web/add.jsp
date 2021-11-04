<%-- 
    Document   : add
    Created on : Oct 4, 2021, 3:55:40 PM
    Author     : Sandro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="with=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>        
        <link rel="stylesheet" href="./style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup Page</title>
        <script defer src="formmagic.js"></script>
    </head>
    <body>
        <h1>Submit Event - JS</h1>
        <form onsubmit="document.getElementById('first').style.display = 'none';
            document.getElementById('second').style.display = '';">
            <div id="first">
                <label for="username">Username</label>
                <input type="text" name="username" id="username">
                <input type="submit" value="Submit">
            </div>
            <div id="second">
                <label for="password">Password</label>
                <input type="password" name="password" id="password">
                <input type="submit" value="Submit">
            </div>
        </form>
    </body>
</html>

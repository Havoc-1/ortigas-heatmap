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
    <section class="login">
    <div class ="txt1">
        <form action="do.authenticate" method = "POST">
            <h1>Sign in</h1>
            <span>or use your account</span>
            <input type="text" name="userLogin" placeholder="Username" required>
            <input type="password" name="passLogin" placeholder="Password" required>
            <a href="fpass.jsp">Forgot your password?</a>
            <input class="button" type="submit" value="Sign In" />
            <a href="add.jsp">
            <input type="button" value="Sign Up" />
            </a>
        </form>
    </div>
    </section>
</body>
</html>

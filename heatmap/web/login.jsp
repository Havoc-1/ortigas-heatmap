<%-- 
    Document   : login
    Created on : Oct 4, 2021, 3:48:39 PM
    Author     : Sandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="with=device-width, initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css"/>
        <title>Heatmap Login</title>
    </head>
   <body>
    <section class ="txt1">
    <div class="center">
      <h1>Sign in to your account</h1>
      <form action ="do.signin" method="post">
        <div class="txt_field">
          <input type="text" name="userLogin" required>
          <span></span>
          <label>Username</label>
        </div>
        <div class="txt_field">
          <input type="password" name="passLogin" required>
          <span></span>
          <label>Password</label>
        </div>
        <a href="do.forgor">
            <div class="pass"> Forgot Password? </div> 
        </a>
        <input type="submit" value="Login">
        <div class="signup_link">
          Not a member? <a href="add.jsp">Signup</a>
        </div>
      </form>
    </div>
    </section>
  </body>
</html>

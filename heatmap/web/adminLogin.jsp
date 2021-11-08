<%-- 
    Document   : adminLogin
    Created on : Nov 8, 2021, 1:54:04 PM
    Author     : Nofuente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="with=device-width, initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css"/>
        <title>Heatmap Admin Login</title>
    </head>
   <body>
    <section class ="txt1">
    <div class="center">
      <h1>Administrator Login</h1>
      <form action ="do.adminLogin" method="post">
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
        <input type="submit" value="Login">
      </form>
    </div>
    </section>
  </body>
</html>

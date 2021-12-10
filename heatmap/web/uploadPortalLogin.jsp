<%-- 
    Document   : uploadPortalLogin
    Created on : Dec 11, 2021, 2:20:18 AM
    Author     : Nofuente
--%>

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
      <h1>Upload Portal Login</h1>
      <form action ="do.uploadLogin" method="post">
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

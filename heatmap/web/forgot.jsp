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
        <link rel="stylesheet" href="./style.css"/>
        <title>Forgot Password</title>
        
    </head>
    <body>
      <section class ="txt1">
         <div class ="center">
            <h1>Forgot Password</h1>
            <form action="do.forgor" method="post">
                <div class="txt_field">
                    
                    <input type ="text" name="forgotUser" required> 
                    
                    <label for = "forgotUser"> Enter username </label> 
             
                     
                 
                </div>
                <input type ="submit" value="Submit"> <br><br>
            </form>
         </div>
        
     </section>
        
    </body>
</html>

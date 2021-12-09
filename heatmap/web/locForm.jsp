<%-- 
    Document   : locForm
    Created on : Nov 29, 2021, 3:12:34 PM
    Author     : Nofuente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="do.regLoc" id="form1" class="formarea">
            <label for="address" class="q">Address</label> <br> <br>
            <input type="text" class="reg" name="address" required> <br> 
            
            <label for="name" class="q">Name</label> <br> <br>
            <input type="text" class="reg" name="name" required> <br> 
            
            <label for="lat" class="q">Latitude</label> <br> <br>
            <input type="text" class="reg" name="lat" required> <br> 
            
            <label for="long" class="q">Longitude</label> <br> <br>
            <input type="text" class="reg" name="long" required> <br> 
            
            <input type="submit" class="fsubmitbtn" value="Submit">
        </form>
    </body>
</html>

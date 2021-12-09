<%-- 
    Document   : checkout
    Created on : Nov 29, 2021, 1:40:43 PM
    Author     : Nofuente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Placeholder</title>
    </head>
    <body>
        <form action="do.checkout" id="form1" class="formarea">
            <label for="address" class="q">Address</label> <br> <br>
            <input type="text" class="reg" name="address" required> <br> 
            
            <label for="name" class="q">Name</label> <br> <br>
            <input type="text" class="reg" name="name" required> <br> 
            
            <label for="checkHours" class="secq">How long were you in the place?</label> <br> <br>
            <select name="checkHours" id="sec_ques_no">
                <option value="1">1 hour</option>
                <option value="2">2 hours</option>
                <option value="3">3 hours</option>
                <option value="4">4 hours</option>
                <option value="5">5 hours</option>
                <option value="6">6 hours</option>
                <option value="7">7 hours</option>
                <option value="8">8 hours</option>
                <option value="9">9 hours</option>
                <option value="10">10 hours</option>
                <option value="11">11 hours</option>
                <option value="12">12 hours</option>
            </select> <br> <br> <br>
            
            <label for="lat" class="q">Latitude</label> <br> <br>
            <input type="text" class="reg" name="lat" required> <br> 
            
            <label for="long" class="q">Longitude</label> <br> <br>
            <input type="text" class="reg" name="long" required> <br> 
            
            <input type="submit" class="fsubmitbtn" value="Submit">
        </form>    
        <a href ="locForm.jsp">Register Location</a>
    </body>
</html>

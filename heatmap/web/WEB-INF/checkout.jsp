<%-- 
    Document   : checkout
    Created on : Nov 29, 2021, 1:40:43 PM
    Author     : Nofuente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css"/>
        <title>Checkout</title>
    </head>
    <body>
        <div class="holder">
            <div class="checkincont">
                <form action="do.checkout" id="form1" class="formarea">
                <label for="locList">Choose from the following approved locations:</label> <br> <br>
                <div class="checkdiv">
                <select name ="id">
                    <c:forEach items="${locList}"  var="loc">
                        <option value="<c:out value="${loc.getUid()}" />">${loc.getName()}, ${loc.getAddress()}</option>
                    </c:forEach>
                </select>
                </div><br><br><br>  <br>  <br>  <br>   
            <label for="checkHours" class="secq">How long were you in the place?</label> <br> <br>
            <div class="checkdiv">
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
            </div>  <br> <br> <br>  <br> 
            <input type="submit" class="fsubmitbtn" value="Submit">
            </form>    
            <a href ="locForm.jsp">Register Location</a>
            </div>
        </div>
    </body>
</html>

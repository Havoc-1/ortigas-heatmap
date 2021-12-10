<%-- 
    Document   : submitReview
    Created on : Dec 11, 2021, 12:37:39 AM
    Author     : Nofuente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="do.submitReview" method="POST" id="form1" class="formarea ">
            <input type="hidden" name="locID" value="<c:out value="${locID}" />">
            <input type="hidden" name="uid" value="<c:out value="${id}" />">
            
            <h3 class="survq">Do you recommend visiting this place?
            Keep in mind the amount of people and implementation of health 
            protocols.
            </h3>
            <!-- any radio button with same name will deselect other choice-->
            <input type="radio" name="feedback" value='1' required>  
            <label for ="feedback" class="ans">I recommend</label> <br>
            <input type="radio" name="feedback" value='0'>  
            <label for ="feedback" class="ans">I do not recommend</label> <br>
            
            <label for="comments">Feedback Comments: </label> <br />
            <textarea name="comments" cols="50" rows="10" required></textarea> <br /><br />
            
            <input type="submit" class="fsubmitbtn" value="Submit Review">
        </form>
        
    </body>
</html>

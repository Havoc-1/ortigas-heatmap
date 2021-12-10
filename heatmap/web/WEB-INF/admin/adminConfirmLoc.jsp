<%-- 
    Document   : adminConfirmLoc
    Created on : Dec 10, 2021, 1:21:30 AM
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
        <section class="admintab">
             <div class="container">
            <div class="row">
              <div class="col-12">
                  <form action="do.confirmLoc" id="form1" class="formarea">
                      <input type="hidden" name="id" value="<c:out value="${loc.getUid()}"/>">
                      <label for="name"><c:out value="${loc.getName()}" /><br>Confirm: </label> <br>
                      <input type="text" name="name" required><br><br>

                      <label for="address"><c:out value="${loc.getAddress()}" /><br>Confirm: </label> <br>
                      <input type="text" name="address" required><br><br>
                    
                      <label for="lat"><c:out value="${loc.getLat()}" /><br>Confirm: </label> <br>
                      <input type="text" name="lat" required><br><br>
                      
                      <label for="long"><c:out value="${loc.getLong()}" /><br>Confirm: </label> <br>
                      <input type="text" name="long" required><br><br>

                       <input type="submit" class="fsubmitbtn" value="Confirm">
                   </form>
              </div>
            </div>
          </div>
        <a href="/do.admin" class="previous">Admin</a>
        </section>
    </body>
</html>

<%-- 
    Document   : adminApproveLoc
    Created on : Nov 29, 2021, 3:15:17 PM
    Author     : Nofuente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="width=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>        
        <link rel="stylesheet" href="./style.css"/>
        <%-- CDN to call bootstrap --%>        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Approve Location</title>
    </head>
    <body>
        <section class="admintab">
             <div class="container">
            <div class="row">
              <div class="col-12">
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th scope="col">UID</th>
                      <th scope="col">Name</th>
                      <th scope="col">Address</th>
                      <th scope="col">Longitude</th>
                      <th scope="col">Latitude</th>
                      <th scope="col">Accept Location</th>
                      <th scope="col">Reject Location</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="loc" items="${locList}">
                        <tr>
                            <td><c:out value="${loc.getUid()}" /></td>
                            <td><c:out value="${loc.getName()}" /></td>
                            <td><c:out value="${loc.getAddress()}" /></td>
                            <td><c:out value="${loc.getLong()}" /></td>
                            <td><c:out value="${loc.getLat()}" /></td>
                            <td>
                                <form action="do.adminViewLoc" method="POST" id="form1" class="formarea ">
                                    <input type="hidden" name="id" value="<c:out value="${loc.getUid()}" />">
                                    <input type="hidden" name="address" value="<c:out value="${loc.getAddress()}" />">
                                    <input type="hidden" name="name" value="<c:out value="${loc.getName()}" />">
                                    <input type="hidden" name="lat" value="<c:out value="${loc.getLat()}" />">
                                    <input type="hidden" name="long" value="<c:out value="${loc.getLong()}" />">
                                
                                    <input type="submit" class="fsubmitbtn" value="Confirm">
                                </form>
                            </td>
                            <td>
                                <form action="do.rejectLoc" id="form1" class="formarea">
                                    <input type="hidden" name="id" value="<c:out value="${loc.getUid()}" />">
                                    <input type="submit" class="fsubmitbtn" value="Reject">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        <a href="do.admin" class="previous">Go back</a><br>  <br><br>                          
        </section>
    </body>
</html>

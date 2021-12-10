<%-- 
    Document   : adminCSV
    Created on : Dec 11, 2021, 3:05:56 AM
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
        <title>JSP Page</title>
    </head>
    <body>
        <section class="admintab">
             <div class="container">
            <div class="row">
              <div class="col-12">
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th scope="col">ID</th>
                      <th scope="col">Content</th>
                      <th scope="col">Date Posted</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="csv" items="${csvList}">
                        <tr>
                            <td><c:out value="${csv.getUid()}" /></td>
                            <td><c:out value="${csv.getContent()}" /></td>
                            <td><c:out value="${csv.getDateTime()}" /></td>
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

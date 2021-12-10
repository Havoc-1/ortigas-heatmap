<%-- 
    Document   : uploadCSV
    Created on : Dec 11, 2021, 2:32:55 AM
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
        <form action="do.uploadCSV" method="post" enctype="multipart/form-data">
            <input type="text" name="description" />
            <input type="file" name="file" />
            <input type="submit" />
        </form>
    </body>
</html>

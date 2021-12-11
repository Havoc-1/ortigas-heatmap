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
        <title>CSV Upload</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
        <link rel="stylesheet" href="./style.css"/>
    </head>
    <body>
        <div class="csvbg">
            <div class="csvup">
            <div class="file-upload">
                <form action="do.uploadCSV" method="post" enctype="multipart/form-data">
                    <label class="csv">Description</label> <br> <br>
                    <input type="text" name="description" />
                    <input type="file" name="file" /> <br> <br> <br> <br> <br>
                    <input type="submit" class="csvsub" />
                </form>
            </div>
            </div>
        </div>
    </body>
</html>

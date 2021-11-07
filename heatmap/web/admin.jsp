<%-- 
    Document   : admin
    Created on : Nov 8, 2021, 12:44:53 AM
    Author     : Sandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="width=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>        
        <link rel="stylesheet" href="./style.css"/>
        <%-- CDN to call bootstrap --%>        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
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
                      <th scope="col">Username</th>
                      <th scope="col">Password</th>
                      <th scope="col">URL_Photo</th>
                      <th scope="col">Security Question No.</th>
                      <th scope="col">Security Answer</th>
                      <th scope="col">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">1</th>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td> <%-- Implement administrator abilities here (icons are from bootstrap/fontisawesome --%> 
                        <button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
                        <button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                        <button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">2</th>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>
                        <button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
                        <button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                        <button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">3</th>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>SQL Logic here</td>
                      <td>
                        <button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
                        <button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
                        <button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        <a href="home.jsp" class="previous">Go back</a>
        </section>
    </body>
</html>

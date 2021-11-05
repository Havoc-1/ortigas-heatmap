<%-- 
    Document   : index
    Created on : Sep 29, 2021, 10:29:37 PM
    Author     : Sandro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta name ="viewport" content="with=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Heatmap</title>
        <link rel="stylesheet" href="./style.css"/>
    </head>
    <body>
        <%-- SPLASH PAGE --%>
        <section class ="splash">
        <a href ="add.jsp" class="reg-btn">Register</a>
        <a href ="login.jsp" class ="log-btn">Login</a>
        <div class ="text-box">
            <h1>Heatmap</h1>
            <p>a group 2 webdev project</p>
            <h3>Get all the facts and <br> reduce risk when going out</h3>
            <a href ="login.jsp" class="start-btn">Get started</a>
        </div> 
            </section>
        <%-- FEATURES --%>
        <section class="features">
            <h1>Features</h1>
            <p>Descriasdasdasdption of features</p>
            <div class ="row">
             <div class="feature-col">
                    <h3>Something 1</h3>
                    <p>Description of features</p>
                </div>
                <div class="feature-col">
                    <h3>Something 2</h3>
                    <p>Description of features</p>
                </div>
                <div class="feature-col">
                    <h3>Something 3</h3>
                    <p>Description of features</p>
                </div>
            </div>
        </section>
        <%-- THE TEAM --%>
        <section class ="team">
            <div id ="team-row">
                <h1>The Team</h1>
                <div class ="member">
                    <img src="img/deo_pic.png" class="img-responsive img-thumbnail" alt="Responsive image" />
                    <div class ="name">Dei Nofuente
                        <br />3rd Year BSIT University of Asia and the Pacific</div>
                </div>
                <div class ="member">
                    <img src="img/sandro_pic.png" class="img-responsive img-thumbnail" alt="Responsive image" />
                    <div class ="name">Sandro Yguico
                        <br />3rd Year BSIT University of Asia and the Pacific</div>
                </div>
                <div class ="member">
                    <img src="img/franc_pic.png" class="img-responsive img-thumbnail" alt="Responsive image" />
                    <div class ="name">Francine Calivozo
                        <br />3rd Year BSIT University of Asia and the Pacific</div>
                </div>
            </div>
        </section>
            
        <%-- THE TEAM --%>
        <section class ="action">
            <div class ="text-box1">
                <h1>What are you waiting for?</h1> <br> <br> <br>
                <p>Sign up now.</p>
                <a href ="login.jsp" class="start1-btn">Get started</a>
            </div>
        </section>
        
        <%-- Make a back to top button:
        https://www.w3schools.com/howto/howto_js_scroll_to_top.asp
        --%>        
    </body>
</html>

<%-- 
    Document   : home
    Created on : Oct 4, 2021, 4:05:37 PM
    Author     : Sandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="width=device-width, initial-scale=1.0"> <%-- to make the webpage responsive --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Heatmap</title>
        <link rel="stylesheet" href="./style.css"/>
        <script defer src="card.js"></script>
    </head>
    <body>
        <%-- MAVBAR --%>
        <div class="navbar">
            <a href="home.jsp"><img src ="img/logo.png"></a>
            <div class="dropdown">
                <button class="dropbtn">Wilbert De La Cruz <%-- Make this fetch username --%>
                <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="profile.jsp">Profile Settings</a>
                    <a href="do.logout">Log Out</a>
                </div>
            </div>
        </div>
        <%-- MODAL POPUP --%>
        <button data-modal-target="#modal" class="mapbtn"><img src = "img/place.png" class="icon"></button>
        <div class="modal" id="modal">
            <div class="modal-header">
                <div class="title">SM MegaMall</div>
                    <button data-close-button class="close-button">&times;</button>
            </div>
            <div class="modal-body"> 
                <h3>Num. of people</h3> <p>120 pax</p>
                <h3>People per hour</h3> <p>5 per hour</p>
                <h3>Time spent</h3> <p>~1 hour</p>
                <h3>Reviews</h3><img src="img/thumb_up.png"><p>60%</p><img src="img/thumb_down.png"><p>40%</p>
                <h3>Recent visits</h3> <p>Alyssa, 2 days ago</p>
                <h3>COVID Positive</h3> <img src="img/warning.png"><p>Miggy Reyes, Mia Salazar</p>
                <button data-modal-target="#modal2"><u>See more</u></button>
                <%-- SEE MORE POPUP --%>
                    <div class = "modal2" id="modal2"> 
                        <div class="modal2-header">
                            <div class="title">SM MegaMall</div>
                            <button data-close-button class="close-button">&times;</button>
                        </div>
                        <div class ="modal2-body"> 
                            <h3>Num. of people</h3> <p>120 pax</p>
                            <h3>People per hour</h3> <p>5 per hour</p>
                            <h3>Time spent</h3> <p>~1 hour</p>
                            <h3>Feedback</h3><img src="img/thumb_up.png"><p>60%</p><img src="img/thumb_down.png"><p>40%</p>
                            <h3>Remarks</h3>
                            <p>Sandro Yguico</p>
                            <p>I'm too poor for this shit</p>
                            <h3>Recent visits</h3> <p>Alyssa, 2 days ago</p>
                            <p>Mia, 8 days ago</p>
                            <p>Miggy, 5 days ago</p>
                            <h3>COVID Positive</h3> <img src="img/warning.png"><p>Miggy Reyes, Mia Salazar</p>
                        </div>
                    </div>
            </div>        
        </div>
        <%-- ADD POPUP 
            this is broken image won't even show
            i don't fucking know anymore someone help me please - yguico [7 PM]
            I speculate something wrong with card.js or style.css [8 PM]
        --%>
        <button data-modal-target="#modal3" class="addbtn">CHECK-IN</button>
        <div class ="modal3" id="modal3">
            <div class="modal3-header">
                <div class="title">Check-in</div>
                <button data-close-button class="close-button">&times;</button>
            </div>
            <div class="modal3-body">
                <p>This isn't working - I'm sad</p>
            </div>
        </div>
        <button data-modal-target="#modal4" class="rmvbtn">CHECK-OUT</button>
        <div class ="modal4" id="modal4">
            <div class="modal4-header">
                <div class="title">Check-out</div>
                <button data-close-button class="close-button">&times;</button>
            </div>
            <div class="modal4-body">
                <p>This isn't working - I'm sad</p>
            </div>
        </div>
        <div class ="heatmap">
            <img src ="img/sample.png">
        </div>
        <div id="overlay"></div>
        <div id="overlay2"></div>
        <div id="overlay3"></div>
    </body>
</html>

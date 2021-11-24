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
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
        integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
        crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
        integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
        crossorigin=""></script>
        <link rel="stylesheet" href="./style.css"/>
        <script defer src="./card.js"></script>
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
        <%-- MAVBAR END --%>
        <%-- LEAFLETJS --%>
        <div id="map"></div>        
        <script>
            var mymap = L.map('map').setView([14.5838, 121.0597], 13);
                L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
                attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
                maxZoom: 18,
                id: 'mapbox/streets-v11',
                tileSize: 512,
                zoomOffset: -1,
                accessToken: 'pk.eyJ1Ijoic3lndWljbyIsImEiOiJja3c0a3UzYXEweHU4MzJwZGszMXJnazRiIn0.ASuhvy3d0d4_oyvmQOfunw'
            }).addTo(mymap);   
            //markers
            var marker = L.marker([14.5847,121.0573]).addTo(mymap);
            var marker1 = L.marker([14.5803,121.0608]).addTo(mymap);
            //binding to marker to popup
            marker.bindPopup('<h1>SM Megamall</h1><h3>Num. of people</h3> <p>120 pax</p><h3>People per hour</h3> <p>5 per hour</p><h3>Time spent</h3> <p>~1 hour</p><h3>Reviews</h3><div class="gmaps"><img src="img/thumb_up.png"><p>60%</p><img src="img/thumb_down.png"></div><p>40%</p><h3>Recent visits</h3> <p>Alyssa, 2 days ago</p><h3>COVID Positive</h3> <img src="img/warning.png"><p>Miggy Reyes, Mia Salazar</p>');
            marker1.bindPopup('<h1>University of Asia & the Pacific</h1><h3>Num. of people</h3> <p>120 pax</p><h3>People per hour</h3> <p>5 per hour</p><h3>Time spent</h3> <p>~1 hour</p><h3>Reviews</h3><div class="gmaps"><img src="img/thumb_up.png"><p>60%</p><img src="img/thumb_down.png"></div><p>40%</p><h3>Recent visits</h3> <p>Alyssa, 2 days ago</p><h3>COVID Positive</h3> <img src="img/warning.png"><p>Miggy Reyes, Mia Salazar</p>');
        </script>
        <%-- LEAFLETJS END --%>
        <%-- MODALS --%>
        <button class="modal-open" data-modal="modal1">Check In / Check out</button> 
        <div class="modal" id="modal1">
            <div class="modal-content">
                <div class="modal-header">Modal 1
                    <button class="icon modal-close"><i class="material-icons">close</i></button>
                </div>
                <div class="modal-body"></div>Put in form here
                <div class="modal-footer"><button class="link modal-close">Close</button></div>
            </div>
        </div>
        <%-- MODALS END --%>
    </body>
</html>

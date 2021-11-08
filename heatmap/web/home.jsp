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
        <script defer src="gmaps.js"></script>
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
        <%-- GOOGLE MAPS HERE --%>
        <div id="map"></div>
        <%-- GOOGLE MAPS FUNCTIONS --%>
        <script>
            //map options
            function initMap(){
                var options = {
                    zoom: 14,
                    center: {lat:14.5838,lng:121.0597},
                    mapId: '80b8998c20ecb721'
                }   
                //new map object
                var map = new google.maps.Map(document.getElementById('map'), options);
                
                //array of markers
                var markers = [
                    {
                        coords:{lat:14.5847,lng:121.0573},
                        iconImage: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
                        content: '<h1>SM Megamall</h1>\n\
                            <h3>Num. of people</h3> <p>120 pax</p>\n\
                            <h3>People per hour</h3> <p>5 per hour</p>\n\
                            <h3>Time spent</h3> <p>~1 hour</p>\n\
                            <h3>Reviews</h3><div class="gmaps"><img src="img/thumb_up.png"><p>60%</p><img src="img/thumb_down.png"></div><p>40%</p>\n\
                            <h3>Recent visits</h3> <p>Alyssa, 2 days ago</p>\n\
                            <h3>COVID Positive</h3> <img src="img/warning.png"><p>Miggy Reyes, Mia Salazar</p>'
                    }, 
                    {
                        coords:{lat:14.5803,lng:121.0608},
                        //undefined icon image - testing purposes
                        content: '<h1>University of Asia & the Pacific</h1>\n\
                        <h3>Num. of people</h3> <p>120 pax</p>\n\
                        <h3>People per hour</h3> <p>5 per hour</p>\n\
                        <h3>Time spent</h3> <p>~1 hour</p>\n\
                        <h3>Reviews</h3><div class="gmaps"><img src="img/thumb_up.png"><p>60%</p><img src="img/thumb_down.png"></div><p>40%</p>\n\
                        <h3>Recent visits</h3> <p>Alyssa, 2 days ago</p>\n\
                        <h3>COVID Positive</h3> <img src="img/warning.png"><p>Miggy Reyes, Mia Salazar</p>'
                    }
                ];
                
                // loop through markers 
                for(var i = 0; i < markers.length;i++) {
                    addMarker(markers[i]);
                }                
                //add marker function
                function addMarker(props) {
                    var marker = new google.maps.Marker({
                        position: props.coords, //somewhat oop approach
                        map:map,
                        icon: props.iconImage //calls custom image per marker
                    });
                    //check for custom icon
                    if(props.iconImage) {
                        //set icon image
                        marker.setIcon(props.iconImage);
                    }
                    //check content
                    if(props.content) {
                        var infoWindow = new google.maps.InfoWindow({
                        content: props.content
                    });
                    marker.addListener('click', function(){
                        infoWindow.open(map, marker);
                        });
                    }
                }
            }
        </script>
        <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD1lu_0BTo_fZeii_e_SvY5G7O4bvUKjp4&callback=initMap&v=weekly&channel=2"
      async
    ></script>   
    </body>
</html>

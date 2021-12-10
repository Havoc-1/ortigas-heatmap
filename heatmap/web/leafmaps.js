/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//center and instansiating map object
var mymap = L.map('map').setView([14.5838, 121.0597], 15); 
        
//to run the map
document.addEventListener("DOMContentLoaded", function runMaps() {
    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1Ijoic3lndWljbyIsImEiOiJja3c0a3UzYXEweHU4MzJwZGszMXJnazRiIn0.ASuhvy3d0d4_oyvmQOfunw'
    }).addTo(mymap);
});

//appearance of popup
var popupOptions = {
    'maxWidth': '400',
    'minWidth': '350',
    'maxHeight': '400',
    'closeButton': 'true',
    'className': 'popupContents'
}
//maybe make this into an array? custom contents
var popupContents = '<h1>University of Asia & the Pacific</h1><h3>Num. of people</h3> <p>120 pax</p><h3>People per hour</h3> <p>5 per hour</p><h3>Time spent</h3> <p>~1 hour</p><h3>Reviews</h3><div class="gmaps"><img src="img/thumb_up.png"><p>60%</p><img src="img/thumb_down.png"></div><p>40%</p><h3>Recent visits</h3> <p>Alyssa, 2 days ago</p><h3>COVID Positive</h3> <img src="img/warning.png"><p>Miggy Reyes, Mia Salazar</p>';

//markers added with content
L.marker([14.5847,121.0573])
        .addTo(mymap)
        .bindPopup('<h1>SM Megamall</h1><h3>Num. of people</h3> <p>120 pax</p><h3>People per hour</h3> <p>5 per hour</p><h3>Time spent</h3> <p>~1 hour</p><h3>Reviews</h3><div class="gmaps"><img src="img/thumb_up.png"><p>60%</p><img src="img/thumb_down.png"></div><p>40%</p><h3>Recent visits</h3> <p>Alyssa, 2 days ago</p><h3>COVID Positive</h3> <img src="img/warning.png"><p>Miggy Reyes, Mia Salazar</p>', popupOptions);
L.marker([14.5803,121.0608])
        .addTo(mymap)
        .bindPopup(popupContents, popupOptions);

var popup = L.popup();

//handle events documentation to get coords (lat,lng) for user to populate markers
function getLatLng(e) {
    popup
        .setLatLng(e.latlng)
        .setContent("yo bro this is the location you clicked at " + e.latlng.toString())
        .openOn(mymap);
    console.log("you have clicked");
}
mymap.on('click', getLatLng);


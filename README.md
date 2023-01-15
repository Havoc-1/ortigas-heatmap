
# Ortigas Traffic Heatmap

A website to guide users and visualize through a heatmap of the Ortigas, Philippines area of foot-traffic and possible COVID hotspots based on user and admin generated input.


For coursework; Dec 11, 2021


## Features
- Users
    - Login
    - Registration
    - Edit Profile
    - Forgot Password
        - Account authentication for Update Password
    - Users can recommend new registered locations
- Admin
    - Admin Login and Panel
    - Review and approve recommended locations
    - Access user database
    - Add new locations
    - Approve user-generated content and checkouts if necessary or malicious in nature
- MySQL Database Integration  
- Responsive design
- OpenStreetMap API Integration with Leaflet
    - Modal Popup from custom pins and markers
    - Displays average visits per hour, visit length, reviews, and number of visitors who were or became COVID-positive
- Custom Heatmap computation
    - Written with Javascript
    - Read via `csv`
- Timebased login (every 24 hours), Survey of the Day
- Checkout of registered locations on the map via form
    - Input custom time if checkout occurs at a later time or after the fact




## Scope and Limitations

All heatmap related data are added by the user upon the admin conferring if the checkout is not of malicious intent / legitimate - these are encoded via the `heatmapdata/heatmap.txt` following the argument of `[lat, lng, intensity]`

Markers can be added by the user and is then confirmed by the administrator through the appropriate web page 

## Screenshots

![Splash Screen](https://user-images.githubusercontent.com/87105826/212535286-7d726660-04e5-4da1-81f4-7146e38d2c0b.jpg)
![Registration Screen, Step 1 of 3](https://user-images.githubusercontent.com/87105826/212535295-3f63c87d-c922-48c4-befd-bfa591096377.jpg)
![Sign In screen](https://user-images.githubusercontent.com/87105826/212535300-b128e4a7-d928-4eb7-b112-e4485936eaff.jpg)
![Map display after login](https://user-images.githubusercontent.com/87105826/212535303-57fb612e-8742-41b3-8c88-1a87e66a2990.jpg)
![Screen showing a modal and location details](https://user-images.githubusercontent.com/87105826/212535306-2706b44c-9d02-48ea-ae6a-ec154f74232c.jpg)



## Authors

- [@Meepster212](https://github.com/Meepster212)
- [@Havoc-1](https://github.com/Havoc-1)

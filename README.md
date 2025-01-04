<img width="1440" alt="image" src="https://github.com/user-attachments/assets/5995a3b3-4b40-4e4c-baf0-56e4636ebf63" />
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/d7a689cf-b4a3-47bd-82f6-527401bdf87c" />


Project Description

This project is a real-time weather dashboard built using Spring Boot, MongoDB, Thymeleaf, HTML, CSS, and OpenWeatherMap API. It allows users to search for weather information of any city and view dynamic results, including temperature, humidity, wind speed, and other details. The system also caches the data in MongoDB for faster responses.
Features

    Real-time Weather Data: Fetches the latest weather data from the OpenWeatherMap API.
    Caching: Saves weather data in MongoDB to reduce API calls and improve response time.
    Dynamic UI: Uses Thymeleaf templates to render data dynamically.
    City Shortcuts: Quick access buttons for popular cities on the index page.
    Detailed Weather Report: Displays additional details such as visibility, pressure, sunrise, sunset, and more.

Technologies Used

    Backend: Spring Boot, Spring Data MongoDB, RestTemplate
    Frontend: Thymeleaf, HTML, CSS
    Database: MongoDB
    API: OpenWeatherMap API
    Logging: SLF4J with Logback

How It Works

    User Interaction:
    The user can either enter a city name in the search bar or click one of the popular city buttons on the index page.

    Backend Process:
        The controller receives the city name and checks the MongoDB cache.
        If data is found and recent, it’s returned directly.
        If data is not found or outdated, it fetches fresh data from the OpenWeatherMap API, saves it in MongoDB, and returns the result.

    UI Rendering:
    The dashboard page dynamically displays the weather data using Thymeleaf variables.

Setup Instructions
1. Prerequisites

    Java 17+
    Maven 3.6+
    MongoDB (Ensure MongoDB is running locally or use a cloud MongoDB service)
    OpenWeatherMap API Key (Sign up at OpenWeatherMap to get your free API key)

2. Clone the Repository

git clone <repository-url>
cd real-time-weather-dashboard

3. Configure the Application

    Open application.properties and set your API key and MongoDB connection details:

weather.api.url=http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric
weather.api.key=YOUR_API_KEY_HERE

spring.data.mongodb.uri=mongodb://localhost:27017/weatherdb

4. Build and Run the Application

mvn clean install
mvn spring-boot:run

The application will start on http://localhost:8080.
5. Access the Application

    Open http://localhost:8080 in your browser.
    Search for a city or click one of the popular city buttons.
    View detailed weather information on the dashboard.

Project Structure

src
└── main
    ├── java
    │   └── com.weather
    │       ├── controller
    │       │   └── WeatherController.java  # Handles HTTP requests
    │       ├── model
    │       │   └── Weather.java            # Weather data model with nested classes
    │       ├── repository
    │       │   └── WeatherRepository.java  # Spring Data MongoDB repository
    │       └── service
    │           └── WeatherService.java     # Business logic and API calls
    └── resources
        ├── static
        │   ├── css
        │   │   └── style.css               # CSS for UI styling
        │   └── images                      # Placeholder for images (if any)
        ├── templates
        │   ├── index.html                  # Landing page with city search
        │   └── dashboard.html              # Dashboard to display weather details
        └── application.properties          # Application configuration file

API Details

    OpenWeatherMap API
    URL: http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric
    Method: GET
    Response: JSON object containing weather details such as temperature, humidity, wind speed, etc.

Enhancements (Future Scope)

    UI Enhancements:
        Add more styling with Bootstrap or Tailwind CSS.
        Improve responsiveness for mobile devices.

    Error Handling:
        Display user-friendly error messages for invalid city names or network issues.

    Unit & Integration Tests:
        Add JUnit and Mockito-based tests for better test coverage.

    Cloud Deployment:
        Deploy the app on cloud platforms like Heroku, AWS, or Google Cloud for public access.

License

This project is licensed under the MIT License.
Contributors

    CHANDRA SHEKHAR – Java Backend Developer

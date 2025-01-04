package com.weather.service;

import com.weather.model.Weather;
import com.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WeatherService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public Weather getWeatherByCity(String city) {
        logger.info("Fetching weather for city: {}", city);

        // Call external API to get weather data
        String url = String.format(apiUrl, city, apiKey);
        logger.debug("API URL: {}", url);  // Log the URL being used for the API request

        Weather weather = null;
        try {
            // Make the API call and capture the response
            weather = restTemplate.getForObject(url, Weather.class);
            
            if (weather != null) {
                // Log detailed information from the response
                logger.info("Weather data received for city: {} - Temp: {}°C, Humidity: {}%, Wind Speed: {} m/s, Description: {}",
                        city, 
                        weather.getMain().getTemp(), 
                        weather.getMain().getHumidity(), 
                        weather.getWind().getSpeed(), 
                        weather.getWeather()[0].getDescription());

                // Save the weather data to MongoDB
                weather.setCity(city);  // Ensure the city is correctly set
                weatherRepository.save(weather);
                logger.info("Weather data saved to MongoDB for city: {}", city);
            } else {
                logger.warn("No weather data found for city: {}", city);
            }
        } catch (Exception e) {
            logger.error("Error fetching weather data for city: {}", city, e);
        }

        return weather;
    }
}
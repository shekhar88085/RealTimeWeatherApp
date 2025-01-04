package com.weather.controller;

import com.weather.model.Weather;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // Mapping for the homepage
    @GetMapping("/")
    public String showHomePage() {
        return "index";  // This will return the index.html template
    }

    // Mapping to display weather for a specific city
    @GetMapping("/weather")
    public String getWeather(@RequestParam(name = "city", required = false, defaultValue = "London") String city, Model model) {
        Weather weather = weatherService.getWeatherByCity(city);
        model.addAttribute("weather", weather);  // Add weather data to the model
        return "dashboard";  // This will render dashboard.html
    }
}
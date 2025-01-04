package com.weather.repository;

import com.weather.model.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherRepository extends MongoRepository<Weather, String> {
    Weather findByCity(String city);
}
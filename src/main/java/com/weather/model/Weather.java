package com.weather.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Weather {
    @Id
    private String id;
    private String city;
    private Main main;
    private Wind wind;
    private WeatherInfo[] weather;
    private Coord coord;
    private Clouds clouds;
    private Sys sys;
    private int visibility;
    private long dt;
    private int timezone;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }
    public Wind getWind() { return wind; }
    public void setWind(Wind wind) { this.wind = wind; }
    public WeatherInfo[] getWeather() { return weather; }
    public void setWeather(WeatherInfo[] weather) { this.weather = weather; }
    public Coord getCoord() { return coord; }
    public void setCoord(Coord coord) { this.coord = coord; }
    public Clouds getClouds() { return clouds; }
    public void setClouds(Clouds clouds) { this.clouds = clouds; }
    public Sys getSys() { return sys; }
    public void setSys(Sys sys) { this.sys = sys; }
    public int getVisibility() { return visibility; }
    public void setVisibility(int visibility) { this.visibility = visibility; }
    public long getDt() { return dt; }
    public void setDt(long dt) { this.dt = dt; }
    public int getTimezone() { return timezone; }
    public void setTimezone(int timezone) { this.timezone = timezone; }

    // Nested Classes
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private double pressure;
        private double humidity;
        private double sea_level;
        private double grnd_level;

        // Getters and Setters
        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }
        public double getFeels_like() { return feels_like; }
        public void setFeels_like(double feels_like) { this.feels_like = feels_like; }
        public double getTemp_min() { return temp_min; }
        public void setTemp_min(double temp_min) { this.temp_min = temp_min; }
        public double getTemp_max() { return temp_max; }
        public void setTemp_max(double temp_max) { this.temp_max = temp_max; }
        public double getPressure() { return pressure; }
        public void setPressure(double pressure) { this.pressure = pressure; }
        public double getHumidity() { return humidity; }
        public void setHumidity(double humidity) { this.humidity = humidity; }
        public double getSea_level() { return sea_level; }
        public void setSea_level(double sea_level) { this.sea_level = sea_level; }
        public double getGrnd_level() { return grnd_level; }
        public void setGrnd_level(double grnd_level) { this.grnd_level = grnd_level; }
    }

    public static class Wind {
        private double speed;
        private double deg;
        private double gust;

        // Getters and Setters
        public double getSpeed() { return speed; }
        public void setSpeed(double speed) { this.speed = speed; }
        public double getDeg() { return deg; }
        public void setDeg(double deg) { this.deg = deg; }
        public double getGust() { return gust; }
        public void setGust(double gust) { this.gust = gust; }
    }

    public static class WeatherInfo {
        private String description;
        private String main;
        private String icon;

        // Getters and Setters
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getMain() { return main; }
        public void setMain(String main) { this.main = main; }
        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }
    }

    public static class Coord {
        private double lon;
        private double lat;

        // Getters and Setters
        public double getLon() { return lon; }
        public void setLon(double lon) { this.lon = lon; }
        public double getLat() { return lat; }
        public void setLat(double lat) { this.lat = lat; }
    }

    public static class Clouds {
        private int all;

        // Getters and Setters
        public int getAll() { return all; }
        public void setAll(int all) { this.all = all; }
    }

    public static class Sys {
        private String country;
        private long sunrise;
        private long sunset;

        // Getters and Setters
        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }
        public long getSunrise() { return sunrise; }
        public void setSunrise(long sunrise) { this.sunrise = sunrise; }
        public long getSunset() { return sunset; }
        public void setSunset(long sunset) { this.sunset = sunset; }
    }
}
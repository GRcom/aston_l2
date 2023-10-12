package com.example.weatherapp.mapper;

import com.example.weatherapp.model.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.example.weatherapp.service.WeatherService.doRequest;

public class WeatherMapper {
    ObjectMapper objectMapper = new ObjectMapper();

    public Weather jsonStringToWeather(String city) throws IOException, URISyntaxException, InterruptedException {

        String jsonString = doRequest(city).body();
        return objectMapper.readValue(jsonString, Weather.class);
    }
}

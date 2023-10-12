package com.example.weatherapp;

import com.example.weatherapp.model.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JacksonTest {

    String api = "https://api.weatherapi.com/v1/forecast.json?key=e4ce6a8ce51d4dfaadb192525230910&q=нижний+новгород&days=3&aqi=no&alerts=no";

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonStringToPojo() throws IOException, InterruptedException, URISyntaxException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(new URI(api))
                .GET()
                .build();
        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());



        Weather weather = objectMapper.readValue(response.body(), Weather.class);

        System.out.println(weather.getLocation().getLocaltime());
//        System.out.println(weather.getForecast().getForecastDay().get(2).getDay().getAvgTemperature());

    }

}

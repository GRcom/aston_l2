package com.example.weatherapp.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherService {

    private WeatherService() {

    }
    public static HttpResponse<String> doRequest(String city) throws URISyntaxException, IOException, InterruptedException {
        String api = "https://api.weatherapi.com/v1/forecast.json?key=e4ce6a8ce51d4dfaadb192525230910&lang=ru&q=";
        String reqApi = api + city.replace(" ", "") + "&days=3&aqi=no&alerts=no";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(new URI(reqApi))
                .GET()
                .build();

        return client.send(req, HttpResponse.BodyHandlers.ofString());
    }
}

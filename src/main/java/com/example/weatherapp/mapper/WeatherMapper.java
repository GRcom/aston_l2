package com.example.weatherapp.mapper;

import com.example.weatherapp.model.WeatherDto;
import com.example.weatherapp.model.WeatherForAnyDaysAndHours;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import static com.example.weatherapp.service.WeatherService.doRequest;

public class WeatherMapper {
    ObjectMapper objectMapper = new ObjectMapper();

    public WeatherForAnyDaysAndHours jsonStringToWeather(String city, String hours) throws IOException, URISyntaxException, InterruptedException {

        String jsonString = doRequest(city).body();

        WeatherDto rawData = objectMapper.readValue(jsonString, WeatherDto.class);

        return weatherDtoToWeatherForAnyDaysAndHours(rawData, hours);
    }


    private WeatherForAnyDaysAndHours weatherDtoToWeatherForAnyDaysAndHours(WeatherDto weatherDto, String hours) {
        List<WeatherDto.Day> days = weatherDto.getForecast().getForecastDay()
                .stream()
                .map(forecastDay -> {
                    forecastDay.getDay().setDate(forecastDay.getDate());
                    return forecastDay;
                })
                .map(WeatherDto.ForecastDay::getDay)
                .toList();

        LocalDateTime localDateTimeNow;
        try {
            localDateTimeNow = LocalDateTime.parse(weatherDto.getLocation().getLocaltime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        } catch (DateTimeParseException e) {
            localDateTimeNow = LocalDateTime.parse(weatherDto.getLocation().getLocaltime(), DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm"));
        }

        LocalDateTime finalLocalDateTimeNow = localDateTimeNow;

        List<WeatherDto.Hour> hoursData = weatherDto.getForecast().getForecastDay()
                .stream()
                .flatMap(forecastDay -> forecastDay.getHour().stream())
                .filter(hour -> finalLocalDateTimeNow.isBefore(LocalDateTime.parse(hour.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))))
                .limit(Integer.parseInt(hours))
                .toList();

        return WeatherForAnyDaysAndHours.builder()
                .location(weatherDto.getLocation())
                .current(weatherDto.getCurrent())
                .days(days)
                .hours(hoursData)
                .build();
    }
}

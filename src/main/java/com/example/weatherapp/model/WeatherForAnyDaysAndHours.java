package com.example.weatherapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForAnyDaysAndHours {

    private WeatherDto.Location location;
    private WeatherDto.Current current;
    private List<WeatherDto.Day> days;
    private List<WeatherDto.Hour> hours;


}

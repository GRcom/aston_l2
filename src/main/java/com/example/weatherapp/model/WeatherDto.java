package com.example.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {
    @JsonProperty("location")
    private Location location;
    @JsonProperty("current")
    private Current current;
    @JsonProperty("forecast")
    private Forecast forecast;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Location {
        @JsonProperty("name")
        private String name;
        @JsonProperty("region")
        private String region;
        @JsonProperty("country")
        private String country;
        @JsonProperty("localtime")
        private String localtime;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Current {
        @JsonProperty("temp_c")
        private String temperature;
        @JsonProperty("feelslike_c")
        private String temperatureFeelslike;
        @JsonProperty("wind_kph")
        private String wind;
        @JsonProperty("humidity")
        private String humidity;
        @JsonProperty("pressure_mb")
        private String pressure;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Forecast {
        @JsonProperty("forecastday")
        private List<ForecastDay> forecastDay;

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class ForecastDay {
        @JsonProperty("date")
        private String date;
        @JsonProperty("day")
        private Day day;
        @JsonProperty("hour")
        private List<Hour> hour;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Day {
        @JsonIgnore
        private String date;
        @JsonProperty("avgtemp_c")
        private String avgTemperature;
        @JsonProperty("maxtemp_c")
        private String maxTemperature;
        @JsonProperty("mintemp_c")
        private String minTemperature;
        @JsonProperty("maxwind_kph")
        private String maxWind;
        @JsonProperty("totalprecip_mm")
        private String totalPrecip;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Hour {
        @JsonProperty("time")
        private String time;
        @JsonProperty("temp_c")
        private String temperature;
        @JsonProperty("humidity")
        private String humidity;
        @JsonProperty("wind_kph")
        private String wind;
        @JsonProperty("chance_of_rain")
        private String chanceOfRain;
        @JsonProperty("chance_of_snow")
        private String chanceOfSnow;
        @JsonProperty("condition")
        private Condition condition;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Condition {
        @JsonProperty("text")
        private String text;
    }
}


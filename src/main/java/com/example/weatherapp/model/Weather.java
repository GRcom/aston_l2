package com.example.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.concurrent.locks.Condition;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private static final String API = "https://api.weatherapi.com/v1/";
    private static final String API_KEY = "e4ce6a8ce51d4dfaadb192525230910";

    @JsonProperty("location")
    private Location location;
    @JsonProperty("current")
    private Current current;
    @JsonProperty("forecast")
    private Forecast forecast;

    public Weather() {
        location = new Location();
        current = new Current();
        forecast = new Forecast();
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        @JsonProperty("name")
        private String name;
        @JsonProperty("region")
        private String region;
        @JsonProperty("country")
        private String country;
        @JsonProperty("localtime")
        private String localtime;

        public String getName() {
            return name;
        }

        public String getRegion() {
            return region;
        }

        public String getCountry() {
            return country;
        }

        public String getLocaltime() {
            return localtime;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
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

        public String getTemperature() {
            return temperature;
        }

        public String getTemperatureFeelslike() {
            return temperatureFeelslike;
        }

        public String getWind() {
            return wind;
        }

        public String getHumidity() {
            return humidity;
        }

        public String getPressure() {
            return pressure;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Forecast {
        @JsonProperty("forecastday")
        private List<ForecastDay> forecastDay;

        public List<ForecastDay> getForecastDay() {
            return forecastDay;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ForecastDay {
        @JsonProperty("date")
        private String date;
        @JsonProperty("day")
        private Day day;
        @JsonProperty("hour")
        private List<Hour> hour;

        public String getDate() {
            return date;
        }

        public Day getDay() {
            return day;
        }

        public List<Hour> getHour() {
            return hour;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Day {
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

        public String getAvgTemperature() {
            return avgTemperature;
        }

        public String getMaxTemperature() {
            return maxTemperature;
        }

        public String getMinTemperature() {
            return minTemperature;
        }

        public String getMaxWind() {
            return maxWind;
        }

        public String getTotalPrecip() {
            return totalPrecip;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
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

        public String getTime() {
            return time;
        }

        public String getTemperature() {
            return temperature;
        }

        public String getHumidity() {
            return humidity;
        }

        public String getWind() {
            return wind;
        }

        public String getChanceOfRain() {
            return chanceOfRain;
        }

        public String getChanceOfSnow() {
            return chanceOfSnow;
        }

        public Condition getCondition() {
            return condition;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Condition {
        @JsonProperty("text")
        private String text;

        public String getText() {
            return text;
        }
    }

}


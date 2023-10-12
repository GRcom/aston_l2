package com.example.weatherapp.web;

import com.example.weatherapp.mapper.WeatherMapper;
import com.example.weatherapp.model.WeatherForAnyDaysAndHours;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URISyntaxException;

@WebServlet(name = "weatherServlet", value = "/weather")
public class WeatherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String city = request.getParameter("city");
        String hours = request.getParameter("hours");
        WeatherMapper weatherMapper = new WeatherMapper();
        WeatherForAnyDaysAndHours weatherForAnyDaysAndHours;
        try {
            weatherForAnyDaysAndHours = weatherMapper.jsonStringToWeather(city, hours);
        } catch (URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("weatherDtoData", weatherForAnyDaysAndHours);
        RequestDispatcher dispatcher = request.getRequestDispatcher("weather.jsp");
        dispatcher.forward(request, response);
    }

}
package com.example.weatherapp.web;

import com.example.weatherapp.mapper.WeatherMapper;
import com.example.weatherapp.model.Weather;
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
    public void init(ServletConfig config) throws ServletException {
        super.init();


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String city = request.getParameter("city");
        WeatherMapper weatherMapper = new WeatherMapper();
        Weather weatherData;
        try {
            weatherData = weatherMapper.jsonStringToWeather(city);
        } catch (URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("weatherData", weatherData);
        RequestDispatcher dispatcher = request.getRequestDispatcher("weather.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
    }
}
<%@ page import="com.example.weatherapp.model.Weather" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 11.10.2023
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Weather</title>
    <style type="text/css">
        table {
            border-collapse: collapse; /* Отображать двойные линии как одинарные */
        }

        th {
            background: #ccc; /* Цвет фона */
            text-align: left; /* Выравнивание по левому краю */
        }

        td, th {
            border: 1px solid #800; /* Параметры границы */
            padding: 4px; /* Поля в ячейках */
        }
    </style>
</head>
<body>
<section>
    <h3>Местоположение</h3>
    <% Weather weather = (Weather) request.getAttribute("weatherData"); %>
    <table>
        <tr>
            <th>Город</th>
            <th>Регион</th>
            <th>Страна</th>
            <th>Местное время</th>
        </tr>
        <%

            String timeNow = weather.getLocation().getLocaltime();
            String dateNow = weather.getLocation().getLocaltime();
            if (timeNow == null || dateNow == null) {
                timeNow = "10:00";
                dateNow = "2023-10-12";
            } else {
                timeNow = timeNow.split(" ")[1];
                dateNow = dateNow.split(" ")[0];
            }
            LocalDate parsedDate = LocalDate.parse(dateNow, DateTimeFormatter.ISO_LOCAL_DATE);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String timeNowFormatted = timeNow + " " + dateFormatter.format(parsedDate);
        %>
        <tr>
            <td><%=weather.getLocation().getName()%>
            </td>
            <td><%=weather.getLocation().getRegion()%>
            </td>
            <td><%=weather.getLocation().getCountry()%>
            </td>
            <td><%=timeNowFormatted%>
            </td>
        </tr>
    </table>
    <h3>Погода</h3>
    <table>
        <tr>
            <th>Температура</th>
            <th>Ощущается как</th>
            <th>Влажность</th>
            <th>Скорость ветра</th>
            <th>Давление</th>
        </tr>
        <tr>
            <td><%=weather.getCurrent().getTemperature()%>°C</td>
            <td><%=weather.getCurrent().getTemperatureFeelslike()%>°C</td>
            <td><%=weather.getCurrent().getHumidity()%>%</td>
            <td><%=weather.getCurrent().getWind()%>км/ч</td>
            <td><%=weather.getCurrent().getPressure()%>мБ</td>
        </tr>
    </table>
    <h3>Погода на ближайшие часы</h3>
    <table>
        <tr>
            <th>Время</th>
            <th>Температура</th>
            <th>Скорость ветра</th>
            <th>Влажность</th>
            <th>Шанс дождя</th>
            <th>Шанс снега</th>
            <th>На улице</th>
        </tr>
        <%
            int timeCase = Integer.parseInt(timeNow.split(":")[0]) + 1;
            int[] hours = {0, 1, 2};
            boolean isEndOfDay = false;
            switch (timeCase) {
                case 1:
                    hours = new int[]{1, 2, 3};
                    break;
                case 2:
                    hours = new int[]{2, 3, 4};
                    break;
                case 3:
                    hours = new int[]{3, 4, 5};
                    break;
                case 4:
                    hours = new int[]{4, 5, 6};
                    break;
                case 5:
                    hours = new int[]{5, 6, 7};
                    break;
                case 6:
                    hours = new int[]{6, 7, 8};
                    break;
                case 7:
                    hours = new int[]{7, 8, 9};
                    break;
                case 8:
                    hours = new int[]{8, 9, 10};
                    break;
                case 9:
                    hours = new int[]{9, 10, 11};
                    break;
                case 10:
                    hours = new int[]{10, 11, 12};
                    break;
                case 11:
                    hours = new int[]{11, 12, 13};
                    break;
                case 12:
                    hours = new int[]{12, 13, 14};
                    break;
                case 13:
                    hours = new int[]{13, 14, 15};
                    break;
                case 14:
                    hours = new int[]{14, 15, 16};
                    break;
                case 15:
                    hours = new int[]{15, 16, 17};
                    break;
                case 16:
                    hours = new int[]{16, 17, 18};
                    break;
                case 17:
                    hours = new int[]{17, 18, 19};
                    break;
                case 18:
                    hours = new int[]{18, 19, 20};
                    break;
                case 19:
                    hours = new int[]{19, 20, 21};
                    break;
                case 20:
                    hours = new int[]{20, 21, 22};
                    break;
                case 21:
                    hours = new int[]{21, 22, 23};
                    break;
                case 22:
                    hours = new int[]{22, 23};
                    isEndOfDay = true;
                    break;
                case 23:
                    hours = new int[]{23};
                    isEndOfDay = true;
                    break;
                case 24:
                    hours = new int[]{23};
                    isEndOfDay = true;
                    break;
            }

            for (int el : hours) {
        %>
        <tr>
            <td><%=weather.getForecast().getForecastDay().get(0).getHour().get(el).getTime().split(" ")[1]%>
            </td>
            <td><%=weather.getForecast().getForecastDay().get(0).getHour().get(el).getTemperature()%>°C</td>
            <td><%=weather.getForecast().getForecastDay().get(0).getHour().get(el).getWind()%>км/ч</td>
            <td><%=weather.getForecast().getForecastDay().get(0).getHour().get(el).getHumidity()%>%</td>
            <td><%=weather.getForecast().getForecastDay().get(0).getHour().get(el).getChanceOfRain()%>%</td>
            <td><%=weather.getForecast().getForecastDay().get(0).getHour().get(el).getChanceOfSnow()%>%</td>
            <td><%=weather.getForecast().getForecastDay().get(0).getHour().get(el).getCondition().getText()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <h3>Прогноз на три дня</h3>
    <table>
        <tr>
            <th>Дата</th>
            <th>Средняя температура</th>
            <th>Максимальная температура</th>
            <th>Минимальная температура</th>
            <th>Порывы ветра до</th>
            <th>Осадки</th>
        </tr>
        <%
            for (int i = 0; i < 3; i++) {
                var day = weather.getForecast().getForecastDay().get(i);
                parsedDate = LocalDate.parse(day.getDate(), DateTimeFormatter.ISO_LOCAL_DATE);
                String date = dateFormatter.format(parsedDate);
        %>
        <tr>
            <td><%=date%>
            </td>
            <td><%=day.getDay().getAvgTemperature()%>°C</td>
            <td><%=day.getDay().getMaxTemperature()%>°C</td>
            <td><%=day.getDay().getMinTemperature()%>°C</td>
            <td><%=day.getDay().getMaxWind()%>км/ч</td>
            <td><%=day.getDay().getTotalPrecip()%>мм</td>
        </tr>
        <%}%>
    </table>
</section>
</body>
</html>

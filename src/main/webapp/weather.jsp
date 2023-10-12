<%@ page import="com.example.weatherapp.model.WeatherForAnyDaysAndHours" %>
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
    <% WeatherForAnyDaysAndHours weatherForAnyDaysAndHours = (WeatherForAnyDaysAndHours) request.getAttribute("weatherDtoData"); %>
    <table>
        <tr>
            <th>Город</th>
            <th>Регион</th>
            <th>Страна</th>
            <th>Местное время</th>
        </tr>

        <tr>
            <td><%=weatherForAnyDaysAndHours.getLocation().getName()%>
            </td>
            <td><%=weatherForAnyDaysAndHours.getLocation().getRegion()%>
            </td>
            <td><%=weatherForAnyDaysAndHours.getLocation().getCountry()%>
            </td>
            <td><%=weatherForAnyDaysAndHours.getLocation().getLocaltime()%>
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
            <td><%=weatherForAnyDaysAndHours.getCurrent().getTemperature()%>°C</td>
            <td><%=weatherForAnyDaysAndHours.getCurrent().getTemperatureFeelslike()%>°C</td>
            <td><%=weatherForAnyDaysAndHours.getCurrent().getHumidity()%>%</td>
            <td><%=weatherForAnyDaysAndHours.getCurrent().getWind()%>км/ч</td>
            <td><%=weatherForAnyDaysAndHours.getCurrent().getPressure()%>мБ</td>
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
        <% for (int i = 0; i < weatherForAnyDaysAndHours.getHours().size(); i++) {
            var hour = weatherForAnyDaysAndHours.getHours().get(i);
        %>
        <tr>
            <td><%=hour.getTime()%>
            </td>
            <td><%=hour.getTemperature()%>°C</td>
            <td><%=hour.getWind()%>км/ч</td>
            <td><%=hour.getHumidity()%>%</td>
            <td><%=hour.getChanceOfRain()%>%</td>
            <td><%=hour.getChanceOfSnow()%>%</td>
            <td><%=hour.getCondition().getText()%>
            </td>
        </tr>
        <%}%>
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
                var day = weatherForAnyDaysAndHours.getDays().get(i);
        %>
        <tr>
            <td><%=day.getDate()%>
            </td>
            <td><%=day.getAvgTemperature()%>°C</td>
            <td><%=day.getMaxTemperature()%>°C</td>
            <td><%=day.getMinTemperature()%>°C</td>
            <td><%=day.getMaxWind()%>км/ч</td>
            <td><%=day.getTotalPrecip()%>мм</td>
        </tr>
        <%}%>
    </table>
</section>
</body>
</html>

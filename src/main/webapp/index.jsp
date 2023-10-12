<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>WeatherApp</title>
    <script>
        function f() {
            var login = document.getElementById('login')
            login.value = login.value.replace(/\s/g, '')
        }
    </script>
</head>
<body>
<h1><%= "Привет!" %>
</h1>
<p><%= "Здесь ты можешь узнать погоду на сейчас, на день или ближайшие три дня" %>
</p>
<p><%= "Выбери свой город или впиши вручную, если твоего города нет в списке:" %>
</p>
<a href="${pageContext.request.contextPath}/weather?city=Москва&hours=5">Москва</a>
<br/>
<a href="${pageContext.request.contextPath}/weather?city=Saint-Petersburg&hours=5">Санкт-Петербург</a>
<br/>
<a href="${pageContext.request.contextPath}/weather?city=Казань&hours=5">Казань</a>
<br><br>
<form action="${pageContext.request.contextPath}/weather">
    <label for="search-input">Ваш город:<br></label>
    <input type="text" id="search-input" name="city"  required>
    <br><br>
    <label for="hours">Показать погоду на ближайшие:</label>
    <select id="hours" name="hours">
        <option value="3">3 часа</option>
        <option value="4">4 часа</option>
        <option value="5">5 часов</option>
    </select>
    <input type="submit" value="Найти">
</form>

</body>
</html>
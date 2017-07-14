<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 13.07.2017
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>The game</title>
    <spring:url value="/resources/foundation/css/foundation.css" var="foundation"/>
    <link rel="stylesheet" href="${foundation}"/>
</head>
<body>
<h2>${card.word}</h2>
<h2 id="hhh" style="visibility: hidden">${card.description}</h2>
<a id="btnv" class="button">Увидеть</a>
<a href="/game/know" class="button">Знаю</a>
<a href="/game/donotknow" class="button">Не знаю</a>
<a href="/game/stopgame" class="button">Остановить игру</a>


<spring:url value="/resources/foundation/js/vendor/jquery.js" var="jquery"/>
<spring:url value="/resources/foundation/js/vendor/what-input.js" var="whatInput"/>
<spring:url value="/resources/foundation/js/vendor/foundation.min.js" var="jsfoundation"/>
<script src="${jquery}"></script>
<script src="${whatInput}"></script>
<script src="${jsfoundation}"></script>
<script>
    $(document).foundation();
</script>
<script>
    $(document).ready(function(){
        $("#btnv").click(function(){
            $("#hhh").css("visibility","visible");
        });
    });
</script>
</body>
</html>

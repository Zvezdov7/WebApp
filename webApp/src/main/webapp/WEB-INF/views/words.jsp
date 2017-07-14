<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10.07.2017
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Words</title>
    <spring:url value="/resources/foundation/css/foundation.css" var="foundation"/>
    <link rel="stylesheet" href="${foundation}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<form:form method="post" action="/words/addnewcard" commandName="carddto">
    <label>Введите слово
        <form:input type="text" placeholder="Пример" aria-describedby="exampleHelpText" path="word"/>
    </label>
    <p class="help-text" id="one">Введите слово</p>
    <label>Введите перевод
        <form:input type="text" placeholder="Esempio" aria-describedby="exampleHelpText" path="description"/>
    </label>
    <p class="help-text" id="two">Введите перевод</p>
    <div class="switch small">
        <form:checkbox path="loadMp3" class="switch-input" id="smallSwitch" name="exampleSwitch"/>
        <label class="switch-paddle" for="smallSwitch">
            <span class="show-for-sr">Small Portions Only</span>
        </label>
    </div>
    <input type="submit" value="Добавить" class="button"/>
</form:form>
<a href="/words/file.json" class="button">Download Json</a>
<form method="POST" action="/words/uploadJson" enctype="multipart/form-data">
    File to upload: <input type="file" name="file">
    <input type="submit" value="Upload"> Upload Json
</form>
<table>
    <thead>
    <tr>
        <th width="200">Id</th>
        <th>Word</th>
        <th width="150">Description</th>
        <th width="150">Grade</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="card" items="${cards}">
        <tr>
            <td>${card.id}</td>
            <td>${card.word}</td>
            <td>${card.description}</td>
            <td>${card.grade}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form:form method="post" action="/game">
    <select name="grade">
        <label>Select Menu</label>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
    <input type="submit" class="button" value="Начать игру">
</form:form>
<spring:url value="/resources/foundation/js/vendor/jquery.js" var="jquery"/>
<spring:url value="/resources/foundation/js/vendor/what-input.js" var="whatInput"/>
<spring:url value="/resources/foundation/js/vendor/foundation.min.js" var="jsfoundation"/>
<script src="${jquery}"></script>
<script src="${whatInput}"></script>
<script src="${jsfoundation}"></script>
<script>
    $(document).foundation();
</script>
</body>
</html>

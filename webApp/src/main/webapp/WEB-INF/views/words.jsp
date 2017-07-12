<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10.07.2017
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Words</title>
    <spring:url value="/resources/foundation/css/foundation.css" var="foundation"/>
    <link rel="stylesheet" href="${foundation}"/>
    <meta charset="UTF-8">
</head>
<body>
<form:form method="post" action="/words/addnewcard" commandName="carddto">
    <label>Введите слово
        <form:input type="text" placeholder=".small-12.columns" aria-describedby="exampleHelpText" path="word" />
    </label>
    <%--<p class="help-text" id="one">Here's how you use this input field!</p>--%>
    <label>Введите перевод
        <form:input type="text" placeholder=".small-12.columns" aria-describedby="exampleHelpText" path="description" />
    </label>
    <%--<p class="help-text" id="two">Here's how you use this input field!</p>--%>
    <input type="submit" value="Добавить" class="button"/>
</form:form>
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

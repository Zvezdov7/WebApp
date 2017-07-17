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
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <form:form method="post" action="/words/addnewcard" commandName="carddto">
                <label>Введите слово
                    <form:input class="form-control" type="text" placeholder="Пример" aria-describedby="exampleHelpText"
                                path="word"/>
                </label>
                <p class="help-text" id="one">Введите слово</p>
                <label>Введите перевод
                    <form:input class="form-control" type="text" placeholder="Esempio"
                                aria-describedby="exampleHelpText" path="description"/>
                </label>
                <p class="help-text" id="two">Введите перевод</p>
                <div class="switch small">
                    <form:checkbox path="loadMp3" class="switch-input" id="smallSwitch" name="exampleSwitch"/>
                    <label class="switch-paddle" for="smallSwitch">
                        <span class="show-for-sr">Small Portions Only</span>
                    </label>
                </div>
                <input type="submit" value="Добавить" class="btn btn-default"/>
            </form:form>
        </div>
        <div class="col-md-4">
            <a href="/words/file.json" class="btn btn-default">Download Json</a>
            <form method="POST" action="/words/uploadJson" enctype="multipart/form-data">
                File to upload: <input type="file" name="file">
                <input type="submit" value="Upload"> Upload Json
            </form>

            <form:form method="post" action="/game">
                <select name="grade">
                    <label>Select Menu</label>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
                <input type="submit" class="btn btn-default" value="Начать игру">
            </form:form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <table class="table">
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
                        <%--<td><a href="/game/know" class="btn btn-default">Изменить</a></td>--%>
                        <td><a href="/words/deletecard/${card.id}" class="btn btn-default">Удалить</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script>
        $(document).foundation();
    </script>
</div>
</body>
</html>

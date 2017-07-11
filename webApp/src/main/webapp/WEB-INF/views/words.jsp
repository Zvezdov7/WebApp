<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10.07.2017
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Words</title>
    <spring:url value="/resources/foundation/css/foundation.css" var="foundation"/>
    <link rel="stylesheet" href="${foundation}"/>
</head>
<body>
<form>
    <label>Input Label
        <input type="text" placeholder=".small-12.columns" aria-describedby="exampleHelpText">
    </label>
    <p class="help-text" id="one">Here's how you use this input field!</p>
    <label>Input Label
        <input type="text" placeholder=".small-12.columns" aria-describedby="exampleHelpText">
    </label>
    <p class="help-text" id="two">Here's how you use this input field!</p>
    <a href="#0" class="button">Learn More</a>
</form>

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

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Developpeur
  Date: 08/05/2023
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <div>
        <a href="<c:url value="?lang=fr" />" class="w3-button">Français</a>
        <a href="<c:url value="?lang=en" />" class="w3-button">English</a>
    </div>
    <h1 style="text-align: center"><spring:message code="application.title"/></h1>
    <a href="countries"><spring:message code="application.countries"/></a>
    <a href="cities"><spring:message code="application.cities"/></a>
</body>
</html>

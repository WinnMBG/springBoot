<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 	CSS (w3css) de la Page -->
<link rel="stylesheet" href="<c:url value="css/w3.css" />" />

<title>Countries JSP</title>

</head>

<body onload="init();">

<%--<jsp:include page="header.jsp"></jsp:include>--%>

	<div class="w3-container">
		<h2 style="text-align: center">Sakila - countries</h2>
		<br>
		<a href="<c:url value="/" />"  class="w3-button">Retour</a>

		<table id="countriesTable" class="w3-centered w3-table-all">
			<thead>
				<tr class="w3-light-grey">
					<th>Id</th>
					<th>Country</th>
					<th>Nombre de villes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${countries}" var="elem">
					<tr>
						<th scope="row">${elem.id}</th>
						<td>${elem.country}</td>
						<td>${elem.getCities().size()}</td>
						<td><a href="citiesOfcountry/${elem.id}" class="w3-button">Voir les villes</a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<!-- JavaScript resources dataTables + jQuery -->

</html>

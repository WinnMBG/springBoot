<%--
  Created by IntelliJ IDEA.
  User: winn7
  Date: 10/05/2023
  Time: 14 h 00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="countryForm" action="countryModify" method="POST">
        <table>
            <tr>
                <td>Id Pays</td>
                <td><input type="number" name="id" value="${country.id}"/> </td>
                <td><input type="text" name="country" value="${country.country}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
                <td><input type="submit" value="Clear"/></td>
            </tr>
        </table>
    </form>
</body>
</html>

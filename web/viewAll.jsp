<%--
  Created by IntelliJ IDEA.
  User: Diego's Dell PC
  Date: 3/30/2019
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table,th,td{
            border-collapse: collapse;
            border:1px solid black;
            padding: 10px;
        }
    </style>
</head>
<body>
<table>
<tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th></th>

</tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td><c:out value="${user.firstname}"/></td>
        <td><c:out value="${user.lastname}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td>
            <form action="update.jsp" method="post">
                <input type="hidden" name="action" value="delete">
                <input id="xs" type="hidden" value="${user.email}" name="email">
                <input type="submit" value="remove">
            </form>
        </td>
    </tr>

        </c:forEach>
    </table>

</body>
</html>

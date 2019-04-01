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
    <link rel="stylesheet" href="css/styleMain.css">

</head>
<body>
<div>
<table>
<tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>


</tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td><c:out value="${user.firstname}"/></td>
        <td><c:out value="${user.lastname}"/></td>
        <td><c:out value="${user.email}"/></td>
    </tr>

        </c:forEach>
    </table><br><br>
<a href="index.html"> <button> Return to Main Page</button></a>
</div>
</body>
</html>

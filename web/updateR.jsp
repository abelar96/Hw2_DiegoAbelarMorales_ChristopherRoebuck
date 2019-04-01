<%--
  Created by IntelliJ IDEA.
  User: Diego's Dell PC
  Date: 3/31/2019
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="css/styleMain.css">
</head>
<body>
<h1>Update User</h1>
<div>
    <form action="updateR" method="post">

        <input type="hidden" name="action" value="updateRecord">

        <label>Email</label>
        <input type="email" name="email" value="<c:out value="${user.email}"/>" required><br><br>

        <label>First Name</label>
        <input type="text" name="firstName" value="<c:out value="${user.firstname}"/>" required><br><br>

        <label>Last Name</label>
        <input type="text" name="lastName" value="<c:out value="${user.lastname}"/>" required><br><br>

        <input type="hidden" name="id" value="<c:out value="${user.id}"/>">

        <input type="submit" value="Update Record" id="submit">
    </form> <br><br>

    <a href="index.html"> <button> Return to Main Page</button></a>

</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/19/2023
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="calculator" method="post">
<input type="number" name="number1" placeholder="Enter number 1">
<input type="number" name="number2" placeholder="Enter number 2"> <br>
    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="*">Multiplication(*)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>
</form>
<c:if test="${result != null}">
    Kết quả: ${result}
</c:if>
</body>
</html>

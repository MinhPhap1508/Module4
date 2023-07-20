<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/20/2023
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
  <legend>Email details</legend>
<table border="1px">
  <tr>
    <td>Languages</td>
    <td>${info.languages}</td>
  </tr>
  <tr>
    <td>Page Size</td>
    <td>${info.pageSize}</td>
  </tr>
  <tr>
    <td>Spams filter</td>
    <td>${info.filter}</td>
  </tr>
  <tr>
    <td>Signature</td>
    <td>${info.signature}</td>
  </tr>
</table>
<a href="/update">Update</a>
</fieldset>
</body>
</html>

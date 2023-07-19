<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/19/2023
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich" method="post">
  <input type="checkbox" name="condiments" value="lettuce">Lettuce
  <input type="checkbox" name="condiments" value="tomato">Tomato
  <input type="checkbox" name="condiments" value="mustard">Mustard
  <input type="checkbox" name="condiments" value="sprouts">Sprouts <br>
    <button>Save</button>
</form>
</body>
</html>

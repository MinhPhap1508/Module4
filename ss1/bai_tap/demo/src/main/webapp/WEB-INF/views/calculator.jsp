<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/18/2023
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculate" method="post">
<input type="number" name="usd" placeholder="Enter usd"> <br>
<input type="number" name="rate" placeholder="Enter rate"> <br>
<button>Convert </button>
</form>
Rate after conversion is:
<span>${result}</span>
</body>
</html>

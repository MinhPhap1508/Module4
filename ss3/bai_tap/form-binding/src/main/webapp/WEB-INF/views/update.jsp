<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/20/2023
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail</title>
</head>
<body>
<h1>Setting</h1>
<c:if test="${message != null}">
    <span> ${message}</span>
</c:if>
<form:form action="/update" method="post" modelAttribute="setting">
    <table border="1px">
        <tr>
            <td>Languages</td>
            <td colspan="3"><form:select path="languages" items="${languages}">
            </form:select></td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>Show</td>
            <td colspan="2"><form:select path="pageSize" items="${pageSize}">
            </form:select>Emails per page</td>
        </tr>
        <tr>
            <td>Spams filter: </td>
            <td colspan="3"><form:checkbox path="filter" value="true" label="Enable spams filter"/></td>
        </tr>
        <tr>
            <td>Signature</td>
            <td colspan="3"><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><button>Update</button></td>
            <td><button><a href="/info"></a> Cancel</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>

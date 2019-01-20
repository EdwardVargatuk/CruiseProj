<%--<jsp:useBean id="user" scope="application" type="Beans.Client"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 15.01.2019
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
    <style>
        <%@include file="/WEB-INF/css/style9.css" %>
        <%--<%@include file="/WEB-INF/css/logStyle.css" %>--%>
    </style>
</head>
<body>
<%--<h2 align="center">Welcome</h2>--%>
<%--<hr/>--%>
<div style="text-align: center;">
    <h1>Welcome to Cruises of your dream</h1>
</div>
<div
        style="float: right;  padding: 10px; text-align: right;"
>
    <form name="logoutForm" method="POST" action="controller">
        <input type="hidden" name="command" value="logout"/>
        <tr>
            <td>${loginedUser.userName}, hello!</td>
            <input type="submit" value="Logout"/>
        </tr>

    </form>
</div>
</body>
</html>

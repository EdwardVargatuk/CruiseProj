<%--@elvariable id="loginedUser" type="Beans.Client"--%>
<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 15.01.2019
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>header</title>
    <style>
        <%@include file="/WEB-INF/css/style9.css" %>
        <%@include file="/WEB-INF/css/logStyle.css" %>
    </style>
</head>
<body>
<div style="text-align: center;">
    <h1>Welcome to Cruises of your dream</h1>
</div>
<c:if test="${not empty loginedUser}">
    <div style="float: right;  padding: 10px; text-align: right;">
        <form name="logoutForm" method="POST" action="controller">
            <input type="hidden" name="command" value="logout"/>
                ${loginedUser.userName}, hello!
            <input class="form-submit-button" type="submit" value="Logout"/>
        </form>
    </div>
</c:if>
</body>
</html>

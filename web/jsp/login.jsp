<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 03.01.2019
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        <%@include file="/css/style9.css" %>
        <%@include file="/css/logStyle.css" %>
    </style>
</head>
<body>
<div class="form-style-9">
    <h1><br/>Welcome! </br>A cruise of your dreams is waiting for you! <br/></h1>
    <ul>
        <form name="loginForm" method="POST" action="controller">
            <input type="hidden" name="command" value="login"/>
            <li>
                <label for="nameL">
                    <span>User name:  <br/></span>
                    <input class="field-style field-split align-left" placeholder="Name" type="text" id="nameL"
                           name="login"
                           value=""/>
                </label>
            </li>
            <li>
                <label for="passwordL">
                    <span>   <br/>Password:<br/></span>
                    <input class="field-style field-split align-left" placeholder="Password" type="password"
                           id="passwordL" name="password" value=""/>
                </label>
            </li>
            <br><br/>
            ${errorLoginPassMessage}<br/>
            ${wrongAction}
            <br/>
            ${nullPage}
            <br/>
            <li>
                <input type="submit" value="Log in"/>
            </li>
        </form>
    </ul>
</div>

<c:import url="/jsp/footer.jsp" charEncoding="utf-8"/>

</body>
</html>

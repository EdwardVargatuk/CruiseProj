<%--@elvariable id="cruise" type="Beans.Cruise"--%>
<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 15.01.2019
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Updated Order page</title>
    <style>
        <%@include file="/WEB-INF/css/logStyle.css" %>
        <%@include file="/WEB-INF/css/style9.css" %>
    </style>
</head>
<body>
<c:import url="/WEB-INF/jsp/parts/header.jsp" charEncoding="utf-8"/>
<c:import url="/WEB-INF/jsp/parts/menu.jsp" charEncoding="utf-8"/>
<br>
<br/>
<hr/>
<br>
<div>
    <h1>Ordering, please confirm</h1>
</div>
<div>
    <table align="center" cellpadding="20">
        <tr>
            <td><h2 style="text-align: left">Total price of Cruise:</h2></td>
            <td><h2 style="text-align: right" padding="200">
                <fmt:setLocale value="en_US"/>
                <fmt:formatNumber value="${cruise.price}" type="currency"/></h2></td>
        </tr>
        <tr>
            <td><h2 style="text-align: left">Departure date:</h2></td>
            <td><h2 style="text-align: right">${cruise.date}</h2></td>
        </tr>
        <tr>
            <td><h2 style="text-align: left">Ship:</h2></td>
            <td><h2 style="text-align: right" padding="200">${ship.shipName}</h2></td>
        </tr>
    </table>
</div>

<div align="center">
    <form name="shipInfoForm1" method="POST" action="controller">
        <input type="hidden" name="command" value="confirmOrder"/>
        <input class="form-submit-button" type="submit" value="Confirm"/>
    </form>
</div>
<p style="color: red; text-align: center">${error_orderNull}<br/></p>
<p style="color: red; text-align: center">${error_cruiseClientNull}<br/></p>
<hr/>
<c:import url="/WEB-INF/jsp/parts/footer.jsp" charEncoding="utf-8"/>
</body>
</html>

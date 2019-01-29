<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 25.01.2019
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ConfirmedOrder</title>
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
    <h1>Your order info</h1>
</div>
<%--@elvariable id="submitOrder" type="Beans.Order"--%>
<div>
    <table width="500" align="center" cellpadding="20">
        <tr>
            <td><h2 style="text-align: left">Total price of Cruise:</h2></td>
            <td><h2 style="text-align: right" padding="200">
                <fmt:setLocale value="en_US"/>
                <fmt:formatNumber value="${submitOrder.totalPrice}" type="currency"/></h2></td>
        </tr>
        <tr>
            <td><h2 style="text-align: left">Your ticket № is:</h2></td>
            <td><h2 style="text-align: right" padding="200">
                ${submitOrder.id} </h2></td>
        </tr>
    </table>
</div>

<%--@elvariable id="bonusList" type="Beans.Bonus"--%>
<c:if test="${not empty bonusList}">
    <h1>And for your ticket status &quot;Premium&quot; Administrator of the ship Gives you a bonuses</h1>
    <div>
        <table width="500" align="center">
            <c:forEach var="elem" items="${bonusList}">
                <tr>
                    <td><p>The name of bonuses:</p></td>
                </tr>
                <tr>
                    <td><p><c:out value=" ${elem.bonusName}"/></p></td>
                </tr>
                <br>
            </c:forEach>
        </table>
    </div>
</c:if>

<hr/>
<c:import url="/WEB-INF/jsp/parts/footer.jsp" charEncoding="utf-8"/>
</body>
</html>

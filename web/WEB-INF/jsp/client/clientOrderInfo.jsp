<%--@elvariable id="viewedCruiseShip" type="Beans.Ship"--%>
<%--@elvariable id="viewedCruise" type="Beans.Cruise"--%>
<%--@elvariable id="viewedCruiseBonus" type="Beans.Bonus"--%>
<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 25.01.2019
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Client order info</title>
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
    <h1>Your profile info</h1>
</div>
<div>
    <table width="500" align="center" cellpadding="10">
        <tr>
            <td>
                <p>Your ship: &quot;${viewedCruiseShip.shipName}&quot;</p>
            </td>
        </tr>
        <tr>
            <td>
                <p> Class of room: ${viewedCruise.cruiseClass}</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>Date of departure:
                    <fmt:setLocale value="en_US"/>
                    <fmt:formatDate value="${viewedCruise.date}" type="date" timeStyle="long"/></p>
            </td>
        </tr>
        <tr>
            <td>
                <p>Duration of cruise: ${viewedCruiseShip.tourDuration} days</p>
            </td>
        </tr>
                <c:if test="${ not empty viewedCruiseBonus}">
            <tr>
                <td>
                    <p>Bonuses: ${viewedCruiseBonus}</p>
                </td>
            </tr>
        </c:if>
    </table>
</div>
<div>
    <form name="orderForm" method="POST" action="controller">
        <input type="hidden" name="command" value="myOrder"/>
        <input class="form-submit-button" type="submit" value="Back to my orders"/>
    </form>
</div>
<hr/>
<c:import url="/WEB-INF/jsp/parts/footer.jsp" charEncoding="utf-8"/>
</body>
</html>

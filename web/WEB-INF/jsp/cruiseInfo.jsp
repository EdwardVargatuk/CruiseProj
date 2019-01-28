<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 15.01.2019
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cruise info</title>
    <style>
        <%@include file="/WEB-INF/css/logStyle.css" %>
        <%@include file="/WEB-INF/css/style9.css" %>
        p {
            border-color: #008a77;
            border-style: solid;
            padding: 5px;
        }
    </style>

</head>
<body>
<c:import url="/WEB-INF/jsp/header.jsp" charEncoding="utf-8"/>
<c:import url="/WEB-INF/jsp/menu.jsp" charEncoding="utf-8"/>


<%--<c:out value="ship" />--%>
<br>
<br/>
<hr/>
<br>

<%--<input type="hidden" name="shipId" value="1"/>--%>
<%--<img src='<c:url value="/sourse/siljaLine.jpg">а</c:url>' width="450" height="400" alt="SILJA LINE"/>--%>
<%--<br>--%>
<%--<p style="text-align: center"><input class="btn-link" type="submit" value="More info about &quot;Silja Line&quot;"/></p>--%>
<%--<a href="${pageContext.request.contextPath}/home"> <p style="text-align: center"> More info about "Silja Line"<p/>--%>
<%--</a>--%>

<div>
    <h1>Ship info:</h1>
</div>
<table align="center" cellpadding="20">

    <tr>
        <td><p style="text-align: left">Ship name: </p></td>
        <td><p style="text-align: left"> &quot;${ship.shipName}&quot;</p></td>
    </tr>
    <tr>
        <td><p style="text-align: left">Tour duration: </p></td>
        <td><p style="text-align: left"> ${ship.tourDuration} days</p></td>
    </tr>
    <tr>
        <td><p style="text-align: left">Count of ports: </p></td>
        <td><p style="text-align: left"> ${ship.countOfPorts} beautiful ports </p></td>
    </tr>
    <tr>
        <td><p style="text-align: left">The trip route: </p></td>
        <td><p style="text-align: left"> ${shipRoute}</p></td>
        <%--<td><p style="text-align: left"> ${ship.route}</p></td>--%>
    </tr>
    <tr>
        <td><p style="text-align: left">Passenger capacity: </p></td>
        <td><p style="text-align: left"> ${ship.passengerCapacity} lucky ones</p></td>
    </tr>
    <tr>
        <td><p style="text-align: left">Ship`s staff: </p></td>
        <td><p style="text-align: left"> ${ship.staff} professionals</p></td>
    </tr>
</table>

<%--<p style="text-align: left">Ship name: ${ship.shipName}</p>--%>
<%--${ship.route}--%>
<%--fmt--%>
<div>
    <h1>And especially for you, hot offer of January</h1>
</div>
<div>
    <form name="shipInfoForm1" method="POST" action="controller">
        <input type="hidden" name="command" value="toOrder"/>
        <input type="hidden" name="cruiseId" value="${cruiseUsual.id}"/>
        <div class="form-style-9">
            <ul>
                <h2 style="text-align: left">Ordinary price

                    <fmt:setLocale value="en_US"/>
                    <fmt:formatNumber value="${cruiseUsual.price}" type="currency"/></h2>
                <br/>
                <li>
                    <input type="submit" value="Take order"/>
                </li>
            </ul>
        </div>
    </form>
    <form name="shipInfoForm2" method="POST" action="controller">
        <input type="hidden" name="command" value="toOrder"/>
        <input type="hidden" name="cruiseId" value="${cruisePremium.id}"/>
        <div class="form-style-9">
            <%--<tr>--%>
            <%--<td><p style="text-align: left">Cruise price: </p></td>--%>
            <ul>
                <h3 style="text-align: left">Premium price
                    <fmt:setLocale value="en_US"/>
                    <fmt:formatNumber value="${cruisePremium.price}" type="currency"/></h3>
                <%--<h3>${cruisePremium.price} </h3></td>--%>
                <li>
                    <input type="submit" value="Take order"/>
                </li>
            </ul>


        </div>
    </form>

</div>

<h3 style="color: red; text-align: center">${error_cruiseNull}<br/></h3>

<hr/>
<c:import url="/WEB-INF/jsp/footer.jsp" charEncoding="utf-8"/>
</body>
</html>

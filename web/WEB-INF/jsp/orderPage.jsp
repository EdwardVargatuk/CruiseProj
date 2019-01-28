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
    <title>Order page</title>
    <style>
        <%@include file="/WEB-INF/css/logStyle.css" %>
        <%@include file="/WEB-INF/css/style9.css" %>

        /*body {*/
        /*margin: 0; !* Убираем отступы *!*/
        /*}*/

        /*.child {*/

        /*padding: 10%; !* Поля вокруг текста *!*/
        /*margin: 10%; !* Отступы вокруг *!*/
        /*}*/
    </style>
</head>
<body>
<c:import url="/WEB-INF/jsp/header.jsp" charEncoding="utf-8"/>
<c:import url="/WEB-INF/jsp/menu.jsp" charEncoding="utf-8"/>
<br>
<br/>
<hr/>
<br>

<div>
    <h1>Ordering, please select additional excursions</h1>
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
<div>

    <form name="orderForm" method="POST" action="controller">

        <table cellspacing="10" cellpadding="5" align="center">
            <tr>
                <td><p style="text-align: center">Name of port</p></td>
                <td><p style="text-align: center">Name of excursion</p></td>
                <td><p style="text-align: center">Price</p></td>
            </tr>

            <c:forEach var="elem" items="${portExcList}">
                <tr>
                        <%--<p>Name of excursion</p>--%>
                    <td><p><c:out value="   ${ elem.portName }"/></p></td>
                    <td><p><c:out value=" ${ elem.excursionName }"/></p></td>
                    <td><p><c:out value="${ elem.excursionPrice }"/></p></td>
                    <td><input type="checkbox" name="selected" value="${elem.excursionPrice}"/></td>
                        <%--<c:set var = "salary" scope = "session" value = "${ elem.excursionPrice }"/>--%>
                        <%--<c:if  test = "${salary = 2000}">--%>

                </tr>
            </c:forEach>


            <%--<c:forEach var="mapp" items="${excursionList}">--%>
            <%--<tr>--%>
            <%--<p>Name of excursion</p>--%>
            <%--<td><c:out value="${ elem.excursionName }"/></td>--%>

            <%--<td><input type="checkbox" name="choose" value="Y"/></td>--%>
            <%--&lt;%&ndash;<c:set var = "salary" scope = "session" value = "${ elem.excursionPrice }"/>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<c:if  test = "${salary = 2000}">&ndash;%&gt;--%>
            <%--<td><c:out value="${ elem.excursionPrice }"/></td>--%>
            <input type="hidden" name="command" value="updateOrder"/>
            <input type="hidden" name="cruisePrice" value="${cruise.price}"/>
            <input type="hidden" name="cruisePr" value="${cruise}"/>
            <tr>
                <td>

                <%--<li>--%>
                <input class="form-submit-button" type="submit" value="Update price"/>
                <%--</li>--%>
                </td>
            </tr>
            <%--</tr>--%>
            <%--</c:forEach>--%>
            <tr>
                <td>
                    <div align="center">
                        <form name="shipInfoForm1" method="POST" action="controller">
                            <input type="hidden" name="command" value="confirmOrder"/>

                                <input class="form-submit-button" type="submit" value="Confirm without excursion"/>


                        </form>
                    </div>
                </td>
            </tr>

        </table>
    </form>
</div>

<hr/>
<c:import url="/WEB-INF/jsp/footer.jsp" charEncoding="utf-8"/>
</body>
</html>

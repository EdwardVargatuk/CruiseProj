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
    <title>Client info</title>
    <style>
        <%@include file="/WEB-INF/css/logStyle.css" %>
        <%@include file="/WEB-INF/css/style9.css" %>
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
    <h1>Your orders</h1>
</div>
<div>
    <table width="500" align="center" cellpadding="20">

        <tr>
            <td><h2 style="text-align: left">Price of Cruise:</h2></td>
            <td><h2 style="text-align: right" padding="200">
                <fmt:setLocale value="en_US"/>
                <fmt:formatNumber value="${submitOrder.totalPrice}" type="currency"/></h2></td>
            <td>
                My orders: ${loginedUser.orders}
            </td>
            <td>
                My orders: ${loginedUser.orders}
            </td>
        </tr>


    </table>
</div>

<hr/>
<c:import url="/WEB-INF/jsp/footer.jsp" charEncoding="utf-8"/>

</body>
</html>

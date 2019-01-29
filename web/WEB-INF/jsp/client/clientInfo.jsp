<%--@elvariable id="loginedUser" type="Beans.Client"--%>
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
    <table>
        <tr>
            <td>
                <p> My login: ${loginedUser.userName}</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>My password: ${loginedUser.password}</p>
            </td>
        </tr>
    </table>
</div>

<div>
    <fmt:setLocale value="en_US"/>
    <%--@elvariable id="order_list" type="Beans"--%>
    <c:if test="${not empty order_list}">
        <%--@elvariable id="order_list" type="java.util.List"--%>
        <c:forEach var="elem" items="${order_list}">
            <form name="orderForm" method="POST" action="controller">
                <input type="hidden" name="command" value="viewOrderInfo"/>
                <input type="hidden" name="cruise_Id" value="${elem.cruiseId}"/>
                <p><c:out value="The number of ticket: ${elem.id }"/></p>
                <p>
                    <c:out value="Price of order "/>
                    <fmt:formatNumber value="${elem.totalPrice }" type="currency"/>
                </p>
                <input class="form-submit-button" type="submit" value="View more info"/>
            </form>
        </c:forEach>
    </c:if>
</div>

<div>
    <c:if test="${empty order_list}">
        <td><p>You have not made any orders yet</p></td>
    </c:if>
    <br>
</div>

<hr/>
<c:import url="/WEB-INF/jsp/parts/footer.jsp" charEncoding="utf-8"/>
</body>
</html>

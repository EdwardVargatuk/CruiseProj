<%--@elvariable id="orderClientMap" type="java.util.LinkedHashMap"--%>
<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 28.01.2019
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>orders</title>
    <style>
        <%@include file="/WEB-INF/css/logStyle.css" %>
        <%@include file="/WEB-INF/css/style9.css" %>
    </style>
</head>
<body>
<div>
    <c:import url="/WEB-INF/jsp/parts/header.jsp" charEncoding="utf-8"/>
    <c:import url="/WEB-INF/jsp/parts/menu.jsp" charEncoding="utf-8"/>
    <br>
    <br/>
    <hr/>
    <br>
    <div>
        <h1>List of all orders</h1>
    </div>
    <c:if test="${not empty orderClientMap}">
        <c:forEach var="entry" items="${orderClientMap}">
            <form name="editOrderForm" method="POST" action="controller">
                <input type="hidden" name="command" value="editOrder"/>
                <input type="hidden" name="order_Id" value="${entry.key.id}"/>
                <p><c:out value="ID of ticket (order): ${entry.key.id}"/></p>
                <p><c:out value="Price of order: ${entry.key.totalPrice }"/></p>
                <p><c:out value="Client Name: ${entry.value.userName}, and ID: ${entry.value.id}"/></p>
                <p><c:out value="Cruise ID: ${entry.key.cruiseId}"/></p>
                <input class="form-submit-button" type="submit" value="Edit order"/>
            </form>
            <hr>
        </c:forEach>
    </c:if>
    <h3 style="color: red; text-align: center">${orderListNull}<br/></h3>
    <hr/>
    <c:import url="/WEB-INF/jsp/parts/footer.jsp" charEncoding="utf-8"/>
</div>
</body>
</html>

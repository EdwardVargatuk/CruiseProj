<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 28.01.2019
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>clients</title>
    <style>
        <%@include file="/WEB-INF/css/logStyle.css" %>
        <%@include file="/WEB-INF/css/style9.css" %>
    </style>
</head>
<body>
<div>

    <c:import url="/WEB-INF/jsp/header.jsp" charEncoding="utf-8"/>
    <c:import url="/WEB-INF/jsp/menu.jsp" charEncoding="utf-8"/>
    <br>
    <br/>
    <hr/>
    <br>
    <div>
        <h1>List of all registered clients</h1>
    </div>


    <c:if test="${not empty clientList}">

        <c:forEach var="elem" items="${clientList}">
            <%--<form name="orderForm" method="POST" action="controller">--%>
            <%--<input type="hidden" name="command" value="viewOrderInfo"/>--%>
            <%--<input type="hidden" name="cruise_Id" value="${elem.cruiseId}"/>--%>

            <p><c:out value="Id of client: ${elem.id }"/></p>

            <p><c:out value="Name of client ${elem.userName }"/></p>
            <p><c:out value="Password of client ${elem.password }"/></p>
            <p><c:out value="Role of client ${elem.role }"/></p>
            <p><c:out value="Orders ${elem.orders }"/></p>


        </c:forEach>
    </c:if>

</div>
</body>
</html>

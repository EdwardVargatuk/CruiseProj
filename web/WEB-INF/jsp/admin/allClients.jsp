<%--@elvariable id="clientListWithNumOrders" type="java.util.LinkedHashMap"--%>
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

    <c:import url="/WEB-INF/jsp/parts/header.jsp" charEncoding="utf-8"/>
    <c:import url="/WEB-INF/jsp/parts/menu.jsp" charEncoding="utf-8"/>
    <br>
    <br/>
    <hr/>
    <br>
    <div>
        <h1>List of all registered clients</h1>
    </div>
    <c:if test="${not empty clientListWithNumOrders}">
        <c:forEach var="entry" items="${clientListWithNumOrders}">
            <p><c:out value="Id of client: ${entry.key.id}"/></p>
            <p><c:out value="Name of client: ${entry.key.userName }"/></p>
            <p><c:out value="Password of client: ${entry.key.password }"/></p>
            <p><c:out value="Permisions of client: ${entry.key.role }"/></p>
            <p><c:out value="Count of Orders: ${entry.value}"/></p>
            <hr>
        </c:forEach>
    </c:if>
    <hr/>
    <c:import url="/WEB-INF/jsp/parts/footer.jsp" charEncoding="utf-8"/>
</div>
</body>
</html>

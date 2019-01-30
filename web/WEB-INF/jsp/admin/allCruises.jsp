<%--@elvariable id="cruiseShipMap" type="java.util.LinkedHashMap"--%>
<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 28.01.2019
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cruises</title>
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
        <h1>List of all available cruise</h1>
    </div>
    <c:if test="${not empty cruiseShipMap}">
        <c:forEach var="entry" items="${cruiseShipMap}">
            <p><c:out value="Id of cruise: ${entry.key.id}"/></p>
            <p><c:out value="Class of cruise: ${entry.key.cruiseClass }"/></p>
            <p><c:out value="Price of cruise: ${entry.key.price }"/></p>
            <p><c:out value="Date of departure: ${entry.key.date}"/></p>
            <p><c:out value="The ship: &quot;${entry.value.shipName}&quot;"/></p>
            <hr>
        </c:forEach>
    </c:if>
    <hr/>
    <c:import url="/WEB-INF/jsp/parts/footer.jsp" charEncoding="utf-8"/>
</div>
</body>
</html>

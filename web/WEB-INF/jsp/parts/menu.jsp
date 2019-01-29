<%--@elvariable id="loginedUser" type="Beans.Client"--%>
<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 08.01.2019
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${loginedUser.role eq 'OWNER'}">
        <div style="padding: 5px;text-align: left;">
            <a href="controller?command=home">Home</a>
            |
            <a href="controller?command=allClients">All Clients</a>
            |
            <a href="controller?command=allOrders">All Orders</a>
            |
            <a href="controller?command=allCruises">All Cruises</a>
        </div>
    </c:when>
    <c:when test="${loginedUser.role eq 'CLIENT'}">
        <div style="padding: 5px;text-align: left;">
            <a href="controller?command=home">Home</a>
            |
            <a href="controller?command=myOrder">My Account Info</a>
            |
            <a href="${pageContext.request.contextPath}/index.jsp">Login</a>
        </div>
    </c:when>
</c:choose>

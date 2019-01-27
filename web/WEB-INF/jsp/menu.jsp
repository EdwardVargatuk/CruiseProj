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

<div style="padding: 5px;text-align: left;">

    <a href="controller?command=home">Home</a>
    |
    <a href="controller?command=myOrder">My Account Info</a>
    |
    <a href="${pageContext.request.contextPath}/index.jsp">Login</a>

</div>
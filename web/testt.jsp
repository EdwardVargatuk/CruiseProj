<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 28.12.2018
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><body>
<c:set var="user" value="guest" scope="page"/>
<c:if test="${ not empty user and user eq 'guest' }">
    User is Guest
</c:if>
<br/>
</body></html>

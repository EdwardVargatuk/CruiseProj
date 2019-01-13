<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 03.01.2019
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Welcome</title>

    <style>
        <%@include file="/css/logStyle.css" %>
    </style>
</head>
<body>
<h2 align="center">Welcome</h2>

<hr/>
${user}, hello!
<hr/>
<img src='<c:url value="/css/siljaLine.jpg">а</c:url>' width="450" height="400"  alt="SILJA LINE"/>
<img src='<c:url value="/css/tallink.jpg">а</c:url>' width="450" height="400"  />
<img src='<c:url value="/css/ляляРатушна.jpg">а</c:url>' width="450" height="400"  />
<%--<input type="hidden" method="POST" action="controler" name="command" value="logout"/>--%>
<a href="controller?command=logout">Logout</a>
</body>
</html>

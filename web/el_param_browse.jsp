<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 28.12.2018
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>EL for parameter</title></head>
<body>The firstname is ${ param.firstname }<br/>
e-mail 1 is ${ param.mail }<br/>
e-mail 1 is ${ paramValues.mail[0] }<br/>
e-mail 2 is ${ paramValues.mail[1] }
</body></html>
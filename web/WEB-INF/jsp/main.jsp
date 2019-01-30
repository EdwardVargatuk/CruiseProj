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
<head><title>Main page</title>
    <style>
        <%@include file="/WEB-INF/css/logStyle.css" %>
        <%@include file="/WEB-INF/css/sh.css" %>
    </style>
</head>
<body>
<c:import url="/WEB-INF/jsp/parts/header.jsp" charEncoding="utf-8"/>
<c:import url="/WEB-INF/jsp/parts/menu.jsp" charEncoding="utf-8"/>
<br>
<br/>
<hr/>
<br>
<div class="conteiner">
    <div>
        <form name="viewForm" method="POST" action="controller">
            <input type="hidden" name="command" value="tourInfo"/>
            <input type="hidden" name="shipId" value="1"/>
            <img src='<c:url value="/sourse/siljaLine.jpg">а</c:url>' width="420" height="380" alt="SILJA LINE"/>
            <br>
            <p style="text-align: center"><input class="btn-link" type="submit"
                                                 value="More info about &quot;Silja Line&quot;"/></p>
        </form>
    </div>
    <div>
        <form name="viewForm" method="POST" action="controller">
            <input type="hidden" name="command" value="tourInfo"/>
            <input type="hidden" name="shipId" value="2"/>
            <img src='<c:url value="/sourse/tallink.jpg">а</c:url>' width="420" height="380" alt="TALLINK"/>
            <br>
            <p style="text-align: center"><input class="btn-link" type="submit"
                                                 value="More info about &quot;Tallink&quot;"/></p>
        </form>
    </div>
    <div>
        <form name="viewForm" method="POST" action="controller">
            <input type="hidden" name="command" value="tourInfo"/>
            <input type="hidden" name="shipId" value="3"/>
            <img src='<c:url value="/sourse/ляляРатушна.jpg">а</c:url>' width="420" height="380" alt=""/>
            <br>
            <p style="text-align: center"><input class="btn-link" type="submit"
                                                 value="More info about &quot;Ляля Ратушна&quot;"/></p>
        </form>
    </div>

    <p style="color: red; text-align: center">${error_ship_info}<br/></p>
</div>
<br>

<hr/>
<c:import url="/WEB-INF/jsp/parts/footer.jsp" charEncoding="utf-8"/>
</body>
</html>

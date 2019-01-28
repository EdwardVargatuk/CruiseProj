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

<c:import url="/WEB-INF/jsp/header.jsp" charEncoding="utf-8"/>
<c:import url="/WEB-INF/jsp/menu.jsp" charEncoding="utf-8"/>
<br>
<br/>
<hr/>
<br>
<div class="conteiner">
    <div>
        <form name="viewForm" method="POST" action="controller">
            <input type="hidden" name="command" value="tourInfo"/>
            <input type="hidden" name="shipId" value="1"/>
            <img src='<c:url value="/sourse/siljaLine.jpg">а</c:url>' width="450" height="400" alt="SILJA LINE"/>
            <br>
            <p style="text-align: center"><input class="btn-link" type="submit"
                                                 value="More info about &quot;Silja Line&quot;"/></p>
        </form>
    </div>
    <%--<div>--%>
    <%--<img src='<c:url value="/sourse/siljaLine.jpg">а</c:url>' width="450" height="400" alt="SILJA LINE"/>--%>
    <%--<br>--%>
    <%--<a href="${pageContext.request.contextPath}/home"> <p style="text-align: center"> More info about "Silja Line"<p/>--%>
    <%--</a>--%>
    <%--</div>--%>
    <div>
        <form name="viewForm" method="POST" action="controller">
            <input type="hidden" name="command" value="tourInfo"/>
            <input type="hidden" name="shipId" value="2"/>
            <img src='<c:url value="/sourse/tallink.jpg">а</c:url>' width="450" height="400" alt="TALLINK"/>
            <br>
            <p style="text-align: center"><input class="btn-link" type="submit"
                                                 value="More info about &quot;Tallink&quot;"/></p>
            <%--<a href="${pageContext.request.contextPath}/home"><p style="text-align: center"> More info about "Tallink"<p/>--%>
            <%--</a>--%>
        </form>
    </div>
    <div>
        <form name="viewForm" method="POST" action="controller">
            <input type="hidden" name="command" value="tourInfo"/>
            <input type="hidden" name="shipId" value="3"/>
            <img src='<c:url value="/sourse/ляляРатушна.jpg">а</c:url>' width="450" height="400" alt=""/>
            <br>
            <p style="text-align: center"><input class="btn-link" type="submit"
                                                 value="More info about &quot;Ляля Ратушна&quot;"/></p>
            <%--<a href="${pageContext.request.contextPath}/home"> <p style="text-align: center"> More info about "Silja Line"<p/>--%>
            <%--</a>--%>
        </form>
    </div>

    <p style="color: red; text-align: center">${error_ship_info}<br/></p>
</div>
<br>

<%--<div class="conteiner">--%>

<%--</div>--%>

<%--<img src='<c:url value="/sourse/ляляРатушна.jpg">а</c:url>' width="450" height="400"/>--%>

<%--<a href="${pageContext.request.contextPath}/home">more info about Tallink</a>--%>
<%--<input type="hidden" method="POST" action="controler" name="command" value="logout"/>--%>


<%--<a href="controller?command=logout">Logout</a>--%>
<hr/>
<c:import url="/WEB-INF/jsp/footer.jsp" charEncoding="utf-8"/>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 03.01.2019
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Error Page</title></head>
<body>

Status code: ${pageContext.errorData.statusCode} Take our apologies
<br/>
<c:if test="${not empty errorMessage}">
    <p>
        <c:out value="${errorMessage}"/>
    </p>
</c:if>

<p>Back to <a href="controller?command=home">Home</a></p>
</body>
</html>

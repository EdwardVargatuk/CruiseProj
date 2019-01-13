<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 08.01.2019
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
    <div style="text-align: center;">
        <h1>Cruise of your dream</h1>
    </div>

    <div style="float: right;  padding: 10px; text-align: right;">

        <!-- User store in session with attribute: loginedUser -->
        Hello <b>${loginedUser.userName}</b>
        <br/>
        Search <input name="search">

    </div>

</div>

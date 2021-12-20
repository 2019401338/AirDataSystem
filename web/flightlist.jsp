<%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/12/19
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>近期航班执行率分析</title>
    <link href="css/liststrap.css" rel="stylesheet">
    <style>
        #login ,#count{
            float: right;
        }
    </style>
</head>
<body>
<center>
    <div id="login">欢迎${sessionScope.user.username}登录 </div>
    <div id="count">当前共有${applicationScope.count}人在线</div>
    <h1>航班执行率分析</h1>
    <table width="80%" height="70%">
        <tr>
            <td>日期</td>
            <td>取消航班</td>
            <td>执行航班</td>
            <td>计划总数</td>
            <td>执行率</td>
        </tr>
        <c:if test="${requestScope.flightlist!=null}">
            <c:if test="${requestScope.flightlist ne null and requestScope.flightlist.size() gt 0}">

                <c:forEach var="f" items="${requestScope.flightlist}">
                    <tr>

                        <td>${f.date}</td>
                        <td>${f.useNum}</td>
                        <td>${f.cancelNum}</td>
                        <td>${f.allNum}</td>
                        <td>${f.useRate}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </c:if>
    </table>
</center>
</body>
</html>

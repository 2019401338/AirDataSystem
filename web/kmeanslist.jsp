<%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/12/19
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户信息分类表</title>
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
    <h1>客户信息分类分析（表里的数据是经过标准化后的）</h1>
    <table width="90%" height="80%">
        <tr>
            <td>聚类类别</td>
            <td>客户关系长度L</td>
            <td>消费时间间隔R</td>
            <td>飞行里程M</td>
            <td>消费频率F</td>
            <td>折扣系数的平均值C</td>
            <td>聚类个数</td>
            <td>客户等级</td>
        </tr>
        <c:if test="${requestScope.kmeanslist!=null}">
            <c:if test="${requestScope.kmeanslist ne null and requestScope.kmeanslist.size() gt 0}">

                <c:forEach var="k" items="${requestScope.kmeanslist}">
                    <tr>

                        <td>${k.category}</td>
                        <td>${k.l}</td>
                        <td>${k.r}</td>
                        <td>${k.m}</td>
                        <td>${k.f}</td>
                        <td>${k.c}</td>
                        <td>${k.number}</td>
                        <td>${k.level}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </c:if>
    </table>
</center>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/6/28
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color: #9acfea;
        }
        a{
            color: dodgerblue;
            text-decoration: none;
        }
        #logo{
            background-image: url("img/飞机logo.jpg");
            height: 70px;
            background-size: cover;
            background-position: center;
        }
    </style>
</head>
<body>
<div id="logo"></div>
<h2><a href="main.jsp" target="main" id="">首页</a></h2>
<%--<dl>--%>
<%--    <dt>--%>
<%--        员工信息表--%>
<%--    </dt>--%>
<%--    <dd>--%>
<%--        <a href="oremlistpage" target="main">员工列表</a>--%>
<%--    </dd>--%>
<%--</dl>--%>
<%--<dl>--%>
<%--    <dt>--%>
<%--        工资信息表--%>
<%--    </dt>--%>
<%--    <dd>--%>
<%--        <a href="orwalistpage" target="main">工资列表</a>--%>
<%--    </dd>--%>
<%--</dl>--%>
<%--<dl>--%>
<%--    <dt>--%>
<%--        统计图--%>
<%--    </dt>--%>
<%--    <dd>--%>
<%--        <a href="count" target="main">部门人数统计</a>--%>
<%--    </dd>--%>
<%--</dl>--%>
<dl>
    <dt>
        系统管理
    </dt>
    <dd>
        <a href="ulistpage" target="main">用户密码管理</a>
    </dd>
    <dd>
        <a href="logout" target="_parent">退出系统</a>
    </dd>
</dl>
</body>
</html>

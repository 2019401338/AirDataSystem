<%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/12/19
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户分析图表</title>
    <link href="css/liststrap.css" rel="stylesheet">
    <style>
        #login ,#count{
            float: right;
        }
        #img1{
            float: left;
            padding-left: 70px;
            padding-top: 20px;
            width: 40%;
            height: 60%;
        }
        #img2{
            float: right;
            padding-right: 50px;
            width: 40%;
            height: 60%;
        }
    </style>
</head>
<body>
<center>
    <h1>客户分析图表</h1>
    <div id="login">欢迎${sessionScope.user.username}登录 </div>
    <div id="count">当前共有${applicationScope.count}人在线</div>
<%--    <div style="width: 600px;height:400px;">--%>
        <img src="img/客户群特征分析图.png"  id="img1">
<%--    </div>--%>
<%--    <div>--%>
        <img src="img/各类客户的人数条形图.png" id="img2">
<%--    </div>--%>

</center>
</body>
</html>

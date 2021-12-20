<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <style>
        body{
            background-image: url("img/天空背景图.jpeg");
            background-repeat: no-repeat;
            background-size: 100%,100%;
            position: absolute;
        }
        #welcome{
            font-weight: bold;
            font-size: 50px;
            margin: 100px 100px 200px 100px;
            padding-top: 150px;
            background-size: cover;
            color: orange;
        }
    </style>
</head>
<body>
    欢迎${sessionScope.user.username}登录
    当前共有${applicationScope.count}人在线
    <div id="welcome">欢迎进入航空数据分析平台！</div>
</body>
</html>

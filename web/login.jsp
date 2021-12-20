<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/6/22
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>登录页面</title>
    <style>
        body{
            margin:0;
            padding: 0;
            background-image: url("img/天空背景图.jpeg");
            background-repeat: no-repeat;
            background-size:cover ;
        }

        #bigBox{
            margin:0 auto;
            margin-top:200px;
            padding:20px 50px;
            background-color:#000000;
            opacity:0.7;
            width:400px;
            height:300px;
            border-radius: 10px;
            text-align: center;
        }

        #bigBox h1
        {
            color:white;
        }

        #bigBox .inputBox
        {
            margin-top:50px;
        }

        #bigBox .inputBox .inputText
        {
            margin-top:20px;

        }

        #bigBox .inputBox .inputText input
        {
            background-color: #000000;
            background-color: black;
            border:0;
            width:250px;
            padding:10px 10px;
            border-bottom:1px solid white;
            color:#ffffff;
        }

        #bigBox .inputBox .inputButton
        {
            border:0;
            margin-top:15px;
            width:120px;
            height:30px;
            color:#ffffff;
            border-radius: 20px;
            background: linear-gradient(to bottom, rgba(255,255,255,0.15) 0%, rgba(0,0,0,0.15) 100%), radial-gradient(at top center, rgba(255,255,255,0.40) 0%, rgba(0,0,0,0.40) 120%) #989898;
            background-blend-mode: multiply,multiply;
        }
    </style>
</head>
<script src="js/jquery-1.8.3.js"></script>
<body>
<div id="bigBox" class="site-doc-icon site-doc-anim">
    <h1>登录</h1>
    <div class="inputBox">
        <form action="login" method="post">
            <div class="inputText">
                <input type="text" placeholder="请输入用户名/员工码" name="username" />
            </div>
            <div class="inputText">
                <input type="password" placeholder="请输入密码" name="password" id="password" onblur="checkPassword()"/>
            </div>
            <div><span style="color: red"> ${requestScope.wrongText}</span></div>
            <div> <span style="color: red">${requestScope.error}</span> </div>
            <button type="submit" class="inputButton"  >登录</button>
            <button type="button" class="inputButton" onclick="jumpRe()">注册</button>
        </form>
    </div>
</div>

<script type="text/javascript">

    //写了函数，点击注册按钮就跳转到注册页面
    function jumpRe(){
        window.location.href="register.html";
    }
</script>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单</title>
    <style>
        body{
            background-color: #9acfea;
        }
        #bigBox{
            margin:0 auto;
            margin-top:20px;
            background-color: gainsboro;
            opacity:0.8;
            border-radius: 10px;
            /*text-align: center;*/
        }
        form{
            width:170px;
            height:600px;
            margin-top: 1em;
            text-align: left;
        }
        dd{
            height: 30px;
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
        /*#bigBox h2{*/
        /*    */
        /*}*/
    </style>
</head>
<body>
<div id="logo"></div>
<div id="bigBox">
    <form>
        <h2><a href="main.jsp" target="main">首页</a></h2>
        <dl>
            <dt>
                航空信息分析
            </dt>
            <dd>
                <a href="airportlist" target="main">机场基本信息表</a>
            </dd>
            <dd>
                <a href="airlinelist" target="main">航班量统计图表</a>
            </dd>
            <dd>
                <a href="flighttable" target="main">航班执行率</a>
            </dd>
        </dl>
        <dl>
            <dt>
                客户信息分析
            </dt>
            <dd>
                <a href="customerlist" target="main">客户重要信息列表</a>
            </dd>
            <dd>
                <a href="kmeanslist" target="main">客户分类表</a>
            </dd>
            <dd>
                <a href="customertable.jsp" target="main">客户信息分类图表</a>
            </dd>
        </dl>
        <dl>
            <dt>
                飞机信息
            </dt>
            <dd>
                <a href="aircraftlist" target="main">飞机信息图表</a>
            </dd>
        </dl>
        <dl>
            <dt>
                安全模块
            </dt>
            <%--        <dd>--%>
            <%--        <a href="http://192.168.0.137:8081/" target="main">实时监控</a>--%>
            <%--        </dd>--%>
            <%--        <dd>--%>
            <%--            <a href="initImg" target="main">图片</a>--%>
            <%--        </dd>--%>
            <dd>
                <a href="photocount" target="main">客户人脸匹配</a>
            </dd>

        </dl>
        <dl>
            <dt>
                系统管理
            </dt>
            <dd>
                <a href="logout" target="_parent">退出系统</a>
            </dd>
        </dl>
    </form>

</div>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/12/19
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户信息</title>
    <link href="css/liststrap.css" rel="stylesheet">
    <style>
        #login ,#count{
            float: right;
        }
    </style>
</head>
<body>
<center>
    <h1>客户信息</h1>
    <div id="login">欢迎${sessionScope.user.username}登录 </div>
    <div id="count">当前共有${applicationScope.count}人在线</div>
    <table width="100%" height="70%"style="padding-left: 50px;">
        <tr>

            <td>ID</td>
            <td>第一次飞行时间</td>
            <td>性别</td>
            <td>会员级别</td>
            <td>工作城市</td>
            <td>年龄</td>
            <td>飞行次数</td>
            <td>总飞行公里</td>
            <td>平均乘机间隔</td>
            <td>平均折扣率</td>
            <td>总累计积分</td>
            <td>人脸</td>
        </tr>
        <c:if test="${requestScope.page!=null}">
            <c:if test="${requestScope.page.list ne null and requestScope.page.list.size() gt 0}">

                <c:forEach var="c" items="${requestScope.page.list}">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.firstDate}</td>
                        <td>${c.sex}</td>
                        <td>${c.ffp_tier}</td>
                        <td>${c.workCity}</td>
                        <td>${c.age}</td>
                        <td>${c.flightCount}</td>
                        <td>${c.segKmSum}</td>
                        <td>${c.avgInterval}</td>
                        <td>${c.avgDiscount}</td>
                        <td>${c.pointsSum}</td>
                        <td><img src="${c.image}" height="40px" width="40px"/></td>
                    </tr>
                </c:forEach>
            </c:if>

        </c:if>



        <tr>
            <td colspan="7">
                <input type="button" value="首页" onclick="toFirst()" style="background-color: dodgerblue;border-color: deepskyblue">
                <input type="button" value="上一页" onclick="toPrev()" style="background-color: dodgerblue;border-color: deepskyblue">
                当前页 ${requestScope.page.currentPageNum}| ${requestScope.page.totalPageNum} 总页数
                <input type="button" value="下一页" onclick="toNext()" style="background-color: dodgerblue;border-color: deepskyblue">
                <input type="button" value="末页" onclick="toLast()" style="background-color: dodgerblue;border-color: deepskyblue">
            </td>
        </tr>
    </table>
</center>
</body>
<script>
    var currentPage=${requestScope.page.currentPageNum};
    var totalPage=${requestScope.page.totalPageNum};
    // var condition = $('#num').val();


    function toFirst() {
        location.href="customerlist?currentPage=1";
    }
    function toPrev() {
        //控制页面显示风格
        var url="";
        if(currentPage==1){
            url="customerlist?currentPage=1";
        }else{
            url="customerlist?currentPage="+(currentPage-1);
        }
        location.href=url;

    }
    function toNext() {
        //控制页面显示风格
        var url="";
        if(currentPage==totalPage){
            url="customerlist?currentPage="+totalPage;
        }else{
            url="customerlist?currentPage="+(currentPage+1);
        }
        location.href=url;
    }
    function toLast() {
        location.href="customerlist?currentPage="+totalPage;
    }
</script>
</html>

<%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/12/18
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>机场信息展示</title>
    <link href="css/liststrap.css" rel="stylesheet">
    <style>
        #login ,#count{
            float: right;
        }
    </style>
</head>
<body>
<center>
    <h1>机场信息展示</h1>
    <div id="login">欢迎${sessionScope.user.username}登录 </div>
    <div id="count">当前共有${applicationScope.count}人在线</div>
<%--    <div class="search">--%>
<%--        <form action="airportlist" method="post">--%>
<%--            <input type="text" name="airport_Cname" placeholder="机场中文名搜索" value="${requestScope.c}" id="num">--%>
<%--            <input class="fa fa-search" type="submit" value="搜索" id="search">--%>
<%--        </form>--%>
<%--    </div>--%>
    <table width="100%" height="70%" style="padding-left: 100px;">
        <tr>
            <td>机场中文名</td>
            <td>机场英文名</td>
            <td>城市中文名</td>
            <td>城市英文名</td>
            <td>城市三字码</td>
            <td>IATA码</td>
            <td>ICAO码</td>
            <td>国家/地区</td>
        </tr>
        <c:if test="${requestScope.page!=null}">
            <c:if test="${requestScope.page.list ne null and requestScope.page.list.size() gt 0}">
                <c:forEach var="u" items="${requestScope.page.list}">
                    <tr>
                        <td>${u.airport_Cname}</td>
                        <td>${u.airport_Ename}</td>
                        <td>${u.airport_city}</td>
                        <td>${u.airport_Ecity}</td>
                        <td>${u.city_three_code}</td>
                        <td>${u.IATA_code}</td>
                        <td>${u.ICAO_code}</td>
                        <td>${u.country}</td>
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
        location.href="airportlist?currentPage=1";
    }
    function toPrev() {
        //控制页面显示风格
        var url="";
        if(currentPage==1){
            url="airportlist?currentPage=1";
        }else{
            url="airportlist?currentPage="+(currentPage-1);
        }
        location.href=url;

    }
    function toNext() {
        //控制页面显示风格
        var url="";
        if(currentPage==totalPage){
            url="airportlist?currentPage="+totalPage;
        }else{
            url="airportlist?currentPage="+(currentPage+1);
        }
        location.href=url;
    }
    function toLast() {
        location.href="airportlist?currentPage="+totalPage;
    }
</script>
</html>

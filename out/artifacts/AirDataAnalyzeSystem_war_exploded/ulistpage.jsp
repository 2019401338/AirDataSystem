<%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/6/29
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理用户密码</title>
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/liststrap.css" rel="stylesheet">
    <style>
        #login ,#count{
            float: right;
        }
    </style>
</head>
<body>
<center>
    <h1>用户密码管理</h1>
    <div id="login">欢迎${sessionScope.user.username}登录 </div>
    <div id="count">当前共有${applicationScope.count}人在线</div>
    <div class="search">
        <form action="ulistpage" method="post">
            <input type="text" name="username" placeholder="用户名搜索" value="${requestScope.c}" id="num">
            <input class="fa fa-search" type="submit" value="搜索" id="search">
        </form>
    </div>
    <table width="100%" height="70%" style="padding-left: 70px;">
        <tr>
            <td>Id</td>
            <td>用户名</td>
            <td>密码</td>
            <td>身份</td>
        </tr>
        <c:if test="${requestScope.page!=null}">
            <c:if test="${requestScope.page.list ne null and requestScope.page.list.size() gt 0}">

                <c:forEach var="u" items="${requestScope.page.list}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.username}</td>
                        <td>${u.password}</td>
                        <td>${u.position}</td>
                        <td>
                            <a class="fa fa-edit" href="uload?username=${u.username}" style="color:deepskyblue;"></a>
                            <a class="fa fa-trash" href="udelete?username=${u.username}" style="color:deepskyblue;"></a>
                        </td>
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
    var condition = $('#num').val();


    function toFirst() {
        location.href="ulistpage?currentPage=1"+"&username="+condition;
    }
    function toPrev() {
        //控制页面显示风格
        var url="";
        if(currentPage==1){
            url="ulistpage?currentPage=1"+"&username="+condition;
        }else{
            url="ulistpage?currentPage="+(currentPage-1)+"&username="+condition;
        }
        location.href=url;

    }
    function toNext() {
        //控制页面显示风格
        var url="";
        if(currentPage==totalPage){
            url="ulistpage?currentPage="+totalPage+"&username="+condition;
        }else{
            url="ulistpage?currentPage="+(currentPage+1)+"&username="+condition;
        }
        location.href=url;
    }
    function toLast() {
        location.href="ulistpage?currentPage="+totalPage+"&username="+condition;
    }
</script>
</html>

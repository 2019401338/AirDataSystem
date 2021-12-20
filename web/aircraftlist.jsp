<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/12/17
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>飞机信息统计</title>
    <link href="css/liststrap.css" rel="stylesheet">
    <style>
        #main{
            width: 50%;
            float: left;
        }
        #form{
            width: 50%;
            float: left;
        }
        /*#table{*/
        /*    padding-left: 50px;*/
        /*    padding-top: 20px;*/
        /*    table-layout: fixed;*/
        /*    width: 300px;*/
        /*    overflow: hidden;*/
        /*}*/
    </style>
</head>
<script src="https://cdn.bootcdn.net/ajax/libs/echarts/5.1.2/echarts.min.js"></script>
<body>
<h1>飞机类型数量分析图</h1>
<div id="main" style="width: 600px;height:400px;"></div>
<div id="form">
    <table id="table" style="border-collapse: separate;border-spacing: 10px">
        <tr>
            <th>飞机属性</th>
            <th>数量</th>
        </tr>
        <c:if test="${requestScope.page!=null}">
            <c:if test="${requestScope.page.list ne null and requestScope.page.list.size() gt 0}">
                <c:forEach var="l" items="${requestScope.page.list}">
                    <tr>
                        <th>${l.name}</th>
                        <th>${l.value}</th>
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
</div>
<script>
    var currentPage=${requestScope.page.currentPageNum};
    var totalPage=${requestScope.page.totalPageNum};
    // var condition = $('#num').val();


    function toFirst() {
        location.href="aircraftlist?currentPage=1";
    }
    function toPrev() {
        //控制页面显示风格
        var url="";
        if(currentPage==1){
            url="aircraftlist?currentPage=1";
        }else{
            url="aircraftlist?currentPage="+(currentPage-1);
        }
        location.href=url;

    }
    function toNext() {
        //控制页面显示风格
        var url="";
        if(currentPage==totalPage){
            url="aircraftlist?currentPage="+totalPage;
        }else{
            url="aircraftlist?currentPage="+(currentPage+1);
        }
        location.href=url;
    }
    function toLast() {
        location.href="aircraftlist?currentPage="+totalPage;
    }
</script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    myChart.setOption({
        series : [
            {
                name: '访问来源',
                type: 'pie',    // 设置图表类型为饼图
                radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                data: ${tulist}

            }
        ]
    })
</script>
</body>
</html>

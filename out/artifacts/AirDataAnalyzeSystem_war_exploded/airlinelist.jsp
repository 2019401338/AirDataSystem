<%--
  Created by IntelliJ IDEA.
  User: qingcheng
  Date: 2021/12/18
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>航公航班量统计图表</title>
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

    </style>
</head>
<script src="https://cdn.bootcdn.net/ajax/libs/echarts/5.1.2/echarts.min.js"></script>
<body>
<h1>航公航班量分析图</h1>
<div id="main" style="width: 600px;height:400px;"></div>
<div id="form">
    <table id="table"  width="100%" height="70%"style="padding-left: 150px;">
        <tr>
            <th>航空公司</th>
            <th>航班量/年</th>
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
        location.href="airlinelist?currentPage=1";
    }
    function toPrev() {
        //控制页面显示风格
        var url="";
        if(currentPage==1){
            url="airlinelist?currentPage=1";
        }else{
            url="airlinelist?currentPage="+(currentPage-1);
        }
        location.href=url;

    }
    function toNext() {
        //控制页面显示风格
        var url="";
        if(currentPage==totalPage){
            url="airlinelist?currentPage="+totalPage;
        }else{
            url="airlinelist?currentPage="+(currentPage+1);
        }
        location.href=url;
    }
    function toLast() {
        location.href="airlinelist?currentPage="+totalPage;
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
                /*[          // 数据数组，name 为数据项名称，value 为数据项值
                    {value:235, name:'视频广告'},
                    {value:274, name:'联盟广告'},
                    {value:310, name:'邮件营销'},
                    {value:335, name:'直接访问'},
                    {value:400, name:'搜索引擎'}
                ]*/
            }
        ]
    })
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color: #9acfea;
        }
        input{
            border-color: deepskyblue;
            background-color: #9acfea;
            -webkit-box-shadow: 0 0 0 1000px #9acfea inset;
            height: 25px;
        }
        table{
            width: 700px;
            float: right;
            padding-right: 700px;
        }
    </style>
</head>
<body>
<center>
    <h1>修改用户信息</h1>

    <form action="uupdate" method="post">
        <table width="70%" height="35%" style="table-layout: fixed;border-collapse:separate;border-spacing: 15px;">
            <tr>
                <td width="150px" style="height: 15px">ID</td>
                <td><input type="text" name="id" value="${u.id}" readonly></td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" value="${u.username}"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="password" value="${u.password}"></td>
            </tr>
            <tr>
                <td>身份</td>
                <td><input type="text" name="position" value="${u.position}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="修改"></td>
                <td><input type="reset" name="重置"></td>
            </tr>

        </table>
    </form>

</center>
</body>
</html>

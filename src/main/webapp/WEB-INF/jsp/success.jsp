<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2020/7/22
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <style>
        *{
            text-align: center;
        }
    </style>
</head>
<body>
    登录成功
    <hr>
    账号：${requestScope.user.id}<br/>
    密码：${requestScope.user.password}<br/>
    姓名：${requestScope.user.name}<br/>
</body>
</html>

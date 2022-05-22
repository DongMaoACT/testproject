<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-with,initial-scale=1">
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>

<div id="login-box" style="...">
    <h1>Login</h1>

    <form action="${pageContext.request.contextPath}/user/validateUser" method="post" id="loginForm">
        <div class="input-box">
            <input type="text" placeholder="Username" name="id" id="username" >
        </div>
        <div class="input-box">
            <input type="password" placeholder="Password" name="password" id="password" >
        </div>
        <div class="span-box">
            <span id="msg" style="font-size: 12px;color:red "></span>
        </div>
        <button type="button" id="loginbtn">Sign In</button>
        <button type="button" id="regben" onclick="window.location.href='/user/register'">Regist</button>
    </form>

</div>
</body>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $("#loginbtn").click(function (){
        var uname =$("#username").val();
        var upwd =$("#password").val();
        //判断字符串是否为空
        if(isEmpty(uname)){
            $("#msg").html("username is null");
            return;
        }
        if(isEmpty(upwd)){
            $("#msg").html("password is null");
            return;
        }
        $("#loginForm").submit();
    });
    function isEmpty(str){
        if(str == null||str.trim()==""){
            return true;
        }
        return false;
    }
</script>
</html>
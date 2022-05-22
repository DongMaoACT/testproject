<%--
 Created by IntelliJ IDEA.
 User: 86265
 Date: 2018/1/30
 Time: 10:32
 To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-with,initial-scale=1">
    <title>Set up</title>
    <link rel="stylesheet" type="text/css" href="../../css/register.css"/>
</head>
<body>
<div id="login-box" style="...">
    <h1>Regist</h1>
    <form action="${pageContext.request.contextPath}/user/addUser" method="post" id="loginForm">
        <div class="input-box">
            <input type="id" placeholder="UserId" name="id" id="id" >
        </div>
        <div class="input-box">
            <input type="password" placeholder="Password" name="password" id="password" >
        </div>
        <div class="input-box">
            <input type="name" placeholder="Username" name="name" id="name" >
        </div>
        <div class="span-box">
            <span id="msg" style="font-szie: 12px;color:red "></span>
        </div>
        <button type="button" id="reister">Reiseter</button>
        <button type="button" id="Back" onclick="window.location.href='/login.jsp'">Back</button>
    </form>
</div>
</body>
<script type="text/javascript" src="../../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $("#reister").click(function (){
        var uid =$("#id").val();
        var upwd =$("#password").val();
        var uname = $("#name").val();
        //判断字符串是否为空
        if(isEmpty(uid)){
            $("#msg").html("userid is null");
            return;
        }
        if(isEmpty(upwd)){
            $("#msg").html("password is null");
            return;
        }
        if(isEmpty(uname)){
            $("#msg").html("username is null");
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

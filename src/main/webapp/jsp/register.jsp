<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>黑马旅游网-登录</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/web_demo/css/common.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/web_demo/css/login.css">


</head>

<body>
<!--引入头部-->
<div id="header"></div>
<!-- 头部 end -->
<section id="login_wrap">
    <div class="fullscreen-bg" style="background: url(http://localhost:8080/web_demo/img/login_bg.png);height: 600px;">

    </div>
    <div class="login-box">
        <div class="title">
            <img src="../img/login_logo.png" alt="">
            <span>注册账户</span>
        </div>
        <div class="login_inner">

            <!--登录错误提示消息-->

            <form target="_self" id="loginForm" action="/web_demo/adduser" method="post" accept-charset="utf-8">
               <input name="username" type="text" placeholder="请输入账号" autocomplete="off">
               <input name="password" type="text" placeholder="请输入密码" autocomplete="off">
                <br>
                <span type="text"  id="username_err"  style="color: #a94442" >${register}</span>
                验证码<input id="checkcode" name="write_checkcode" type="text">
                <img id="checkcodeImg" src="/web_demo/checkcode">
                <span type="text"  id="checkcode_err"  style="color: #a94442" >${checkcode_flag}</span>
                <a href="#" id="changeImg">看不清？换一张</a>
                <div class="submit_btn">
                    <button type="submit" id="btn_sub">注册</button>
                </div>
            </form>
            <div class="reg">已有帐号<a href="login.jsp">立即登录</a></div>
        </div>
    </div>
</section>
<script>
    document.getElementById("changeImg").onclick=function (){
        document.getElementById("checkcodeImg").src="/web_demo/checkcode?"+new Date().getMilliseconds()
    }
</script>


</body>

</html>
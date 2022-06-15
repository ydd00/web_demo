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

<body>s
<!--引入头部-->
<div id="header"></div>
<!-- 头部 end -->
<section id="login_wrap">
    <div class="fullscreen-bg" style="background: url(http://localhost:8080/web_demo/img/login_bg.png);height: 532px;">

    </div>
    <div class="login-box">
        <div class="title">
            <img src="../img/login_logo.png" alt="">
            <span>欢迎登录黑马旅游账户</span>
        </div>
        <div class="login_inner">

            <!--登录错误提示消息-->

            <form target="_self" id="loginForm" action="/web_demo/login" method="post" accept-charset="utf-8">
                <input type="hidden" name="action" value="login"/>
                <p><input name="username" type="text" placeholder="请输入账号" autocomplete="off" value="${cookie.username.value}"></p>


                <p><input name="password" type="text" placeholder="请输入密码" autocomplete="off" value="${cookie.password.value}"></p>
                <br>
                <span type="text"  id="err"  style="color: #a94442" >${login_flag}</span>
                <p>记住我<input id="remember" name="remember" type="checkbox"></p>
                <div class="submit_btn">
                    <button type="submit" id="btn_sub">登录</button>
                </div>
            </form>
            <div class="reg">没有账户？<a href="register.jsp">立即注册</a></div>
        </div>
    </div>
</section>
<c:if test="${register_flag!=null}">
    <script>
        alert("注册成功")
    </script>
</c:if>
</body>

</html>
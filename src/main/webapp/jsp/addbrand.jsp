<%--
  Created by IntelliJ IDEA.
  User: YDD
  Date: 2022/6/7
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加品牌</h1>
<form method="post" action="/web_demo/insert">
    品牌名称：<input type="text" name="brandName"><br>
    公司名称：<input type="text" name="companyName"><br>
    排序：<input type="text" name="ordered"><br>
    描述：<textarea name="description" rows="5" cols="20"></textarea><br>
    状态：启用 <input type="radio" name="status" value="1">禁用 <input type="radio" name="status" value="0"><br>
    <input type="submit">
</form>
</body>
</html>

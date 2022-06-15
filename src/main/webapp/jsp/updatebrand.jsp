<%--
  Created by IntelliJ IDEA.
  User: YDD
  Date: 2022/6/7
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>修改品牌</h1>
<form method="post" action="/web_demo/update">
    <input type="hidden" name="id" value="${brand.id}">
    品牌名称：<input type="text" name="brand_name" value="${brand.brand_name}"><br>
    公司名称：<input type="text" name="company_name" value="${brand.company_name}"><br>
    排序：<input type="text" name="ordered" value="${brand.ordered}"><br>
    描述：<textarea name="description" rows="5" cols="20">${brand.description}</textarea><br>
    状态：
    <c:if test="${brand.status==1}">
        启用<input type="radio" name="status" value="1" checked>
        禁用<input type="radio" name="status" value="0"><br>
    </c:if>
    <c:if test="${brand.status==0}">
        启用<input type="radio" name="status" value="1" >
        禁用<input type="radio" name="status" value="0"checked><br>
    </c:if>

    <input type="submit">
</form>
</body>
</html>

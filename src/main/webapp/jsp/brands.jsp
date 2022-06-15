<%--
  Created by IntelliJ IDEA.
  User: YDD
  Date: 2022/6/7
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${user.username}欢迎您</h1>
<input type="button" value="新增" id="add">
<table width="500" border="1" cellspacing="0">
    <tr>
        <th>序号</th>
        <th>品牌名</th>
        <th>公司名</th>
        <th>ordered</th>
        <th>描述</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

        <c:forEach varStatus="id" var="brand" items="${brands}">
            <tr align="center">
                <td>${id.count}</td>
                <td>${brand.brand_name}</td>
                <td>${brand.company_name}</td>
                <td>${brand.ordered}</td>
                <td>${brand.description}</td>
                <c:if test="${brand.status==1}">
                    <td>启用</td>
                </c:if>
                <c:if test="${brand.status==0}">
                    <td>禁用</td>
                </c:if>
                <td><a href="/web_demo/sel-id?id=${brand.id}&behavior=update">修改</a> <a href="/web_demo/sel-id?id=${brand.id}&behavior=delete">删除</a></td>

            </tr>
        </c:forEach>

</table>
<script>
    document.getElementById("add").onclick=function (){
        location.href="/web_demo/jsp/addbrand.jsp"
    }
</script>
<script>
    if(${i>0})
        alert("新增成功")
</script>
<script>
    if(${update_flag>0})
        alert("修改成功")
</script>
<script>
    if(${delete_flag>0})
        alert("删除成功")
</script>
</body>
</html>

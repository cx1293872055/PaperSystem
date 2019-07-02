<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈鑫
  Date: 2019/3/27
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>标签的使用</title>
</head>
<body>
</body>
<center >
    <table border="1">
        <tr>
            <td>标签</td>
            <td>值</td>
        </tr>
        <tr>
            <td>论文编号</td>
            <td><c:out value="${paper.paperId}"></c:out></td>
        </tr>
        <tr>
            <td>论文名字</td>
            <td><c:out value="${paper.paperName}"></c:out></td>
        </tr>
        <tr>
            <td>论文数量</td>
            <td><c:out value="${paper.paperNum}"></c:out></td>
        </tr>
        <tr>
            <td>论文详情</td>
            <td><c:out value="${paper.paperDetail}"></c:out></td>
        </tr>

    </table>
</center>
</html>

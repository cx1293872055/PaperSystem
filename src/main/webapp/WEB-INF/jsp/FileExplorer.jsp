<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈鑫
  Date: 2019/4/13
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>文件管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table-striped > tbody > .myTr:nth-of-type(odd) {
            background-color: transparent;
            z-index: -1;
            color: #000;

        }

        .table-striped > tbody > .myTr:hover {
            background-color: #f9f9f9;
            opacity: .5;

        }
    </style>
</head>
<body>
<script color="255,0,0" pointColor="255,0,0" opacity='0.7' zIndex="-2" count="200"
        src="${pageContext.request.contextPath}/js/canvas-nest.min.js"></script>

<script >
    if(${flag}){
        alert("文件已存在");
    }
</script>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的简单实现文件管理
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>文件管理</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" id="tableSort">
                <thead>
                <tr>
                    <th >文件/文件夹</th>
                    <th >文件名</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="File" items="${requestScope.get('FileList')}" varStatus="status">
                    <tr class="myTr">
                        <td>文件</td>
                        <td>
                            <a href="download?filename=${File.getName()}">
                                ${File.getName()}
                            </a>
                        </td>
                        <td>
                            <a href="${path}/file/delete?filename=${File.getName()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th style="
                        position: fixed;
                        width: 200px;
                        height: 200px;
                        top: 201px;
                        left: 182px;
                    ">
                        <form method="post" action="${path}/file/upload" enctype="multipart/form-data">
                        <input type="file" name="file" value="">
                        <input type="submit" value="提交" >
                        </form>
                    </th>
                </tr>
            </table>
        </div>
    </div>
</div>

</body>
</html>

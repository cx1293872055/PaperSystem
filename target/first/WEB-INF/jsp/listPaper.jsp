<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/4/6
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>Paper列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table-striped>tbody>.myTr:nth-of-type(odd) {
            background-color: transparent;
            z-index:-1;
            /*opacity: .5;*/
            color:#000;

        }
        .table-striped>tbody>.myTr:hover {
            background-color: #f9f9f9;
            opacity: .5;

        }
    </style>
</head>
<body>
<script color="255,0,0" pointColor="255,0,0" opacity='0.7' zIndex="-2" count="200" src="${pageContext.request.contextPath}/js/canvas-nest.min.js"></script>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>全部数据----分页</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/paper/toAddPaper?num=1">新增</a>
            <a class="btn btn-primary" href="${path}/paper/allPaper">无分页</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>名字</th>
                    <th>数量</th>
                    <th>详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="paper" items="${requestScope.get('list')}" varStatus="status">
                    <tr class="myTr">
                        <td>${paper.paperId}</td>
                        <td>${paper.paperName}</td>
                        <td>${paper.paperNum}</td>
                        <td>${paper.paperDetail}</td>
                        <td>
                            <a href="${path}/paper/toUpdatePaper?id=${paper.paperId}&num=1">更改</a>
                            <a href="<%=appPath%>/paper/del/${paper.paperId}?num=1">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
        <div>
            <a class="btn btn-primary" href="?page=1">首  页</a>
            <a class="btn btn-primary" href="?page=${page.page-1}">上一页</a>
            当前页数<a>${page.page}</a>
            <a class="btn btn-primary" href="?page=${page.page+1}">下一页</a>
            <a class="btn btn-primary" href="?page=${page.last}">末  页</a>
            <input class="btn btn-primary" type="text" name="page">

    </div>
</div>
</body>
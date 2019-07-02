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
                    <small>全部数据----无分页</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/paper/toAddPaper">新增</a>
            <a class="btn btn-primary" href="${path}/paper/listPaper">分页</a>
            <a class="btn btn-primary" href="${path}/export/download_excel?name=陈鑫">导出Excel</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" id="tableSort">
                <thead>
                <tr>
                    <th date-type="num">论文编号</th>
                    <th date-type="string">论文名字</th>
                    <th date-type="num">论文数量</th>
                    <th date-type="String">论文详情</th>
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
                            <a href="${path}/paper/toUpdatePaper?id=${paper.paperId}">更改</a> |
                            <a href="${path}/paper/del/${paper.paperId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    //查找表格的<th>元素，让它们可单击
    function makeSortable(table) {
        var headers = table.getElementsByTagName("th");
        for (var i = 0; i < headers.length; i++) {
            (function (n) {
                var flag = false;
                headers[n].onclick = function () {
                    // sortrows(table,n);
                    var tbody = table.tBodies[0];//第一个<tbody>
                    var rows = tbody.getElementsByTagName("tr");//tbody中的所有行
                    rows = Array.prototype.slice.call(rows, 0);//真实数组中的快照

                    //基于第n个<td>元素的值对行排序
                    rows.sort(function (row1, row2) {
                        var cell1 = row1.getElementsByTagName("td")[n];//获得第n个单元格
                        var cell2 = row2.getElementsByTagName("td")[n];
                        var val1 = cell1.textContent || cell1.innerText;//获得文本内容
                        var val2 = cell2.textContent || cell2.innerText;

                        if (val1 < val2) {
                            return -1;
                        } else if (val1 > val2) {
                            return 1;
                        } else {
                            return 0;
                        }
                    });
                    if (flag) {
                        rows.reverse();
                    }
                    //在tbody中按它们的顺序把行添加到最后
                    //这将自动把它们从当前位置移走，故没必要预先删除它们
                    //如果<tbody>还包含了除了<tr>的任何其他元素，这些节点将会悬浮到顶部位置
                    for (var i = 0; i < rows.length; i++) {
                        tbody.appendChild(rows[i]);
                    }

                    flag = !flag;
                }
            }(i));
        }
    }

    window.onload = function () {
        var table = document.getElementsByTagName("table")[0];
        makeSortable(table);
    }
</script>
</body>
</html>
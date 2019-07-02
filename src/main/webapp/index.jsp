<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>

<head>
    <title>首页</title>
    <style type="text/css">
        body{
        margin: 0;
        padding: 0;
        }
        a {
            text-decoration: none;
            color: #1766ff;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<script color="255,0,0" pointColor="255,0,0" opacity='0.7' zIndex="-2" count="200" src="${pageContext.request.contextPath}/js/canvas-nest.min.js"></script>
<br><br>
<div class="container"  style="text-align: center">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>
</div>
<h3>
    <a href="${path }/paper/allPaper">点击进入管理页面</a>
</h3>

<h3>
    <a href="${path }/file/FileExplorer">点击进去文件管理页面</a>
</h3>
<h3>
    <a href="${path }/paper/getPaper?id=14">点击进入</a>
</h3>

<form id="form" action="./test/format" >
    <table align="center">
        <tr>
            <td>
                日期
            </td>
            <td>
                <input id="date" name="date1"type="text" value="2017-06-01">
            </td>
        </tr>
        <tr>
            <td>
                金额
            </td>
            <td>
                <input id="amount" name="amount1" type="text" value="123,000,00">
            </td>
        </tr>

        <tr>
            <td></td>
            <td align="right">
                <input id="commit" type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
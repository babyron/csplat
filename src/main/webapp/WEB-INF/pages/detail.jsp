<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="zh-CN">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="../../favicon.ico">

  <title>控制面板</title>

  <!-- Bootstrap core CSS -->
  <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/static/css/dashboard.css" rel="stylesheet">

  <script src="/static/ie-emulation-modes-warning.js"></script>

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="javascript:void(0);" style="color: #fff;">移动感知 控制面板</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/mission/currentboard">返回上一页</a></li>
        <li><a href="/">返回首页</a></li>
        <li><a href="/user/profile">个人信息</a></li>
        <li><a href="/user/login">退出</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li><img src="/static/images/user.png"></li>
        <li><a href="/dashboard">您的控制面板 <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="/mission/currentboard">当前已发布任务</a></li>
        <li><a href="/mission/type2">数据分析</a></li>
        <li><a href="#">任务数据导出</a></li>
      </ul>
    </div>

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">当前任务回馈</h1>
      <h3>
        <c:if test="${type == 1}">
          ${mission.name}&nbsp;&nbsp;
          <c:forEach items="${mission.property}" var="p">
            ${p}&nbsp;&nbsp;
          </c:forEach>
        </c:if>
      </h3>
      <c:if test="${type == 2}">
        <h5>当前使用价格激励机制的任务有：
        </h5>
        <c:forEach items="${missions}" var="mission">
          <h5>任务名：${mission.name}&nbsp;&nbsp;任务id：${mission.id}</h5>
        </c:forEach>
      </c:if>
      <h3 class="sub-header">用户列表</h3>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
            <th>用户id</th>
            <th>用户名</th>
            <th>用户感知时长</th>
            <th>用户报价</th>
            <th>提交任务集</th>
            <th>X坐标</th>
            <th>Y坐标</th>
            <th>传感器水平</th>
          </tr>
          </thead>
          <tbody>


          <c:forEach items="${result}" var="user">
            <tr>
              <td>${user.id}</td>
              <td>${user.name}</td>
              <td>${user.time}</td>
              <td>${user.bid}</td>
              <td>
                <c:forEach items="${user.s}" var="ss">
                  ${ss}&nbsp;&nbsp;
                </c:forEach>
              </td>
              <td>${user.x}</td>
              <td>${user.y}</td>
              <td>
                <c:forEach items="${user.property}" var="p">
                  ${p}&nbsp;&nbsp;
                </c:forEach>
              </td>
            </tr>
          </c:forEach>

          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/static/jquery.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>个人信息</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/static/css/home.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <a class="navbar-brand" href="#">移动感知平台</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">个人信息</a></li>
                <li class="exit"><a href="/user/login">退出</a></li>
                <li class="exit"><a href="/dashboard">返回控制面板</a></li>
                <li class="exit"><a href="/">返回首页</a></li>
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>

    <div class="p-container">
      <div class="photo">
        <img src="/static/images/user.png">
      </div>
      <div class="content">
        <div class="information">
          <ul>
            <li>
              用户名
            </li>
            <li>
              已发布任务数
            </li>
            <li>
              总额
            </li>
            <li>
              已支出
            </li>
          </ul>
        </div>

      </div>
        <div class="footer">
          <p>copyright@anning</p>
        </div>
    <script src="/static/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>

  </body>
</html>
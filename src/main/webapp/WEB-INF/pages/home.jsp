<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <meta name="description" content="">
  <meta name="author" content="">
  <title>主页</title>

  <!-- Bootstrap core CSS -->
  <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->

  <!-- Custom styles for this template -->
  <link href="static/css/home.css" rel="stylesheet">
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
            <li class="active"><a href="#">首页</a></li>
            <li><a href="/user/profile">个人信息</a></li>
            <li class="exit"><a href="user/login">退出</a></li>
          </ul>
        </div>
      </div>
    </nav>

  </div>
</div>

<div class="container marketing">

  <!-- Three columns of text below the carousel -->
  <div class="row">
    <div class="col-lg-4">
      <img class="img-circle" src="static/images/1.png" alt="Generic placeholder image" width="140" height="140">
      <h2>发布任务</h2>
      <p><a class="btn btn-default" href="mission/task1" role="button">我想发布任务 &raquo;</a></p>
    </div><!-- /.col-lg-4 -->
    <div class="col-lg-4">
      <img class="img-circle" src="static/images/2.png" alt="Generic placeholder image" width="140" height="140">
      <h2>控制面板</h2>
      <p><a class="btn btn-default" href="dashboard" role="button">我想看下进度 &raquo;</a></p>
    </div><!-- /.col-lg-4 -->
  </div><!-- /.row -->
  <div class="footer">
    <p>copyright@anning</p>
  </div>
</div><!-- /.container -->

<script src="static/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
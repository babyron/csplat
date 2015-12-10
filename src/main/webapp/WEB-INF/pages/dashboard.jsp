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
            <li class="active"><a href="#">控制面板 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">当前已发布任务</a></li>
            <li><a href="#">数据分析</a></li>
            <li><a href="#">任务数据导出</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">当前状态</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <h2>已发布任务数</h2>
              <span class="text-muted">xxx</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h2>已支出预算</h2>
              <span class="text-muted">xxx</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h2>剩余预算</h2>
              <span class="text-muted">xxx</span>
            </div>
            
          </div>


        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header1">下一步工作</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <h3>继续发布任务</h3>
              <p><a class="btn btn-default" href="task1.jsp" role="button">Go &raquo;</a></p>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h3>删除任务</h3>
              <p><a class="btn btn-default" href="task1.jsp" role="button">Go &raquo;</a></p>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h3>数据分析</h3>
              <p><a class="btn btn-default" href="task1.jsp" role="button">Go &raquo;</a></p>
            </div>
            
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
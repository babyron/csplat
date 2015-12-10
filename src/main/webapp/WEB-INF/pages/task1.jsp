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
    <title>发布任务</title>

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
                <li class="active"><a href="#">任务面板</a></li>
                <li><a href="/user/profile">个人信息</a></li>
                <li class="exit"><a href="/user/login">退出</a></li>
                <li class="exit"><a href="/">返回首页</a></li>
               
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>

    <form class="task1" action="" method="get">  
      <label>请选择要使用的任务分配方式：</label> <br>
      <select name="" onchange="javascript:if (this.options[this.selectedIndex].value != '#')
       window.open(this.options[this.selectedIndex].value, '_self');this.options[0].selected;">  
      <option value="#">请选择</option>
      <option value="task2">关注任务质量</option>
      <option value="task3">关注任务报价</option>
      </select>  
    </form>  

    <script src="/static/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>

  </body>
</html>
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
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="css/home.css" rel="stylesheet">
    <script type="text/javascript"> 
<!-- 

//--> 
</script> 
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
                <li class="exit"><a href="user/login">退出</a></li>
                <li class="exit"><a href="home">返回首页</a></li>
                <li class="exit"><a href="user/task1">返回选择页</a></li>
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>

    <div class="task2 task3">
      <form action="" method="">
        <ul>
          <li>
            任务名：&nbsp;&nbsp;&nbsp;<input type="text" /><br>
          </li>
          <li>
            横坐标：&nbsp;&nbsp;&nbsp;<input type="text" /><br>
          </li>
          <li>
            纵坐标：&nbsp;&nbsp;&nbsp;<input type="text" /><br>
          </li>
          <li>
            感知次数：<input type="text" /><br>
          </li>
          <li>
            酬劳单价：<input type="text" /><br>
          </li>
          <li>
            任务价值：<input type="text" /><br>
          </li>
        </ul>
        <input type="submit" />
      </form>
    </div>
        <div class="footer">
          <p>copyright@anning</p>
        </div>
    <script src="jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

  </body>
</html>
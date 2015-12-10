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
                <li class="exit"><a href="/user/login">退出</a></li>
                <li class="exit"><a href="">返回首页</a></li>
                <li class="exit"><a href="/mission/task1">返回选择页</a></li>
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>

    <div class="task2">
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
          <li class="c">
            <p>任务属性要求：</p>
            <input type="checkbox" /><span> 加速度计</span><input type="text" /><br>
            <input type="checkbox" /><span> 陀螺仪</span><input type="text" /><br>
            <input type="checkbox" /><span> 电子罗盘</span><input type="text" /><br>
            <input type="checkbox" /><span> 气压计</span><input type="text" /><br>
            <input type="checkbox" /><span> 指纹传感器</span><input type="text" /><br>
            <input type="checkbox" /><span> 感光传感器</span><input type="text" /><br>
            <input type="checkbox" /><span> 麦克风</span><input type="text" /><br>
            <input type="checkbox" /><span> 图像传感器</span><input type="text" />
          </li>
        </ul>
        <input type="submit" />
      </form>
    </div>
        <div class="footer">
          <p>copyright@anning</p>
        </div>
    <script src="/static/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>

  </body>
</html>
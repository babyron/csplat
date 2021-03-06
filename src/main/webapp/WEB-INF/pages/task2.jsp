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
      <form action="/mission/task2/submit" method="get">
        <input type="hidden" name="type" value="${mission_type}" />
        <ul>
          <li>
            任务名：&nbsp;&nbsp;&nbsp;<input name="name" type="text" /><br>
          </li>
          <li>
            横坐标：&nbsp;&nbsp;&nbsp;<input name="x" type="text" /><br>
          </li>
          <li>
            纵坐标：&nbsp;&nbsp;&nbsp;<input name="y" type="text" /><br>
          </li>
          <li>
            感知次数：<input name="times" type="text" /><br>
          </li>
          <li>
            酬劳单价：<input name="pay" type="text" /><br>
          </li>
          <li>
            感知时长：<input name="time" type="text" /><br>
          </li>
          <li class="c">
            <p>任务属性要求：</p>
            <span> 加速度计</span><input name="a1" type="text" /><br>
            <span> 陀螺仪</span><input name="a2" type="text" /><br>
            <span> 电子罗盘</span><input name="a3" type="text" /><br>
            <span> 气压计</span><input name="a4" type="text" /><br>
            <span> 指纹传感器</span><input name="a5" type="text" /><br>
            <span> 感光传感器</span><input name="a6" type="text" /><br>
            <span> 麦克风</span><input name="a7" type="text" /><br>
            <span> 图像传感器</span><input name="a8" type="text" />
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
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Object name=session.getAttribute("name");
if(name==null){
   response.sendRedirect("login.jsp");
   return;
}
Object number=session.getAttribute("usename");
Object pwd=session.getAttribute("pwd");
Object photo=session.getAttribute("photo");
Object classes=session.getAttribute("classes");
Object major=session.getAttribute("major");
Object email=session.getAttribute("email");
Object grade=session.getAttribute("grade");
Object gender=session.getAttribute("gender");
Object phone=session.getAttribute("phone");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>在线服务</title>
	<meta http-equiv="Content-Type" content="text/html" />
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="./css/onlineService.css" />
	<link rel="stylesheet" type="text/css" href="./css/reset.css">
	<link rel="stylesheet" type="text/css" href="./css/common.css">

  </head>
  
  <body>
    <div class="header">

	<div class="wrapper">
		<a class="pull-left" href=""><img src="./images/logo.gif" alt=""/></a>
			<ul class="nav pull-left">
				<li><a href="course.html" target="_self"><img src="./images/book.gif" ><span>我的课程</span></a></li><!--
				--><li><a href="myTests.html" target="_self"><img src="./images/test.gif"  alt=""><span>我的考试</span></a></li><!--
				--><li><a href="active.html" target="_self"><img src="./images/active.gif" alt=""><span>我的活动</span></a></li><!--
				--><li><a href="teacherCard.html" target="_self"><img src="./images/card.gif" alt=""><span>教工名片</span></a></li><!--
				--><li class="active"><a href="onlineService.html" target="_self"><img src="./images/service.gif" alt=""><span>在线服务</span></a></li>
			</ul>
			<ul class="message">
				<li><a href=""><img src="./images/link.gif" alt=""></a></li><!--
				--><li><a href="message.html" target="_self"><img src="./images/bell.gif" alt=""></a></li><!--
				--><li><a href=""><img src="./images/message.gif" alt=""></a></li>
			</ul>
		<ul class="user pull-right">
		<li>
		<img src="./images/people.png" alt="">
		<a href="personalCenter.html" target="_self"><span><%=name.toString() %></span></a>
		</li>
			<li><a href="${base}loginout.form" target="_self"><span>退出</span></a></li>
		</ul>
	</div>
</div>
	<div class="banner"></div>
	<div class="context">
		<div class="context-order">
			<p class="tit" id="oo">在线预约</p>
			<hr/>
			<p id="adjust">选择预约项目：<select class="selected">
				<option selected="selected">&nbsp&nbsp简历修改</option>
			</select></p>
			<p id="adjust">请您填写表格：</p>
			<form action="${base}apoint-action.form" method="post">
			<div class="form"  >
				<p id="head">性别：<input type="text" name="gender" value="<%=gender.toString() %>"></p>
				<p>学号：<input type="text" name="number" value="<%=Integer.parseInt(number.toString())%>"></p>
				<p>学院：<input type="text" name="major" value="<%=major.toString() %>"></p>
				<p>班级：<input type="text" name="classes" value="<%=Integer.parseInt(classes.toString())%>"></p>
				<p>手机：<input type="text" name="photo" placeholder="请输入手机号"></p>
				<p>邮箱：<input type="text" name="email" value="<%=email.toString() %>"></p>
			</div>
				<input type="submit" value="提交"></input>
			</form>
			
		</div>
		<div class="context-contact">
			<p class="tit">联系我们</p>
			<img id="bang" src="./images/OS-bang.jpg" alt="" />
			<p class="tit2" id="t1">网站管理员：19293828281@qq.com</p>
			<p class="tit2" id="t2">教师联系方式<a href="#">跳转至教师名片&gt;&gt;</a></p>
		</div>
	</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Object name=session.getAttribute("name");
if(name==null){
   response.sendRedirect("login.jsp");
   return;
}
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
				<li><a href="./jsp/course.jsp" target="_self"><img src="./images/book.gif" ><span>我的课程</span></a></li><!--
				--><li><a href="./jsp/myTests.jsp" target="_self"><img src="./images/test.gif"  alt=""><span>我的考试</span></a></li><!--
				--><li><a href="./jsp/active.jsp" target="_self"><img src="./images/active.gif" alt=""><span>我的活动</span></a></li><!--
				--><li><a href="${base}teacherCardFindAll-action.form" target="_self"><img src="./images/card.gif" alt=""><span>教工名片</span></a></li><!--
				--><li class="active"><a href="./jsp/onlineService.jsp" target="_self"><img src="./images/service.gif" alt=""><span>在线服务</span></a></li>
			</ul>
			<ul class="message">
				<li><a href="../jsp/"><img src="./images/link.gif" alt=""></a></li><!--
				--><li><a href="../jsp/message.jsp" target="_self"><img src="./images/bell.gif" alt=""></a></li><!--
				--><li><a href="../jsp/"><img src="./images/message.gif" alt=""></a></li>
			</ul>
		<ul class="user pull-right">
		<li>
		<img src="./images/people.png" alt="">
		<a href="../jsp/personalCenter.jsp" target="_self"><span><%=name.toString() %></span></a>
		</li>
			<a href="${base}loginout.form" target="_self"><span>退出</span></a>
		</ul>
	</div>
</div>
	<div class="banner"></div>
	<div class="context">
		<div class="context-order">
			<p class="tit" id="oo">联系服务站</p>
			<hr/>
			<h5>遇到问题，请联系我们！</h5>
			<form class="form" action="${base}appoint-action.form" method="post">
			    <textarea placeholder="请输入联系内容" style="padding: 10px;" name="content"></textarea>
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

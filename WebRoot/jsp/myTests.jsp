<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>我的考试</title>
	<link rel="stylesheet" type="text/css" href="./css/myTests.css" />
	<link rel="stylesheet" type="text/css" href="./css/reset.css">
	<link rel="stylesheet" type="text/css" href="./css/common.css">

    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="header">

	<div class="wrapper">
		<a class="pull-left" href=""><img src="./images/logo.gif" alt=""/></a>
			<ul class="nav pull-left">
				<li><a href="course.html" target="_self"><img src="./images/book.gif" ><span>我的课程</span></a></li><!--
				--><li><a href="${base}examFindByTeacher-action.form" target="_self"><img src="./images/test.gif"  alt=""><span>我的考试</span></a></li><!--
				--><li><a href="${base}activeFindAll-action.form" target="_self"><img src="./images/active.gif" alt=""><span>我的活动</span></a></li><!--
				--><li><a href="${base}teacherCardFindAll-action.form" target="_self"><img src="./images/card.gif" alt=""><span>教工名片</span></a></li><!--
				--><li><a href="./jsp/onlineService.jsp" target="_self"><img src="./images/service.gif" alt=""><span>在线服务</span></a></li>
			</ul>
			<ul class="message">
				<li><a href=""><img src="./images/link.gif" alt=""></a></li><!--
				--><li><a href="message.html" target="_self"><img src="./images/bell.gif" alt=""></a></li><!--
				--><li><a href=""><img src="./images/message.gif" alt=""></a></li>
			</ul>
		<div class="user pull-right">
		<img src="./images/people.png" alt="">
		<a href="personalCenter.html" target="_self"><span><%=name.toString() %></span></a>
			<a  href="${base}loginout.form" target="_self"><span>退出</span></a>
		</div>
	</div>
</div>
	<div class="banner"></div>
	<div class="wrapper context">
		<div class="button pull-left">
			     <a href="#" class="testing active">
			     	<img src="./images/T.png" alt=""/>
			     	<span >进行考试</span>
					</a>
			     <a href="#" class="testing">
			     	<img src="./images/search.png" alt=""/ class="img">
			     	<span >成绩查询</span>
					</a>
		</div>
		<div class="subject">
			<p class="mytest"><a href="#">我的考试</a>&gt;<span><a href="#">进行考试的科目</a></span></p>
	<div class="wrapper_l">
		<img src="./images/c.png">
		<div class="text">
			<ul>
				<li><p>C语言及编程实践</p></li>
				<li>开始时间：5月1日14：00       <span class="marginleft">结束时间：5月1日16：00</span></li>
				<li>考试范围：1-9章</li>
			<ul>
		</div>
		<div class="more">
			<a href="##">开始考试</a>

		</div>


	</div>

	<div class="wrapper_l">
		<img src="./images/plan.png">
		<div class="text">
			<ul>
				<li><p>大学生职业与规划</p></li>
				<li>开始时间：5月1日14：00       <span class="marginleft">结束时间：5月1日16：00</span>></li>
				<li>考试范围：1-9章</li>
			<ul>
		</div>
		<div class="more">
			<a href="##">开始考试</a>

		</div>


	</div>

	<div class="wrapper_l mar">
		<img src="./images/math.png">
		<div class="text">
			<ul>
				<li><p>高等代数与解析几何</p></li>
				<li>开始时间：5月1日14：00       <span class="marginleft">结束时间：5月1日16：00</span></li>
				<li>考试范围：1-9章</li>
			<ul>
		</div>
		<div class="more">
			<a href="##">开始考试</a>

		</div>


	</div>

		</div>
	</div>
  </body>
</html>

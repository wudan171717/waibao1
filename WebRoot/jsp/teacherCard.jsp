<%@ page language="java" import="java.util.*,java.sql.*,dao.*,entity.*" pageEncoding="UTF-8"%>
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
Object teachers=session.getAttribute("teachers");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教职工名片</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="./css/reset.css">
	<link rel="stylesheet" type="text/css" href="./css/common.css">
	<link rel="stylesheet" type="text/css" href="./css/teacherCard.css">


  </head>
  
  <body>
 
    <div class="header">

	<div class="wrapper">
		<a class="pull-left" href=""><img src="./images/logo.gif" alt=""/></a>
				<ul class="nav pull-left">
				<li><a href="./jsp/course.jsp" target="_self"><img src="./images/book.gif" ><span>我的课程</span></a></li><!--
				--><li><a href="./jsp/myTests.jsp" target="_self"><img src="./images/test.gif"  alt=""><span>我的考试</span></a></li><!--
				--><li><a href="./jsp/active.jsp" target="_self"><img src="./images/active.gif" alt=""><span>我的活动</span></a></li><!--
				--><li  class="active"><a href="./jsp/teacherCard.jsp" target="_self"><img src="./images/card.gif" alt=""><span>教工名片</span></a></li><!--
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


	<div class="banner">
		<!--这里面放的是图片-->
	</div>

	<div class="content">
		<div class="start">
			教工名片＞<span>名片查询</span>
		</div>
		<div class="second">
			<a class="active" href="teacherCard.html">教工名片</a><a href="collect.html">个人收藏</a>
			<div class="search pull-right">
			<form method="post" action="${base}teacherCard-action.form" id="stuForm">
			<input type="text" name="tname" placeholder="请输入教师姓名关键字进行搜索" width="212" />
			<input type="image" src="./images/TC-search.png" width="14" height="14" alt="" />
			</form>
			</div>
		</div>
		<div class="third">
			<span>分类：</span>
			<ul>
				<li><a class="active" href="${base}teacherCardByCondition-action.form">全部</a></li>
				<li><a href="${base}teacherCardByCondition-action.form?postion=体育">体育</a></li>
				<li><a href="${base}teacherCardByCondition-action.form?postion=美术">美术</a></li>
				<li><a href="${base}teacherCardByCondition-action.form?postion=数学">数学</a></li>
			</ul>
		</div>
		<div class="fourth">

			<ul>
				<li class="fi">首字母：</li>
				<li class="all"><a href="">全部</a></li>
				<li><a href="">A</a></li>
				<li><a href="">B</a></li>
				<li><a href="">C</a></li>
				<li><a href="">D</a></li>
				<li><a href="">E</a></li>
				<li><a href="">F</a></li>
				<li><a href="">G</a></li>
				<li><a href="">H</a></li>
				<li><a href="">I</a></li>
				<li><a href="">J</a></li>
				<li><a href="">K</a></li>
				<li><a href="">L</a></li>
				<li><a href="">M</a></li>
				<li><a href="">N</a></li>
				<li><a href="">O</a></li>
				<li><a href=""><span>P</span></a></li>
				<li><a href="">Q</a></li>
				<li><a href="">R</a></li>
				<li><a href="">S</a></li>
				<li><a href="">T</a></li>
				<li><a href="">U</a></li>
				<li><a href="">V</a></li>
				<li><a href="">W</a></li>
				<li><a href="">S</a></li>
				<li><a href="">Y</a></li>
				<li><a href="">Z</a></li>
			</ul>
		</div>
		<div class="fifth">
			P
		</div>
		<div class="sixth">
			<%
			Teacher teacher=new Teacher();
			List <Teacher> lteachers=(List<Teacher>)teachers;
			for(int i=0;i<lteachers.size();i++){
				teacher=lteachers.get(i);
				%>
			
			<div class="fra">
				<img src="./images/fei.png">
				<div class="text">
					<ul>
						<li><h3><%=teacher.getName() %></h3></li>
						<li>教工组：<%=teacher.getType() %></li>
						<li>邮箱地址:<%=teacher.getEmail() %></li>
						<li>办公地址：<%=teacher.getAddress() %></li>
					</ul>
				</div>
				<div class="pic">
					<img src="./images/TC-preystar.png">
				</div> 
			</div>
					<%
			}
			 %>
		</div>
	</div>
  </body>
</html>

<%@ page language="java" import="java.util.*,java.sql.*,dao.*,entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Object name=session.getAttribute("name");
if(name==null){
	   response.sendRedirect("login.jsp");
	   return;
	}
Object communities=session.getAttribute("communities");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <link rel="stylesheet" type="text/css" href="./css/reset.css">
	<link rel="stylesheet" type="text/css" href="./css/common.css">
	<link rel="stylesheet" type="text/css" href="./css/active.css">
	<title>我的活动</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

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
	

	<div class="banner">
		<!--这里面放了图片-->
	</div>

	<div class="content wrapper">
		
			<ul>
				<li class="three"><a href="${base}activeFindByWriter-action.form?writer=<%=name.toString()%>">我发布的</a></li>
				<li class="three"><a href="${base}activeFindByType-action.form?type=社团"> 社团活动</a></li>
				<li class="three"><a href="${base}activeFindByType-action.form?type=学校">学校活动</a></li>
			</ul>
			<div class="control pull-right">
				<a href="#">社团管理</a>
			</div>			
	</div>

	<div class="clearfix"></div>

	<div class="wrapper_s">
		
		<ul>
			<li><span>活动状态：</span></li>
			<li><a href="${base}activeFindAll-action.form">全部</a></li>
			<li><a href="${base}activeFindStatue-action.form?statue=进行中">进行中</a></li>
			<li><a href="${base}activeFindStatue-action.form?statue=已过时">已过期</a></li>
		</ul>
			
		
	</div>

	<div class="clearfix"></div>
<%
			Community community=new Community();
			List <Community> lcommunities=(List<Community>)communities;
			for(int i=0;i<lcommunities.size();i++){
				community=lcommunities.get(i);
				%>


	<div class="wrapper_l">
		<img src="<%=community.getImg() %>">
		<div class="text">
			<ul>
				<li><p><%=community.getName() %></p></li>
				<li>活动时间：<%=community.getTime() %></li>
				<li>活动地点：<%=community.getAddress() %></li>
			</ul>
		</div>
		<div class="more">
			<a href="${base}activeFindById-action.form?id=<%=community.getId() %>">查看更多</a>
		</div>
	</div>
		<%
			}
		%>
  </body>
</html>

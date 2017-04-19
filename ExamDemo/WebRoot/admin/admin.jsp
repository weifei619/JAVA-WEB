<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统管理中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	
	 <link rel="stylesheet" type="text/css" href="css/easyui.css">
    <link rel="stylesheet" type="text/css" href="css/zzsc.css">
    <link rel="stylesheet" type="text/css" href="css/my.css">
  </head>
  
  <body>
    <body class="easyui-layout">   
    <div data-options="region:'north',split:true" style=" height:90px;" float:right;>
    <center><font size=7  style="楷体"><strong>考试管理系统</strong></font></center>
 <div style="position: absolute; bottom: 10px; right: 10px;"><font size=2>管理员：${a.uno}</font><a href="<%=basePath%>LoginoutSvl" class="button red">退出</a></div>
    </div>   
   
    <div data-options="region:'west',title:'管理中心',split:true" style="width:200px;">
       
   <div class="subNavBox">
	<div class="subNav currentDd currentDt">系统管理</div>
	<ul class="navContent " >
	        <li><a href="StudentinfoSvl">学生信息管理</a></li>
			<li><a href="TeacherinfoSvl">教师信息管理</a></li>
			<li><a href="ClassinfoSvl">班级信息管理</a></li>		
	</ul>
	<div class="subNav">考试管理</div>
	<ul class="navContent">
	        <li><a href="ExamplanSvl">添加考试安排</a></li>
	        <li><a href="ExamplaneditSvl">编辑考试安排</a></li>
			<li><a href="Correctplan">阅卷安排</a></li>
				
	</ul>
	
<div class="subNav">公告管理</div>
	<ul class="navContent">
			<li><a href="NoticeinfoSvl">信息管理</a></li>
			
	</ul>
</div>
    
    </div>
    
       
    <div  title="${title}"data-options="region:'center'," style=" background-color:#F4F4F4 ; padding:5px;">   
    <jsp:include  page="${path}"></jsp:include>
    </div>
</body>
  </body>
    <script type="text/javascript">
$(function(){
$(".subNav").click(function(){
			$(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd");
			$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt");
			
			
			$(this).next(".navContent").slideToggle(500).siblings(".navContent").slideUp(500);
	});	
});
</script>
</html>

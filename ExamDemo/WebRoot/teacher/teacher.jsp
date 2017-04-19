<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师管理中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	 <link rel="stylesheet" type="text/css" href="css/easyui.css">
	 <link rel="stylesheet" type="text/css"  href="css/zzsc.css" >
	 <link rel="stylesheet" type="text/css" href="css/my.css">
	 
    

  </head>
  
  <body>
    <body class="easyui-layout">   
    <div data-options="region:'north',split:true" style=" height:90px;">
    <center><font size=7  style="楷体"><strong>考试管理系统</strong></font></center>
 <div style="position: absolute; bottom: 10px; right: 10px;"><font size=2>教师：${a.uno}</font><a href="<%=basePath%>LoginoutSvl" class="button red">退出</a></div>
    </div>    
   
    <div data-options="region:'west',title:'教师管理中心',split:true" style="width:200px;">
<div class="subNavBox">

	<div class="subNav currentDd currentDt">题库管理</div>
	<ul class="navContent " >
	        <li><a href="teacher/QuestionSvl">查询题目</a></li>
			<li><a href="teacher/QuestionAddSvl">添加题目</a></li>
		
			
	</ul>
	<div class="subNav">知识点管理</div>
	<ul class="navContent">
	        <li><a href="teacher/KnowledgeSvl">查询知识点</a></li>
			<li><a href="teacher/KnowledgeAddSvl">添加知识点</a></li>	
		
	</ul>
	<div class="subNav">试卷管理</div>
	<ul class="navContent">
	        <li><a href="teacher/ChecktestSvl">查询试卷</a></li>
			<li><a href="teacher/AddtestSvl">添加试卷</a></li>
			<li><a href="teacher/CorrectpaperSvl">批阅试卷</a></li>
	</ul>
	<div class="subNav">成绩管理</div>
	<ul class="navContent">
			<li><a href="teacher/QueryscoreSvl">成绩查询</a></li>
			
			
	</ul>
</div>
    
    
     
    
     
    
</div> 
    
    
      
    <div  title="${title}"data-options="region:'center'," style="padding:5px;">   
    <jsp:include  page="${path}"></jsp:include>
    </div>
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

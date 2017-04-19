<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"  href="css/my.css" >
  </head>
  
  <body>
  <center>
   <form action="<%=basePath%>teacher/ChecktestSvl" method="post" class="definewidth m20" >
  <input type="text" name="ptitle" value="请输入试卷标题"></input>
 <button type="submit" class="button white" >查询</button>
    </form>
    </center>
    <table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
         <th><font color="#33ccff" size=2;><strong >试卷ID</strong></font></th> 
         <th><font color="#33ccff" size=2;><strong >出卷教师</strong></font></th>  
         <th><font color="#33ccff" size=2;><strong >课程</strong></font></th>     
        <th><font color="#33ccff" size=2;><strong >出卷时间</strong></font></th>
         <th><font color="#33ccff" size=2;><strong >试卷标题</strong></font></th>
          <th><font color="#33ccff" size=2;><strong >是否完成</strong></font></th>
          <th><font color="#33ccff" size=2;><strong >试卷总分</strong></font></th>
          <th><font color="#33ccff" size=2;><strong >操作</strong></font></th>
        </tr>   
    </thead>   
    <c:forEach items="${paperinfo}" var="p">
			<tr>

				<td>${p.pid}</td>
				<td>${p.tno}</td>
                <td>${p.cname}</td>            
				<td>${p.ctime}</td>
				<td>${p.ptitle}</td>
                <td>${p.pstate}</td>
                <td>${p.score}</td>
           
			<td><a href="<%=basePath%>teacher/EditpaperSvl?pid=${p.pid}" class="button white">编辑</a>
			<a href="<%=basePath%>teacher/EdittestSvl?ptitle=${p.ptitle}&pid=${p.pid}" class="button white">添加试题</a>
					<a href="<%=basePath%>teacher/RemovetestSvl?pid=${p.pid}" class="button red">删除</a></td>
			</tr>
		</c:forEach>
    </table>
  
    
  </body>
  
</html>

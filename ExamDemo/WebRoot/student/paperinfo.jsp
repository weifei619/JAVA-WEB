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
  
    <table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
            <th><font color="#33ccff" size=2;><strong >考试ID</strong></font></th>
         <th><font color="#33ccff" size=2;><strong >试卷ID</strong></font></th> 
         <th><font color="#33ccff" size=2;><strong >出卷教师</strong></font></th>  
         <th><font color="#33ccff" size=2;><strong >课程</strong></font></th>     
        <th><font color="#33ccff" size=2;><strong >考试时间</strong></font></th>
         <th><font color="#33ccff" size=2;><strong >试卷标题</strong></font></th>
          <th><font color="#33ccff" size=2;><strong >是否完成</strong></font></th>
          <th><font color="#33ccff" size=2;><strong >试卷总分</strong></font></th>
          <th><font color="#33ccff" size=2;><strong >操作</strong></font></th>
        </tr>   
    </thead>   
    <c:forEach items="${paperinfo}" var="p">
			<tr>
                <td>${p.eid}</td>
				<td>${p.pid}</td>
				<td>${p.tno}</td>
                <td>${p.cname}</td>            
				<td>${p.stime}--${p.etime}</td>
				<td>${p.ptitle}</td>
                <td>${p.pstate}</td>
                <td>${p.score}</td>
           
			<td><a href="<%=basePath%>student/ExamSvl?pid=${p.pid}&examid=${p.eid}" class="button white">选择进行考试</a>
			</td>
			</tr>
		</c:forEach>
    </table>
  
    
  </body>
  
</html>

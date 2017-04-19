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
    
    <title>試卷信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <link rel="stylesheet" type="text/css"  href="css/my.css" >

  </head>
  
  <body>
  
	  <table class="altrowstable" width="100%">
	  <tr>    
         <th>试题类型</th>  
         <th>试题序号</th>
         <th>试题内容</th>   
         <th>试题分数(总分：${score})</th> 
        <th>操作</th>
        </tr>  
	  
<c:forEach items="${tp}" var="q"  >
			<tr>		
			<td>${q.qtname}</td>			
				<td >${q.seq}</td>
                <td>${q.qcont}</td>	
                <td>${q.score}</td>	
                <td>
					    <a href="<%=basePath%>teacher/RemovepaperSvl?qid=${q.qid}" class="button red">删除</a>
					    
					</td>
			</tr>
			
		</c:forEach>


	</table>  
                    <center><a href="<%=basePath%>teacher/ChecktestSvl" class="button white">返回</a></center>
  </body>
</html>

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
    
    <title>添加知识点</title>
    
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
         <th><font color="#33ccff" size=2;><strong >知识点ID</strong></font></th> 
         <th><font color="#33ccff" size=2;><strong >课程ID</strong></font></th>  
         <th><font color="#33ccff" size=2;><strong >知识点名称</strong></font></th>     
        <th><font color="#33ccff" size=2;><strong >操作</strong></font></th>
        </tr>   
    </thead>   
    <c:forEach items="${kno1}" var="kn">
			<tr>

				<td>${kn.kid}</td>

				<td>${kn.cno}</td>
                <td>${kn.kname}</td>
           
					<td><a href="<%=basePath%>teacher/EditknowledgeSvl?kid=${kn.kid}" class="button white">修改</a>
					<a href="<%=basePath%>teacher/RemoveknowledgeSvl?kid=${kn.kid}" class="button red">删除</a>
					</td>
			
			</tr>
		</c:forEach>

    </table>
    <center><button type="button"  onclick="location.href='KnowledgeSvl'" class="button white" >返回</button></center>

 </body>
 
</html>

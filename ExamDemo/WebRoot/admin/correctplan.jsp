<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>阅卷安排</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="stylesheet" type="text/css" href="css/easyui.css">
 <link rel="stylesheet" type="text/css" href="css/my.css">
  </head>
  
  <body>
  <form action="<%=basePath%>Correctplan" method="post" class="definewidth m20" >
<table  class="altrowstable" width="100%">
    <tr>
        
        <td>需阅试卷：</td><td>
        <select name="examid">
					<c:forEach items="${exam}" var="e">
						<option value="${e.examid}">${e.examtitle}</option>
					</c:forEach>
				</select>
				</td>
				</tr>
<tr>	     <td>阅卷教师：</td><td>
        <select name="tno">
					<c:forEach items="${teacher}" var="t">
						<option value="${t.tno}">${t.tname}</option>
					</c:forEach>
				</select>
				</td>
				
			</tr>
<tr>
<td><button type="submit" class="button white">提交</button>  <td>  <button type="reset" class="button white"/>重置</button> </td>
	</tr>
</table>


</form>
  
  
  
  
  
  
  
  
  </body>
</html>

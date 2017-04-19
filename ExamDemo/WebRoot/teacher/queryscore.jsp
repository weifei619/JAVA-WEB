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
   <form action="<%=basePath%>teacher/QueryscoreSvl" method="post">
 <table>
 <tr>
<td><input type="test" name="pid"placeholder="øº ‘ID"></td>
<td><input type="test" name="sno"placeholder="—ß∫≈"></td>
</tr>

  </table>
   <button type="submit" class="button white" >≤È—Ø</button>
  </form>
  </center>
  
  
  

  
    
  </body>
  
</html>

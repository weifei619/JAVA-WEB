<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addnotice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<form action="<%=basePath%>NoticeaddSvl" method="post" class="definewidth m20" >
<table  class="altrowstable" width="100%">
       <tr>
      <td>编号:</td><td><input type="text" name="nid"/></td></tr>
      <tr>
	   <td>发布人：</td><td>${a.uno}</td>
        
        </tr>
      <tr>
       
        <td>内容：</td><td><input type="text" name="ncont"/></td>
	     
       </tr>
       <tr>
        
    
<td><button type="submit" class="button white">提交</button>    <button type="reset" class="button white"/>重置</button> </td>   <td> <button type="button" class="button white" onclick="location.href='NoticeinfoSvl'" />返回</button></td>
	</tr>
</table>


</form>
  </body>
</html>

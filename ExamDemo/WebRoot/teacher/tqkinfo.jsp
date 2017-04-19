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
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" type="text/css"  href="css/my.css" >


	

  </head>
  
  <body>
   <table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
            
         <th><font color="#33ccff" size=2;><strong >题目ID</strong></font></th>     
        <th><font color="#33ccff" size=2;><strong >操作</strong></font></th>  
        </tr>   
    </thead>   
    <c:forEach items="${tqk}" var="t">
			<tr>

				<td>${t.kid}</td>               
				  <td>${t.qid}</td>	
                 <td><a href="<%=basePath%>teacher/RemovetqkSvl?qid=${t.qid}&kid=${t.kid}" class="button red">删除</a></td>
			</tr>
		</c:forEach>
		
    </table>
 <center>  <a href="<%=basePath%>teacher/KnowledgeSvl" class="button white">返回</a></center>
  </body>
</html>

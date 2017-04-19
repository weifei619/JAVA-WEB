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
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
     <link rel="stylesheet" type="text/css"  href="css/my.css" >
  </head>

  
<body>
  
 <center>
 <form action="<%=basePath%>teacher/KnowledgeinfoSvl" method="post">
 <table>
 <tr>
  <td>
  
 <font color="#33ccff"><strong>课程：</strong></font>
		<select name="cno"> 
		<c:forEach items="${cour}" var="tq">
				<option  value="${tq.cno }">${tq.cname}</option>
		    </c:forEach>
		    </select>

<br>

 </td>
 <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 <td>
 
 
 <input type="text" name="kname"></input>
 <button type="submit" class="button white" >查询</button>
  
  </td>
  </tr>
  </table>
  </form>
  </center>
 
<table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
         <th><font color="#33ccff" size=2;><strong >知识点ID</strong></font></th> 
         <th><font color="#33ccff" size=2;><strong >课程名称</strong></font></th>  
         <th><font color="#33ccff" size=2;><strong >知识点名称</strong></font></th>     
        <th><font color="#33ccff" size=2;><strong >操作</strong></font></th>
        </tr>   
    </thead>   
    <c:forEach items="${kno1}" var="kn">
			<tr>

				<td>${kn.kid}</td>

				<td>${kn.cname}</td>
                <td>${kn.kname}</td>
           
					<td>
					<a href="<%=basePath%>teacher/TqkinfoSvl?kid=${kn.kid}" class="button white">题目详情</a>
					<a href="<%=basePath%>teacher/EditknowledgeSvl?kid=${kn.kid}" class="button white">编辑</a>
					<a href="<%=basePath%>teacher/RemoveknowledgeSvl?kid=${kn.kid}" class="button red" >删除</a>
					</td>
			
			</tr>
		</c:forEach>
		
    </table>

 </body>

 
</html>

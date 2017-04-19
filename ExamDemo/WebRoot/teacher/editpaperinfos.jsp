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
    
    <title>添加试卷</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"  href="css/my.css" >
  </head>
  
  <body>
<form action="<%=basePath%>teacher/EditpaperSvl" method="post" class="definewidth m20" >

<table  class="altrowstable" width="100%">
    <tr>
        <td><font color="#33ccff" size=2;><strong >试卷编号：</strong></font>${p.pid}</td>
        </tr>
         <tr>
        <td><font color="#33ccff" size=2;><strong >课程：</strong></font>
        <select name="cno" >
			<c:forEach items="${cour}" var="cor">
				<option value="${cor.cno }">${cor.cname}</option>
		    </c:forEach>
		    </select>
    </tr>
      <tr>
      <tr>
       <td><font color="#33ccff" size=2;><strong >试卷标题：</strong></font><textarea name="ptitle"  style= "width:300px;height:100px;" >${p.ptitle}</textarea></td>
       
    </tr>
  <tr>
        <td><font color="#33ccff" size=2;><strong >试卷总分：</strong></font><input type="number" name="score" value="${p.score}" /></td>
        </tr>
     <tr>
       <td><font color="#33ccff" size=2;><strong >是否完卷：</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><font color=red size=2;><strong >是</strong>&nbsp;<input type="radio" name="pstate" value="1" checked="checked"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red size=2;><strong >否</strong>&nbsp;<input type="radio" name="pstate" value="2"/></label></td>
       </tr>
    <tr>
    <td>
    <button type="submit" class="button red">提交</button> <button type="reset"  class="button white">重置</button>     <a href=javascript:history.back(); class="button white">返回</a></td>
	</tr>
	</table>
	

	</form>
  </body>
</html>

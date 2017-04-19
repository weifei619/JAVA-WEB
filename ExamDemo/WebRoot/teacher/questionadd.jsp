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
    
    <title>知识点添加</title>
    
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
   <br>
 <font color="#33ccff" size=4;><strong>请添加题目：</strong></font>
<form action="<%=basePath%>teacher/QuestionAddSvl" method="post" class="definewidth m20" >

<table  class="altrowstable" width="100%">
    <tr>
        <td><font color="#33ccff" size=2;><strong >试题编号：</strong></font><input type="number" name="qid" id="tt"/></td>
        </tr>
        <tr>
        <td><font color="#33ccff" size=2;><strong >所属题型：</strong></font>
        <select name="qtid" >
			<c:forEach items="${tqt}" var="tq">
				<option value="${tq.qtid}">${tq.qtname}</option>
		    </c:forEach>
		    </select>
		    </td>
    </tr>
      <tr>
       <td><font color="#33ccff" size=2;><strong >试题内容：</strong></font><textarea name="qcont" id="tt" style= "width:300px;height:150px;"></textarea></td>
       
    </tr>
     <tr>
       <td><font color="#33ccff" size=2;><strong >试题答案：</strong></font><textarea  name="qans" id="tt" style= "width:300px;height:100px;"></textarea></td>
       
    </tr>
     <tr>
       <td><font color="#33ccff" size=2;><strong >试题解析：</strong></font><textarea name="qexp" id="tt" style= "width:300px;height:50px;"></textarea></td>
       
    </tr>
     <tr>
       <td><font color="#33ccff" size=2;><strong >试题图片：</strong></font><input type="text"  name="qurl" id="tt"/></td>
       
    </tr>
     <tr>
       <td><font color="#33ccff" size=2;><strong >是否过期：</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><font color=red size=2;><strong >是</strong>&nbsp;<input type="radio" name="ispastdue" value="1"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red size=2;><strong >否</strong>&nbsp;<input type="radio" name="ispastdue" value="0" checked="checked"/></label></td>
       </tr>
    <tr>
    <td>
    <button type="submit" class="button red">提交</button> <button type="reset"  class="button white">重置</button>     <button type="button"  onclick="location.href='QuestionSvl'" class="button white" >返回</button></td>
	</tr>
	</table>
	

	</form>
  </body>
</html>

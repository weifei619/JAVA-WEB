<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
 <head>
    <base href="<%=basePath%>">
    
    <title>学生信息管理</title>

 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>

	 <link rel="stylesheet" type="text/css" href="css/easyui.css">
	 <link rel="stylesheet" type="text/css" href="css/my.css">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<body>
<font color="#777777"><strong>请填写学生资料：</strong></font>
<form action="<%=basePath%>EditstudentSvl" method="post" class="definewidth m20" >
<table  class="altrowstable" width="100%">
    <tr>
        <td>学号：</td><td>${s.sno}</td>
        <td>班级编号：</td><td><input type="text" name="classno" value="${s.classno}"/></td>
	     <td>姓名：</td><td><input type="text" name="sname" value="${s.sname}"/></td>
	</tr>
 
        
       <tr>
      <td>年龄：</td><td><input type="text" name="sage" value="${s.sage}"/></td>
	   <td>学校：</td><td><input type="text" name="sschool" value="${s.sschool}"/></td>
        <td>年级：</td><td><input type="text" name="sgrade" value="${s.sno}"/></td>
        </tr>
      <tr>
         <td>性别：</td><td><label>男&nbsp;<input type="radio" name="sgender" value="1" checked="checked"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;女&nbsp;<input type="radio" name="sgender" value="2"/></label></td>
        <td>联系方式：</td><td><input type="text" name="scontact" value="${s.scontact}"/></td>
	   <td>个人邮箱：</td><td><input type="text" name="semail" value="${s.semail}"/></td>
       </tr>
       <tr>
        <td>地址：</td><td><input type="text" name="saddress" value="${s.saddress}"/></td>
        <td>密码：</td><td><input type="text" name="pwd" value="${a.password}"/></td>
   <td><button type="submit" class="button white">提交</button>    <button type="reset" class="button white">重置</button>   </td><td>  <button type="button" onclick="location.href='StudentinfoSvl'" class="button white">返回</button></td>
	</tr>
   
</table>

</form>
 </body> 
</html>

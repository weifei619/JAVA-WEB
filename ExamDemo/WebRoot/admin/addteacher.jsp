<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
<font color="#777777" size = 4><strong>请填写教师资料：</strong></font>
<form action="<%=basePath%>AddTeacherSvl" method="post" class="definewidth m20" >
<table  class="altrowstable" width="100%">
	<tr>
	</tr>
    <tr>
        <td>教师编号：</td><td><input type="text" name="tno" /></td>
        </tr>
        <tr>
	     <td>姓名：</td><td><input type="text" name="tname"/></td>
		</tr>
		<tr>
        <td>性别：</td><td><label>男&nbsp;<input type="radio" name="tgender" value="1"/>女&nbsp;<input type="radio" name="tgender" value="2"/></label></td>
 		</tr>
    	  <tr> 
        <td>联系方式：</td><td><input type="text" name="tcontact"/></td>
        </tr>
        <tr>
	   <td>个人邮箱：</td><td><input type="text" name="temail"/></td>
       </tr>
  		<tr>
       <td>是否在职：</td><td><label>是&nbsp;<input type="radio" name="ison" value="1"/>否&nbsp;<input type="radio" name="ison" value="2"/></label></td>
       </tr>
       <tr>
       <td>密码：</td><td><input type="password" name="pwd"/></td>
       </tr><tr>
<td><button type="submit" class="button white">提交</button>    <button type="reset" class="button white">重置</button></td><td>     <button type="button" onclick="location.href='TeacherinfoSvl'" class="button white">返回</button></td>
	</tr>
</table>

</form>
 </body>
</html>

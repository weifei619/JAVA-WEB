<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
 <head>
    <base href="<%=basePath%>">
    
    <title>班级信息管理</title>

 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>

	 <link rel="stylesheet" type="text/css" href="css/my.css">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<body>
<font color="#777777" size = 4><strong>请填写班级信息：</strong></font>

<form  action="<%=basePath%>EditClassSvl" method="post" class="definewidth m20" >
 <table class="altrowstable" width="100%" >
	<tr>
	</tr>
    <tr>
        <td> 班级编号：</td><td>${c.classno}</td>
        </tr>
        <tr>
	     <td> 班级名：</td><td><input type="text" name="classname" value="${c.classname}"/></td>
		</tr>
  		<tr>
       <td> 是否毕业：</td><td><label>是&nbsp;<input type="radio" name="isgraduate" value="1"/>否&nbsp;<input type="radio" name="isgraduate" value="2"/></label></td>
       </tr>
       <tr>
<td><button type="submit" class="button white">提交</button>  <button type="reset" class="button white">重置</button></td><td>  <button   onclick="location.href='ClassinfoSvl'" class="button white">返回</button></td>
	</tr>
</table>


	
</form>
 </body>
</html>

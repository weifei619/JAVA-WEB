<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<form action="<%=basePath%>AddstudentSvl" method="post" class="definewidth m20" >
<table  class="altrowstable" width="100%">
    <tr>
        <td>学号：</td><td><input type="text" name="sno" onblur="checkAccount()" id="sname" /><a id="a"></a></td>
        <td>班级</td><td>
        <select name="classno">
					<c:forEach items="${tclass}" var="bt">
						<option value="${bt.classno}">${bt.classno}</option>
					</c:forEach>
				</select>
				</td>
	     <td>姓名：</td><td><input type="text" name="sname"/></td>
	</tr>
 
        
       <tr>
      <td>年龄：</td><td><input type="text" name="sage"/></td>
	   <td>学校：</td><td><input type="text" name="sschool"/></td>
        <td>年级：</td><td><input type="text" name="sgrade"/></td>
        </tr>
      <tr>
          <td>性别：</td><td><label>男&nbsp;<input type="radio" name="sgender" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;女&nbsp;<input type="radio" name="sgender" value="2"/></label></td>
        <td>联系方式：</td><td><input type="text" name="scontact"/></td>
	   <td>个人邮箱：</td><td><input type="text" name="semail"/></td>
       </tr>
       <tr>
        <td>地址：</td><td><input type="text" name="saddress"/></td><td class="tableleft">密码：</td><td><input type="password" name="pwd"/></td>
    
<td><button type="submit" class="button white">提交</button>    <button type="reset" class="button white"/>重置</button> </td>   <td> <button type="button" class="button white" onclick="location.href='StudentinfoSvl'" />返回</button></td>
	</tr>
</table>


</form>
 </body>
 <script type="text/javascript">

   function checkAccount(){
      var sno = document.getElementById("sname").value;
      var url = "<%=basePath%>CheckaccountSvl?sno=" + sno;
      createXmlHttp(url);
   }


    var xmlhttp;
	function createXmlHttp(url) {
	    
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}else{
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = getReturnValue;   //注册回调函数，处理返回结果
		xmlhttp.open("GET",url,true);
        xmlhttp.send(null);
	}
	
	
	function getReturnValue(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
	    	//写需要完成逻辑
	    	
	    	var text = xmlhttp.responseText;
	    	var aNode = document.getElementById("a");

	    	if( "账号已经被注册"==text){  
	    	    aNode.style.color = "red";
	    	}else{
	    	    aNode.style.color = "green";
	    	}
	    	 aNode.innerHTML = text;
	    	
	    	 
	    }
	}
</script>
</html>

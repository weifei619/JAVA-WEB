<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改学生密码</title>
    
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
  
  <form action="<%=basePath%>student/EditPwdSvl" method="post" class="definewidth m20" >
  <center>
  <table>
  <tr>
  <td>旧密码：</td><td><input type="text" name="password" onblur="checkAccount()" id="sname" /><a id="a"></a></td>
    </tr>
    <tr>
     <td>新密码：</td><td><input type="text" name="newpwd"  id="newname" /><a id="b"></a></td>
     </tr>
     <tr>
     <td>确认密码：</td><td><input type="text" name="newpwdAgain"  id="newname" /><a id="b"></a></td>
      </tr>
      <tr>
      <td>  <button type="submit" class="button white">确认</button> </td>
      <td>
      <button type="button" onclick="location.href='PersonInfoSvl'" class="button white">取消</button>
      </td>
      </tr>
      </table>
      </center>
   </form>
  </body>
  
   <script type="text/javascript">

   function checkAccount(){
      var password= document.getElementById("sname").value;
      var url = "<%=basePath%>student/CheckPwdSvl?password=" + password;
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

	    	if( "密码错误"==text){  
	    	    aNode.style.color = "red";
	    	}else{
	    	    aNode.style.color = "green";
	    	}
	    	 aNode.innerHTML = text;
	    	
	    	 
	    }
	}
</script>
</html>

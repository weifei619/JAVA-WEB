<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 <link rel="stylesheet" type="text/css" href="css/my.css">

  </head>
  
  <body>
   <table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
         <tr>   
         <th data-options="field:' '">操作</th>  
            <th data-options="field:'no'">教师编号</th>            
            <th data-options="field:'name'">姓名</th>   
             <th data-options="field:'gender'">性别</th>     
            <th data-options="field:'contact'">联系方式</th> 
             <th data-options="field:'email'">邮箱</th> 
             <th data-options="field:'ison'">是否在职</th> 
           
        </tr> 
    </thead>   

<tbody > 
<tr>
<td><a href="EditTeacherSvl?sno=${t.tno}"class="button white">编辑</a>&nbsp;&nbsp;<a href="RemoveTeacherSvl?sno=${t.tno}"class="button white">删除</a></td><td>${t.tno}</td><td>${t.tname}</td><td>${t.tgender}</td><td>${t.tcontact}</td><td>${t.temail}</td><td>${t.ison}</td>
</tr> 
</tbody> 
</table>
<center>
<button onclick="location.href='TeacherinfoSvl'" class="button white">返回</button>
</center>
</body>


</html>

<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

<style type="text/css">
td {
 text-align: center;
}
table.altrowstable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}
table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.oddrowcolor{
	background-color:#d4e3e5;
}
.evenrowcolor{
	background-color:#c3dde0;
}
</style>

 
  
 <body>
 <center>
 <table>
 <tr>
  <td>
   <form action="<%=basePath%>CheckCourseSvl" method="post">
  <input type="text" name="no"  /><button  type="submit" class="easyui-linkbutton" >查询教师信息</button>
    <a href="<%=basePath%>AddCourseSvl" class="easyui-linkbutton">增加教师账户</a>  
    </form>
  </td>
  </table>
  </center>
 <table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
         <th data-options="field:' '">操作</th>  
            <th data-options="field:'no'">课程编号</th>            
            <th data-options="field:'name'">课程名称</th>  
       
        </tr>   
    </thead>   

<tbody id="qwe">  



</tbody> 
    </table>
 </body> 
 <script type="text/javascript">
    $(function  (){
        var url = "<%=basePath%>CourseinfoSvl";
        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            timeout: 1000,
            success: function(data){
        appendHTML(data);
        }
       });
    });
       function appendHTML(data){
  
       var html="";     
       $.each(data, function(i,cour){
    html+="<tr>";
       html += "<td><a href='#'>编辑</a>&nbsp;&nbsp;<a href=''>删除</a></td>";
       html += "<td>" + cour.cno + "</td>";
			html += "<td>" + cour.cname + "</td>";		
			 html+="</tr>";
      });  
      $("#qwer").append(html);
  
    }
    
    
</script>
</html>

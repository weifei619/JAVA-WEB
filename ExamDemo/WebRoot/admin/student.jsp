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
<link rel="stylesheet" type="text/css" href="css/my.css">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  
 <body>
 <center>
 <table>
 <td>
  <form action="<%=basePath%>CheckstudentSvl" method="post">
  <input type="text" name="no"  /><button  type="submit" class="button white" >查询学生信息</button>
    <a href="<%=basePath%>AddstudentSvl" class="button white">增加学生账户</a>  
    </form>
  </td>
  </table>
  </center>
 <table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
         <th data-options="field:' '">操作</th>  
            <th data-options="field:'sno'">学号</th>   
            <th data-options="field:'classno'">班级编号</th>   
            <th data-options="field:'name'">姓名</th>   
             <th data-options="field:'sex'">性别</th>   
            <th data-options="field:'age'">年龄</th>   
            <th data-options="field:'tel'">联系方式</th> 
             <th data-options="field:'email'">邮箱</th>   
            <th data-options="field:'address'">地址</th>   
            <th data-options="field:'school'">学校</th> 
             <th data-options="field:'class'">年级</th>   
           
        </tr>   
    </thead>   

<tbody >  
</tbody> 
    </table>
    	<table id="tblTurnPage" cellSpacing="0" cellPadding="1"
								width="100%" border="0"
								style="font-family:arial;color:black;font-size:12px;">
								<tr>
									<td>总记录数：${RecordAllCount}</td>
									<td>总页数：${PageAllCount}</td>
									<td>当前页：${CurrentPageNo}</td>
									<td><a
										href="StudentinfoSvl?page=1">首页|</a>
										<a
										href="StudentinfoSvl?page=${CurrentPageNo-1}">《前页|</a>
										<a
										href="StudentinfoSvl?page=${CurrentPageNo+1}">后页》|</a>
										<a
										href="StudentinfoSvl?page=${PageAllCount}">末页</a>
									</td>
									<form action="StudentinfoSvl" method="get">
									<td>跳转到:第<input type="text" size="3" name="page">页
									<input type="submit" value="go" class="button white" ></td></form>
								</tr>
							</table>
 </body>
 <script type="text/javascript">
 
    $(function  (){
        var url = "<%=basePath%>StudentinfoSvl";
        $.ajax({
            type: "post",
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
       $.each(data, function(i,s){
    html+="<tr>";
       html += "<td><a href='EditstudentSvl?sno="+s.sno+"' class='button white' >编辑</a><a href='RemoveStudentSvl?sno="+s.sno+"' class='button red'>删除</a></td>";
       html += "<td>" + s.sno + "</td>";
           html += "<td>" + s.classno + "</td>";
			html += "<td>" + s.sname + "</td>";
			html += "<td>" + s.sgender + "</td>";
			html += "<td>" + s.sage + "</td>";
			html += "<td>" + s.scontact + "</td>";
			html += "<td>" + s.semail + "</td>";
			html += "<td>" + s.saddress + "</td>";
			html += "<td>" + s.sschool + "</td>";
			html += "<td>" + s.sgrade + "</td>";		
			 html+="</tr>";
      });  
      $("#qwer").append(html);
  
    }
    
    
</script>
</html>

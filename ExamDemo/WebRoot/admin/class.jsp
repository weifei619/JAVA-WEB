<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
 <center>
 <table>
  <tr>
  <td>
  <form action="<%=basePath%>CheckClassSvl" method="post">
  <input type="text" name="no"  /><button  type="submit" class="button white" >查询班级信息</button>
    <a href="<%=basePath%>AddClassSvl" class="button white">增加班级</a>  
    </form>
    </td>
  </tr>
  </table>
  </center>
 <table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
         <th data-options="field:' '">操作</th>  
            <th data-options="field:'no'">班级编号</th>            
            <th data-options="field:'name'">班级名称</th>  
             <th data-options="field:'isgraduate'">是否毕业</th> 
           
        </tr>   
    </thead>   

<tbody id="qwe">  



</tbody> 
    </table>
 </body> 
 <script type="text/javascript">
    $(function  (){
        var url = "<%=basePath%>ClassinfoSvl";
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
       $.each(data, function(i,c){
    html+="<tr>";
       html += "<td><a href='EditClassSvl?classno="+c.classno+"'class='button white'>编辑</a></td>";
       html += "<td>" + c.classno + "</td>";
			html += "<td>" + c.classname + "</td>";
			html += "<td>" + c.isgraduate + "</td>";		
			 html+="</tr>";
      });  
      $("#qwer").append(html);
  
    }
    
    
</script>
</html>

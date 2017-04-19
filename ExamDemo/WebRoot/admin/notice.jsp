<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公告信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/my.css">
  </head>
  
  <body>
 <center>
 <table>
 <td>
  <form action="<%=basePath%>ChecknoticeSvl" method="post">
					<table>
						<tr>
							<td align=left>日期</td>
							<td><input class="easyui-datebox" name="beginDate"
								value="${beginDate}"></td>
							<td align=left>-------</td>
							<td><input class="easyui-datebox" name="endDate"
								value="${endDate}"></td>
						</tr>
					</table>
				
<button  type="submit" class="button white" >查询公告信息</button>
 <a href="<%=basePath%>NoticeaddSvl" class="button white">添加公告信息</a>  
 
    </form>
  </td>
  </table>
  </center>
  
<table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
         <th >操作</th>  
            <th >公告编号</th>   
            <th >发布者编号</th>   
            <th >公告内容</th>   
             <th>发布日期</th>   
           
        </tr>   
    </thead>   

<tbody >  
	</tr>

					<c:forEach var="n" items="${notice}">
						<tr>
						<td><a href=" EditnoticeSvl?nid=${n.nid}" class="button white">编辑</a><a href="RemovenoticeSvl?nid=${n.nid}"  class="button red">删除</a></td>
							<td>${n.nid}</td>
							<td>${n.acc_id}</td>
							<td>${n.ncont}</td>
							<td>${n.time}</td>
						
						</tr>

					</c:forEach>
					<tr>



</tbody> 
    </table>
    	
 </body>

</html>

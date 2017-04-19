<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询试题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
     <link rel="stylesheet" type="text/css"  href="css/my.css" >
  </head>

  
<body>
  
 <center>
 <form action="<%=basePath%>CheckexamplanSvl" method="post">
 <table>
 <tr>
  <td>
 </td>
 <td>
 <input type="text" name="examid" value="请输入考试编号"></input>
 <button type="submit" class="button white" >查询</button>
  </td>
  </tr>
  </table>
  </form>
  </center>
 
<table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
         <th>试卷编号</th> 
         <th>考试编号</th>
         <th>考试名称</th>  
         <th>考试类型</th>  
         <th>考试时间</th> 
          <th>是否阅卷</th> 
          <th>考试状态</th>     
           <th>操作</th>
        </tr>   
    </thead>   
    <c:forEach items="${exam}" var="e">
			<tr>

				<td>${e.pid}</td>
				<td>${e.examid}</td>
				<td>${e.examtitle}</td>		
				 <td><c:if test="${e.examtype==1}">
					开卷
				</c:if> <c:if test="${e.examtype==2}">
					闭卷
				</c:if></td>	
				<td>${e.stime}至${e.etime}</td>
                  <td><c:if test="${e.ischeck==1}">
						已阅
				</c:if> <c:if test="${e.ischeck==2}">
						未阅
				</c:if></td>
               <td><c:if test="${e.examstate==1}">
						未考
				</c:if> <c:if test="${e.examstate==2}">
						考试中
				</c:if>
				<c:if test="${e.examstate==3}">
						已考完
				</c:if></td>
					<td><a href="<%=basePath%>EditplanSvl?examid=${e.examid}&pid=${e.pid}" class="button white">编辑</a>
					    <a href="<%=basePath%>RemoveplanSvl?examid=${e.examid}" class="button red">删除</a>
					</td>
			
			</tr>
		</c:forEach>

    </table>

 </body>
 
</html>

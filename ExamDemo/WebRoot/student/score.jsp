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
    
    <title>My JSP 'testinfo.jsp' starting page</title>
    
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
   <form action="<%=basePath%>student/CheckScoreSvl" method="post">
 <table>
 <tr>
  <td> 
 <font color="#33ccff"><strong>试卷ID：</strong></font>
		<select name="pid"> 
		<c:forEach items="${ts}" var="t">
				<option  value="${t.examid}">${t.examtitle}</option>
		    </c:forEach>
		    </select>

<br>

 </td>
 <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 <td>
 

 <button type="submit" class="button white" >查询</button>
  
  </td>
  </tr>
  </table>
  </form>
  </center>
  
  
  
    <table class="altrowstable" width="100%" id="qwer" >   
    <thead>   
        <tr>   
           
         <th><font color="#33ccff" size=2;><strong >试卷ID</strong></font></th>              
          <th><font color="#33ccff" size=2;><strong >成绩总分</strong></font></th>
         
        </tr>   
    </thead>   
    <c:forEach items="${ts}" var="p">
			<tr>
                
				<td>${p.answerid}</td>
                            
                <td>${p.score}</td>
           
			
			</tr>
		</c:forEach>
    </table>
  
    
  </body>
  
</html>

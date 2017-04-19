<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
   <link rel="stylesheet" type="text/css" href="<%=basePath%>css/easyui.css">
      <link rel="stylesheet" type="text/css" href="<%=basePath%>css/my.css">

	
</head>

<body>
<form action="<%=basePath%>ExamplanSvl" method="post">
<table class="altrowstable" width="100%" >
   
   
    <tr>
    <td>试卷：</td>
    <td><select style="width:200"  name="epid" >
	<option value="0">--请选择--</option>
		<c:forEach items="${tp}" var="p">
				<option value="${p.pid}"> ${p.ptitle}</option>
		    </c:forEach> 
		    </select>
		    </td>	
    </tr>

						<tr>
							<td align=left>考试时间</td>
							<td><input class="easyui-datetimebox" name="begintime"
								value="${beginDate}">
							-------<input class="easyui-datetimebox" name="endtime"
								value="${endDate}"></td>
						</tr>
				 
     <tr>
    <td width="10%" >考试名称:</td>
        <td><input type="text"  style="height: 30px; width: 200px" name="ename" /></td>
    </tr>
     <tr>
      <td >考试类型：</td>
       <td><label>开卷&nbsp;<input type="radio"  name="etype"value="1" id="etype" />&nbsp;&nbsp;&nbsp;
        闭卷&nbsp;<input type="radio"  name="etype" id="etype" value="2"  /></label>
        </td>
    </tr>
    <tr>
    <td width="10%"  >是否阅卷完毕:</td>
        <td><label>完成&nbsp;<input type="radio"  name="eyue" id="eyue"  value="1"/>&nbsp;&nbsp;&nbsp;
        未完成&nbsp;<input type="radio" name="eyue" id="eyue" value="2"/></label>
        </td>
    </tr>
    <tr>
    <td width="10%"  >考试状态:</td>
        <td><label>&nbsp;&nbsp;已考&nbsp;<input type="radio" name="econ" id="econ" value="1"/>&nbsp;&nbsp;&nbsp;
        未考&nbsp;<input type="radio" name="econ" id="econ" value="2"/></label>
        </td>
    </tr>
    
    <tr>
        <td>操作</td>
        <td>
  <button type="submit"  class="button white" >提交</button><a href=javascript:history.back(); class="button white">返回</a>
        </td>
    </tr>
</table>
</form>

</body>
</html>

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
    
    <title>添加试题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

     <link rel="stylesheet" type="text/css"  href="css/my.css" >  
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	
  </head>
  
  <body>

  <table class="altrowstable" width="100%">
   <form action="<%=basePath%>teacher/EdittestSvl" method="post" class="definewidth m20" >
<td><select id="S1" name="course">
<option>请输入课程</option>
    </select>
   </td> <td><select id="S2" name="kid">
    <option>请输入知识点</option>
    </select>
    </td><td><select id="S3" name="qtid">
    <option>请输入题型</option>
    </select>
</td>
<td>
 <button type="submit" class="button white" >查询题目</button>
 </td>
 <td>
  <button type="button"  onclick="location.href='PaperinfoSvl?ptitle=${ptitle}'" class="button white" >试卷详情</button>
 <a href=javascript:history.back(); class="button white">返回</a>
    </td>
   </form>
    
		
			<tr>
				<th>试题编号：</th>			
				<th>试题内容：</th>
				<th>试题分数：</th>
				<th>试题序号：</th>
				<th>添加</th>
			</tr>
		

<c:forEach items="${question}" var="c"  >
			<tr>
				
				<td><input type="hidden" name="qid" value="${c.qid}"> ${c.qid}</td>
				
				<td>${c.qcont}</td>
				
              <td><input type="text" name="score"  placeholder="分数" id="score${c.qid}"/></td>
	           <td><input type="text" name="tpt"  placeholder="试题序号" id="ti${c.qid}"/></td>       	
				<td><button type="submit" class="button white" id="addnew" onclick="add(${c.qid})">添加</button></td>	
			
			</tr>
		</c:forEach>

	</table>
    
    

    
    
    
  </body>
  <script>
  $(function () {
            select1();
            $("#S1").bind("change", select2);
            $("#S1").bind("change", select3);
        });
        
  function select1() {
            $.ajax(
            {
                type: "post",
                url: "<%=basePath%>SelectSvl",
                dataType:"json", 
                success: function (msg) {
                   var html="";     
              $.each(msg, function(i,c){
          html+="<option value=" +c.cno+ ">" + c.cname + "</option>";
                    
                });
                $("#S1").append(html);
                
                }
            });
        };
        
        
         function select2() {     
         $("#S2").html("");
            $.ajax(
            {
                type: "post",
                url: "<%=basePath%>SelectSvl2",
                    dataType:"json",
                data:"cno="+$("#S1").val(),
                success: function (msg) {
                            var html="";     
          $.each(msg, function(i,k){
         html+="<option value=" +k.kid+ ">" +k.kname + "</option>";              
                });
                $("#S2").append(html);
                }
            });
        };
        
        
        function select3() {
            $("#S3").html("");
            $.ajax(
            {
                type: "post",
                url: "<%=basePath%>SelectSvl3",
                dataType:"json",
                success: function (msg) {
                               var html="";     
          $.each(msg, function(i,tq){
         html+="<option value="+tq.qtid + ">" + tq.qtname + "</option>";              
                });
                $("#S3").append(html);
                }
            });
            };
            
            
     function add(msg){ 
	    
	    	var s1="score"+msg;
	    	var cid=msg;
	    	var t1="ti"+msg;
	    
	   
        var s=$("#"+s1).val();
        var t=$("#"+t1).val();

     
            
             var urll="<%=basePath%>teacher/AddpaperSvl?score="+s+"&ti="+t+"&cid="+cid;
            
            
               $.ajax({
                type: "post",
                url: urll,
                success: function(data){  
                  alert("添加成功！");
                   
                }
             }) ;
            
         } ;
       
          </script>
</html>

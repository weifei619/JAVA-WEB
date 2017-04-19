<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>试卷</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css"  href="css/my.css" >
<style>

			h1{
				text-align: center;
			}
			.main{
				
				width: 770px;
				
			}
			.sp1{
				margin-left: 20px;
			}
			.txt1{
				width: 20px;
				height: 20px;
				text-align: center;
				font-size: 17px;
				border: none;
			}
			.txt2{
				width: 100px;
				height: 20px;
				font-size: 17px;
				text-align: center;
				border: none;
			}
			.txt3{
				width: 765px;
				height: 200px;
				font-size: 15px;
				border: none;
			}
			
		</style>
    <script LANGUAGE="JavaScript">  
 var maxtime = 30*1//半个小时，按秒计算，自己调整!  
 function CountDown(){  
 if(maxtime>=0){  
 minutes = Math.floor(maxtime/60);  
 seconds = Math.floor(maxtime%60);  
 msg = "距离考试结束还有"+minutes+"分"+seconds+"秒";  
 document.all["timer"].innerHTML=msg;  
 if(maxtime == 5*60) alert('注意，还有5分钟!');  
 --maxtime;  
 }  
 else{  
 clearInterval(timer);  
 alert("时间到，请提交试卷");  
 
 document.forms[0].submit();
 }  
 }  
 timer = setInterval("CountDown()",1000);   
 </script>

</head>

<body>
<div id="timer" style="color:red"></div>  
	<div class="box">
		<h1>${choice.ptitle}</h1>
		<form action="<%=basePath%>student/ExamSvl" method="POST">
			<div class="main">
				<h3>一、选择题</h3>
				<c:forEach items="${choices}" var="choice" >
				    
					<span> ${choice.seq}、 ${choice.qcont}</span>
					<br />
					<br />
					<lable>
					<span class="sp1"><input type="radio" name="${choice.qid}" value="1" id="xz${choice.seq}" />A</span>
					<span class="sp1"><input type="radio" name="${choice.qid}" value="2" id="xz${choice.seq}"/>B</span>
					<span class="sp1"><input type="radio" name="${choice.qid}" value="3" id="xz${choice.seq}"/>C</span>
					<span class="sp1"><input type="radio" name="${choice.qid}" value="4" id="xz${choice.seq}" />D</span>
					</lable>
					<br />
					<br />
					
				</c:forEach>

				<h3>二、填空题</h3>
				<c:forEach items="${completions}" var="completion" >
					<span>${completion.seq}、 ${completion.qcont} </span>
					<input type="text" name="${completion.qid}" class="abc input-default" placeholder="输入答案" />
					</span>
					<br />
					<br />
				</c:forEach>

				<h3>三、判断题（正确的写T、错误的写F）</h3>
				<c:forEach items="${judges}" var="judge" >
					<span>${judge.seq}、 ${judge.qcont}（<input type="text"
						class="txt1" name="${judge.qid}" />）</span>
					<br />
					<br />
				</c:forEach>

				<h3>四、简答题</h3>
				<c:forEach items="${answers}" var="answer" >
					<span>${answer.seq}、 ${answer.qcont}</span>
					<br>
					<input name="${answer.qid}" class="tableleft"
						style="height: 93px; width: 546px" />

				</c:forEach>
				<h3>五、应用题</h3>
				<c:forEach items="${applications}" var="application">
					<span>${application.seq}、 ${application.qcont}</span>
					<br>
					<textarea class="txt3" name="${application.qid}"></textarea>
					<br />
				</c:forEach>
			</div>

			<center><input type="submit" class="button white"  value="交卷" /></center>
		</form>
	</div>

</body>

</html>

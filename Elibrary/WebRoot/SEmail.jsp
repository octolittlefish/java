<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SEmail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	var i= 2;
	intervalid = setInterval("fun()",1000);
	function fun(){
		if(i==1){
			setTimeout("window.location.href='exceed.jsp'",1000);
		}
		document.getElementById("mes").innerHTML = i;
		i--;
	}
</script>
</head>

<body>
	<p>邮件发送成功,将在 <span id="mes">3</span> 秒钟后返回之前页面！</p> 
	<br>
</body>
</html>

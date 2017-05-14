<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script language="javascript" type="text/javascript">
	var i= 2;
	intervalid = setInterval("fun()",1000);
	function fun(){
		if(i==1){
			setTimeout("window.location.href='Nuer.jsp'",1000);
		}
		document.getElementById("mes").innerHTML = i;
		i--;
	}
</script>

</head>
  
  <body>
   <p>Error,please check your input, it will return after<span id="mes">3</span> seconds</p> 
	<br>
  </body>
</html>

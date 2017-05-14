<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>advertise</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="stylesheet" href="css/reset.css" media="screen" />
<link rel="stylesheet" href="css/Adstyle.css" media="screen" />
<link rel="stylesheet" href="css/css3_3d.css" media="screen" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/modernizr.js"></script>
</head>
<script>
	if (!Modernizr.csstransforms) {
		$(document).ready(function() {
			$(".close").text("Back to top");
		});
	}
</script>

</head>

<body onload="fun()">

	<div id="container">
		<!--[if lte IE 8]>
<noscript>
<style>
    #information li { overflow: visible; position: relative; margin: 0 auto; margin-bottom: 25px; background: #fff; width: 600px; padding: 30px; height: auto; list-style: none; }	
    #information li div a.close { position: relative; background: transparent; padding: 0; color: #0090e2; font-size: 12px; font-weight: normal; left: 0; top: 0; }	
    iframe, .backface { display: none; }

</style>
</noscript>
<![endif]-->
		<form action="ImageServlet" method="post"
			enctype="multipart/form-data">
			please choice the Advertise(notice:The name of the picture and the existing does not repeat):<input type="file" name="fileName" /><input type="submit"
				value="submit" />
		</form>
		<div style="text-align:center;clear:both">
			<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
			<script src="/follow.js" type="text/javascript"></script>
		</div>
		<script src="/adsense.js" type="text/javascript"></script>
		<ul id="grid" class="group">
		</ul>
	</div>
	<script type="text/javascript">
		function fun() {
			$.ajax({
				url : "http://127.0.0.1:8080/Elibrary/LoadServlet",
				type : "post",
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					//var str = JSON.stringify(data);
					//alert(eval(data).length);
					display(data);
				}
			});
		}
		function display(data) {
			data = eval(data);
			for (var i = 0; i < data.length; i++) {
				var s = "<li><div class=\"details\"><h3>"+data[i].name+"</h3><a class=\"more\" href=\"DeleteImageServlet?name="+data[i].name+"\" onclick=\"return del()\">Delete</a></div> <a class=\"more\" href=\"#info1\"><img src=\"images/"+data[i].name+"\" width=\"280px\" height=\"280px\"/></a></li>";
				document.getElementById("grid").innerHTML += s;
			}
		}
		function del() {
			if (!confirm("Sure to delete？")) {
				window.event.returnValue = false;
			}
		}
	</script>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'deleteUser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="assets/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="assets/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">

<script src="assets/js/chart-master/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript">

	var method;
	function choice(obj) {
		if (obj == document.getElementById("readerId")) {
			document.getElementById("method").innerHTML = "readerId<span class='caret'></span>";
			method = "readerId";
		} else if (obj == document.getElementById("idCard")) {
			document.getElementById("method").innerHTML = "idCard<span class='caret'></span>";
			method = "idCard";
		} else if (obj == document.getElementById("readerPhone")) {
			document.getElementById("method").innerHTML = "readerPhone<span class='caret'></span>";
			method = "readerPhone";
		}
	}
	function search() {
		var input = document.getElementById("input").value;
		if (input == "") {
			var table = document.getElementById("result");
			var s="<thead><tr><th>readerId</th><th>idCard</th><th>readerName</th><th>readerPhone</th><th>Email</th><th>currentNumber</th><th>operator</th></tr></thead>"
			table.innerHTML=s;
			fun();
		}
		//alert(input);
		//alert(method);
		$.ajax({
			url : "http://127.0.0.1:8080/Elibrary/SearchUserServlet?input=" + input + "&method=" + method,
			type : "get",
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				//var str = JSON.stringify(data);
				//alert(eval(data).length);
				var table = document.getElementById("result");
				var s="<thead><tr><th>readerId</th><th>idCard</th><th>readerName</th><th>Email</th><th>readerPhone</th><th>currentNumber</th><th>operator</th></tr></thead>"
				table.innerHTML=s;
				display(data);
			}
		});
	}
</script>
</head>
<body onload="fun()">

	<section id="main-content"> <section class="wrapper">

	<div class="col-sm-9 col-md-10 main">
		<!-- A row for searching books-->
		<div class="row">
			<div class="col-sm-5 col-md-5 input-group">
				<div class="input-group-btn">
					<button id="method" type="button"
						class="btn btn-default dropdown-toggle" data-toggle="dropdown">
						Search by...<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a id="readerId" onclick="choice(this)">readerId</a></li>
						<li><a id="idCard" onclick="choice(this)">idCard</a></li>
						<li><a id="readerPhone" onclick="choice(this)">readerPhone</a>
						</li>
					</ul>
				</div>
				<!-- /btn-group -->
				<input id="input" type="text" class="form-control"> <span
					class="input-group-btn">
					<button class="btn btn-default" type="button" onclick="search()">Search</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
		<!--End of row-->

		<div class="table-responsive">
			<table class="table" id="result">
				<thead>
					<tr>
						<th>readerId</th>
						<th>idCard</th>
						<th>readerName</th>
						<th>readerPhone</th>
						<th>Email</th>
						<th>operator</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<!--End of main--></section> <!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script> <script
		src="assets/js/jquery-1.8.3.min.js"></script> <script
		src="assets/js/bootstrap.min.js"></script> <script class="include"
		type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script> <script
		src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/js/jquery.sparkline.js"></script> <!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script> <script
		type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="assets/js/gritter-conf.js"></script>

	<!--script for this page--> <script src="assets/js/sparkline-chart.js"></script>
	<script src="assets/js/zabuto_calendar.js"></script>
	<script type="application/javascript">
		$(document).ready(function() {
			$("#date-popover").popover({
				html : true,
				trigger : "manual"
			});
			$("#date-popover").hide();
			$("#date-popover").click(function(e) {
				$(this).hide();
			});
	
			$("#my-calendar").zabuto_calendar({
				action : function() {
					return myDateFunction(this.id, false);
				},
				action_nav : function() {
					return myNavFunction(this.id);
				},
				ajax : {
					url : "show_data.php?action=1",
					modal : true
				},
				legend : [
					{
						type : "text",
						label : "Special event",
						badge : "00"
					},
					{
						type : "block",
						label : "Regular event",
					}
				]
			});
		});
	
		function myNavFunction(id) {
			$("#date-popover").hide();
			var nav = $("#" + id).data("navigation");
			var to = $("#" + id).data("to");
			console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
		}
		function fun() {
			$.ajax({
				type : "post",
				url : "http://127.0.0.1:8080/Elibrary/UserMessageServlet",
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
				var s = "<thead><tr><td>" + data[i].readerId + "</td><td>" + data[i].idCard + "</td><td>" +
					data[i].readerName + "</td><td>" + data[i].readerPhone + "</td><td>"+data[i].email+"</td><td><a href=\"DeleteServlet?readerId=" + data[i].readerId + "\" onclick=\"return del()\">" + "<button type=\"button\" class=\"btn btn-danger\">Delete</button></a></td></tr></thead>";
				document.getElementById("result").innerHTML += s;
			}
		}
		function del() {
			if (!confirm("确认要删除？")) {
				window.event.returnValue = false;
			}
		}
	</script>
</body>
</html>

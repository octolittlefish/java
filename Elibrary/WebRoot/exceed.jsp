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

<title>My JSP 'exceed.jsp' starting page</title>

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
	var num;
	function choice(obj) {
		if (obj == document.getElementById("today")) {
			document.getElementById("num").innerHTML = "Exceed one day<span class='caret'></span>";
			num = 1;
		} else if (obj == document.getElementById("three")) {
			document.getElementById("num").innerHTML = "Exceed less than three days<span class='caret'></span>";
			num = 3;
		} else if (obj == document.getElementById("bthree")) {
			document.getElementById("num").innerHTML = "Exceed more than three days<span class='caret'></span>";
			num = 4;
		}else if(obj == document.getElementById("both")){
			document.getElementById("num").innerHTML = "View All<span class='caret'></span>";
			num = 1000;
		}
	}
	function search() {
		if (document.getElementById("input").value == "") {
			document.getElementById("tbody").innerHTML = "";
			fun();
		} else {
			var a = document.getElementById("input").value;
			if (!IsNum(a)) {
				alert("please input legal number")
			} else {
				num = parseInt(a);
				alert(num);
				document.getElementById("tbody").innerHTML = "";
				fun();
			}
		}
	}
</script>
</head>

<body onload="fun()" style="background: #f2f2f2">
	<section id="main-content"> <section class="wrapper">

	<!-- A row for searching books-->
	<div class="row" style="margin-left: 400px;">
		<div class="col-sm-5 col-md-5 input-group">
			<div class="input-group-btn">
				<button id="num" type="button"
					class="btn btn-default dropdown-toggle" data-toggle="dropdown">
					view...<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a id="today" onclick="choice(this)">Exceed one day</a></li>
					<li><a id="three" onclick="choice(this)">Exceed less than three days</a></li>
					<li><a id="bthree" onclick="choice(this)">Exceed more than three days</a></li>
					<li><a id="both" onclick="choice(this)">View All</a></li>
				</ul>
			</div>
			<!-- /btn-group -->
			<input id="input" type="text" class="form-control" > <span class="input-group-btn">
			<button class="btn btn-default" type="button" onclick="search()">Search</button>
			</span>
		</div>
		<!-- /input-group -->
	</div>
	<!--End of row-->

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 mt">
				<div class="content-panel">
					<table class="table table-hover">
						<hr>
						<thead>
							<tr>
								<th>Column</th>
								<th>BookId</th>
								<th>ReaderId</th>
								<th>ReaderName</th>
								<th>BookName</th>
								<th>StartTime</th>
								<th>ExpectReturnTime</th>
								<th>DebtDays</th>
								<th>&nbsp;&nbsp;&nbsp;Email</th>
								<th>&nbsp;Contact</th>
							</tr>
						</thead>
						<tbody id="tbody">
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
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
	<script src="assets/js/zabuto_calendar.js"></script> <script
		type="application/javascript">
		var num = 1000;
		function fun() {
			$.ajax({
				type : "post",
				url : "http://127.0.0.1:8080/Elibrary/ExceedServlet?num=" + num,
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
				var s = "<tr><td>" + (i + 1) + "</td><td>" + data[i].BookId + "</td><td>" + data[i].ReaderId + "</td><td>" + data[i].ReaderName
					+ "</td><td>" + data[i].BookName + "</td><td>" + data[i].StartTime + "</td><td>" + data[i].ExpectReturnTime
					+ "</td><td>" + data[i].DebtDays + "</td><td>" + data[i].Email + "</td><td><a href=\"EmailServlet?email="+data[i].Email+
					"&name="+data[i].ReaderName+"&bookName="+data[i].BookName+"\"><button type=\"button\" class=\"btn btn-success\">SendEmail</button></a></td></tr>";
				document.getElementById("tbody").innerHTML += s;
			}
		}
	</script>
</body>
</html>

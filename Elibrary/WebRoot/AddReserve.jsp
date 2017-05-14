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

<title>My JSP 'AddReserve.jsp' starting page</title>

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
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


<script type="text/javascript">
	var method = null;
	var input;
	var flag = false;
	function choice(obj) {
		if (obj == document.getElementById("ISBN")) {
			document.getElementById("method").innerHTML = "ISBN<span class='caret'></span>";
			method = "ISBN";
		} else if (obj == document.getElementById("bookName")) {
			document.getElementById("method").innerHTML = "bookName<span class='caret'></span>";
			method = "bookName";
		}
	}
	function search() {
		if (document.getElementById("input").value == "") {
			alert("please input the data");
		} else {
			input = document.getElementById("input").value;
			if (method == null) {
				alert("Please select the query conditions");
			} else {
				//alert(method);
				//alert(input);
				$.ajax({
					url : "http://127.0.0.1:8080/Elibrary/AppointServlet?input=" + input + "&method=" + method,
					type : "get",
					contentType : "application/json",
					dataType : "json",
					success : function(data) {
						//var str = JSON.stringify(data);
						//alert(eval(data).length);
						document.getElementById("result").innerHTML = "";
						display(data);
					}
				});
			}
		}
	}
	function display(data) {
		data = eval(data);
		for (var i = 0; i < data.length; i++) {
			if (data[i].isAppoint == 0) {
				var s = "<tr><td>" + data[i].BookId + "</td><td>" + data[i].BookName
					+ "</td><td>" + data[i].Location +
					"</td><td><button type=\"button\" class=\"btn btn-success\" onclick=\"add('" + data[i].BookId + "');\">Can be Appoint</button></td></tr>"
					//alert(s);
			} else {
				var s = "<tr><td>" + data[i].BookId + "</td><td>" + data[i].BookName
					+ "</td><td>" + data[i].Location +
					"</td><td><button type=\"button\" class=\"btn btn-danger\">Cannot Appoint</button></td></tr>"
			}
			document.getElementById("result").innerHTML += s;
		}
	}
	function add(data) {
		//alert(data);
		document.getElementById("bookId").value = data;
	}
	function sub() {
		var bookId = document.getElementById("bookId").value;
		var readerId = document.getElementById("readerId").value;
		if (flag == false) {
			alert("对不起，请输入正确的readerId")
		} else {
			if (bookId = "") {
				alert("bookId不能为空");
			} else if (readerId == "") {
				alert("readerId不能为空");
			} else {
				$.ajax({
					url : "http://127.0.0.1:8080/Elibrary/AddAppointServlet?bookId=" + document.getElementById("bookId").value + "&readerId=" + document.getElementById("readerId").value,
					type : "post",
					contentType : "text",
					dataType : "text",
					success : function(data) {
						//alert(data);
						if (data) {
							alert("Reserve success, please view your Email in time in order not to miss time");
						}
					}
				});
			}
		}
	}

	function view(obj) {
		$.ajax({
			url : "http://127.0.0.1:8080/Elibrary/ExistServlet?readerId=" + obj.value,
			type : "post",
			contentType : "text",
			dataType : "text",
			success : function(data) {
				//alert(data);
				if (data == "success") {
					flag = true;
				} else {
					alert("Please check that if the readerId entered is correct and this readerId does not exist");
					flag = false;
				}
			}
		});
	}
</script>
</head>

<body style="background: #f2f2f2">
	<div class="container">
		<div class="row clearfix">


			<div class="col-md-6 column">
				<div class="col-sm-9 col-md-10 main">
					<h1 class="page-header">Make Appointment</h1>
					<!-- A row for searching books-->
					<div class="row">
						<div class="col-sm-5 col-md-5 input-group">
							<div class="input-group-btn">
								<button id="method" type="button"
									class="btn btn-default dropdown-toggle" data-toggle="dropdown">
									Search by...<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li><a id="ISBN" onclick="choice(this)">ISBN</a></li>
									<li><a id="bookName" onclick="choice(this)">bookName</a></li>
								</ul>
							</div>
							<!-- /btn-group -->
							<input id="input" type="text" class="form-control"
								style="width:200px;"> <span class="input-group-btn">
								<button class="btn btn-default" type="button" onclick="search()">Search</button>
							</span>
						</div>
						<!-- /input-group -->
					</div>
				</div>
				<!--End of row-->
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th>BookId</th>
								<th>BookName</th>
								<th>Location</th>
								<th>&nbsp;&nbsp;Status</th>
							</tr>
						</thead>
						<thead id="result">
						</thead>
					</table>
				</div>
			</div>

			<div class="col-md-6 column" id="appoint">
				<div class="row mt" style="margin-top: 200px;background: #f2f2f2">
					<div class="col-lg-12">
						<div class="form-panel">
							<h4 class="mb">
								<center>Add Appointment</center>
							</h4>
							<form class="form-inline" role="form">
								<div class="form-group">
									<label class="sr-only" for="exampleInputEmail2">BookId</label>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BookId:&nbsp;&nbsp;
									<input type="text" id="bookId" class="form-control"
										placeholder="please input bookId">
								</div>
								<br> <br> <br>
								<div class="form-group">
									<label class="sr-only" for="exampleInputPassword2">ReaderId</label>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ReaderId:&nbsp;
									<input type="text" class="form-control" id="readerId"
										placeholder="please input readerId" onchange="view(this)">
								</div>
								<br> <br> <br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="submit" class="btn btn-theme" onclick="sub()">
									Add Appointment</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--End of main-->
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/js/jquery.sparkline.js"></script>
	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>
	<script type="text/javascript"
		src="assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="assets/js/gritter-conf.js"></script>

	<!--script for this page-->
	<script src="assets/js/sparkline-chart.js"></script>
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
	</script>
</body>
</html>

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

<title>My JSP 'ViewReserve.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="assets/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="assets/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">
<script src="assets/js/chart-master/Chart.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body onload="fun()" style="background: #f2f2f2">
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 mt">
				<div class="content-panel">
					<table class="table table-hover">
						<hr>
						<thead>
							<tr>
								<th>BookId</th>
								<th>ReaderId</th>
								<th>AppointTime</th>
								<th>AppointLastTime</th>
								<th>Operator</th>
							</tr>
						</thead>
						<tbody id="tbody">

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- /col-md-12 -->
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
	<script type="text/javascript">
		function fun() {
			$.ajax({
				url : "http://127.0.0.1:8080/Elibrary/ReserveServlet",
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
				var s = "<tr><td>" + data[i].BookId + "</td><td>" + data[i].ReaderName + "</td><td>" +
					data[i].AppointTime + "</td><td>" + data[i].AppointLastTime +
					"</td><td><a href=\"DeleteAppointServlet?appointId=" + data[i].appointId + "\" onclick=\"return del()\">" + "<button type=\"button\" class=\"btn btn-danger\">Delete</button></a></td></tr>";
				document.getElementById("tbody").innerHTML += s;
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

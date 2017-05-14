<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="max">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>DASHGUM - FREE Bootstrap Admin Template</title>

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
</head>

<body class="max">
	<div id="sidebary">
		<ul class="sidebar-menu" id="nav-accordion">
			<p class="centered"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></p>
			<h5 class="centered">Administrator</h5>
			
			<li class="mt">
				<a class="active" href="add books.jsp" target="right"> 
				<i class="fa fa-dashboard"></i> 
				<span>Add Books</span>
				</a>
			</li>
			
			<li class="sub-menu">
				<a href="javascript:;"> 
				<i class="fa fa-desktop"></i> 
				<span>Lend Books/Return Books</span>
				</a>
				<ul class="sub">
					<li><a href="LentBook.jsp" target="right">&nbsp;&nbsp;&nbsp;Lend Books</a></li>
					<li><a href="ReturnBook.jsp" target="right">&nbsp;&nbsp;&nbsp;Return Books</a></li>
				</ul>
			</li>
			
			<li class="sub-menu">
				<a href="javascript:;">
				<i class="fa fa-cogs"></i> 
				<span>Reader Lists</span>
				</a>
				<ul class="sub">
					<li><a href="readers.jsp" target="right">&nbsp;&nbsp;&nbsp;View ReaderLists</a></li>
					<li><a href="exceed.jsp" target="right">&nbsp;&nbsp;&nbsp;View Exceed</a></li>
				</ul>
			</li>
			
			<li class="sub-menu">
				<a href="javascript:;">
				<i class="fa fa-book"></i> 
				<span>Reader Manage</span>
				</a>
				<ul class="sub">
					<li><a href="Nuer.jsp" target="right">&nbsp;&nbsp;&nbsp;Create Reader</a></li>
					<li><a href="deleteUser.jsp" target="right">&nbsp;&nbsp;&nbsp;Delete Readers</a></li>
				</ul>
			</li>
			
			<li class="sub-menu">
			<a href="javascript:;"> 
			<i class="fa fa-tasks"></i> 
			<span>Advertise</span>
			</a>
				<ul class="sub">
					<li><a href="advertise.jsp" target="right">&nbsp;&nbsp;&nbsp;Advertise Manage</a></li>
				</ul>
			</li>
			
			<li class="sub-menu">
				<a href="javascript:;"> 
				<i class="fa fa-th"></i> 
				<span>Appoint</span>
				</a>
				<ul class="sub">
					<li><a href="AddReserve.jsp" target="right">&nbsp;&nbsp;&nbsp;Add Appoint</a></li>
					<li><a href="ViewReserve.jsp" target="right">&nbsp;&nbsp;&nbsp;View Appoints</a></li>
				</ul>
			</li>
			<li class="sub-menu">
				<a href="javascript:;"> 
				<i class=" fa fa-bar-chart-o"></i> 
				<span>About US</span>
			</a>
				<ul class="sub">
					<li><a href="team.jsp" target="right">&nbsp;&nbsp;&nbsp;Team introduction</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/js/jquery.sparkline.js"></script>
	<script src="assets/js/common-scripts.js"></script>
	<script type="text/javascript"
		src="assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="assets/js/gritter-conf.js"></script>
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

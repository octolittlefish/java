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

<title>My JSP 'Nuer.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="css/buttons.css" rel="stylesheet" type="text/css">
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
   function myCheck(obj)
      {
         for(var i=0;i<document.getElementById("form1").length-1;i++)
         {
           if(document.getElementById("form1").elements[i].value=="")
          {
            alert("当前表单不能有空项");
            document.getElementById("form1").elements[i].focus();
            return false;
           }
         }
           var idCard = document.getElementById("idCard").value;
           var phone = document.getElementById("phone").value;
           var password = document.getElementById("password").value;
           var mpassword = document.getElementById("mpassword").value;
           var phone1 = /^1([38]\d|4[57]|5[0-35-9]|7[06-8]|8[89])\d{8}$/;
           var card = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i;
           var email = document.getElementById("email").value;
           if(!card.test(idCard)){
           		 alert("The format of IdCard is not correct");
           		 return false;
           }
           if(!phone1.test(phone)){
           		 alert("The format of Phone is not correct");
           		 return false;
           }
           var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
           if(!myreg.test(email)){
           		alert("The format of Email is not correct");
           		return false;
           }
           if(password!=mpassword){
           		alert("The password entered does not match, please check your input");
           		return false;
           }
          return true;
 	}
</script>
</head>

<body>
	<section id="main-content"> <section class="wrapper">
	<h1 class="page-header">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;New User</h1>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-4 column"></div>
			<div class="col-md-4 column">
			 <!-- action="RegisterServlet" -->
				<form class="form-horizontal" action="RegisterServlet" id="form1" name="form1" >
					<label>StudentID</label><br>
					<input type="text" class="form-control"	id="readerID" name="readerID"> <br>
					<label>IdCard</label><br>
					<input type="text" class="form-control" id="idCard" name="idCard"> <br>
					<label>Username</label> <br>
					<input type="text" class="form-control" id="name" name="name"><br>
					<label>Telephone</label> <br>
					<input type="text" class="form-control" id="phone" name="phone"> <br>
					<label>Email</label> <br>
					<input type="text" class="form-control" id="email" name="email"> <br>
					<label>Password</label> <br>
					<input type="password" class="form-control" id="password" name="password"> <br>
					<label>ConfirmPassword</label> <br>
					<input type="password" class="form-control" id="mpassword" name="mpassword"><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-theme" type="submit" id="register_button" onclick="return myCheck(this)">
					Register
					</button>
				</form>
			</div>
			<div class="col-md-4 column"></div>
		</div>
	</div>
	</section> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/js/jquery.sparkline.js"></script>
	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>
	<script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
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
</html>

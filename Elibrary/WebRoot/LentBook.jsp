<%@ page language="java"
	import="java.util.*,javabean.Catalog,java.text.DateFormat,java.text.SimpleDateFormat"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
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
var imageURL = "";
	window.onload=function(){
		
		var bookid='<%=request.getParameter("bookid")%>';
		if(bookid!="null"){
		document.getElementById("bookID").value=bookid;
		setBookDetail();
		}
	}
	function setUserRecords() {
		$.ajax({
			url : "http://127.0.0.1:8080//Elibrary/GetUserRecord?readerid=" +
				document.getElementById("userID").value,
			type : 'get',
			dataType : "json",
			success : function(data) {
				if (data.isBack != "") {
					alert(data.isBack);
					var readerids = data.readerids.split("^");
					var isBack = data.isBack.split("^");
					var debtDays = data.debtDays.split("^");
					var bookids = data.bookids.split("^");
					var author = data.author.split("^");
					var isbn = data.isbn.split("^");
					var startTime = data.startTime.split("^");
					var endTime = data.endTime.split("^");
					var isLost = data.isLost.split("^");
					var debt = data.debt.split("^");
					var bookName = data.bookName.split("^");
					var expectDate = data.expectDate.split("^");
					var books = document.getElementById("booksTable");
					
					var rowNum = books.rows.length;
					for (var i = 0; i < rowNum; i++) {
						books.deleteRow(i);
						rowNum = rowNum - 1;
						i = i - 1;
					}
					
					var p = 2;

					for (var i = 0; i < Math.ceil(isbn.length / 2); i++) {
						if (i == Math.ceil(isbn.length / 2) - 1)
							p = 1;
						var row = books.insertRow();
						for (var j = 0; j < p; j++) {
							var cell1 = row.insertCell();
							var imageURL = "";
							$.ajax({
								url : "https://api.douban.com/v2/book/isbn/" + isbn[2 * i + j],
								type : 'get',
								dataType : "jsonp",
								success : function(data) {
									imageURL = data.images.small;
									cell1.innerHTML = "<img style='margin:20px' src='" + imageURL + "'/>";
								},
								error : function(data) {
									alert("服务端异常！");
								}
							});

							var cell2 = row.insertCell();
							cell2.innerHTML = "Title:" + decodeURI(bookName[2 * i + j]) + "<br>"
								+ "Author:" + decodeURI(author[2 * i + j]) + "<br>"
								+ "ISBN:" + isbn[2 * i + j] + "<br>"
								+ "StartDate:" + startTime[2 * i + j] + "<br>"
								+ "ExpectDate:" + expectDate[2 * i + j] + "<br>"
								+ "BootID:" + bookids[2 * i + j] + "<br>"
								+ "DebtDays:" + debtDays[2 * i + j] + "<br>"

						}
					}
				}
			//alert("Book Detail Got");
			//$('#title').val(data.title);
			//$('#author').val(data.author);
			//$('#pubyear').val(data.pubdate);
			//$('#publisher').val(data.publisher);
			//$('#price').val(data.price);
			document.getElementById("bookCache").style.display = "block";
			document.getElementById("userinfo").style.display = "block";
			document.getElementById("useridin").style.marginTop = "0px";
			document.getElementById("useridin").style.marginBottom = "0px";
			},
			error : function(data) {
				alert("服务端异常！");
			}
		});
	}
		function setReaderInfo() {
		$.ajax({
			url : "http://127.0.0.1:8080//Elibrary/GetReader?readerid=" + document.getElementById("userID").value,
			type : 'get',
			dataType : "json",
			success : function(data) {
				if(data.exist=="1"){
					document.getElementById("readername").innerHTML=data.readername;
					setUserRecords();
				}else {
					alert("No such reader.");
					document.getElementById("bookCache").style.display = "none";
					document.getElementById("userinfo").style.display = "none";
					document.getElementById("useridin").style.marginTop = "50px";
					document.getElementById("useridin").style.marginBottom = "50px";
				}
			},
			error : function(data) {
				alert("服务端异常！");
			}
		});
	}
	function setBookDetail() {
		$.ajax({
			url : "http://127.0.0.1:8080//Elibrary/GetBookDetail?bookid='" + document.getElementById("bookID").value + "'",
			type : 'get',
			dataType : "json",
			success : function(data) {
				if (data.exist == "1") {
					$.ajax({
						url : "https://api.douban.com/v2/book/isbn/" + data.ISBN,
						type : 'get',
						dataType : "jsonp",
						success : function(data) {
							imageURL = data.images.small;
							document.getElementById("bookImg").innerHTML="<img src=\""+imageURL+"\" style=\"margin:10px\">";
						},
						error : function(data) {
							alert("服务端异常！1");
						}
					});
					var table = document.getElementById("bookTable");
					document.getElementById("title").innerHTML = decodeURI(data.bookName);
					document.getElementById("bookidshow").innerHTML = data.bookId;
					document.getElementById("authorshow").innerHTML = decodeURI(data.author);
					document.getElementById("publisher").innerHTML = decodeURI(data.publisher);
					document.getElementById("isbnshow").innerHTML = data.ISBN;
					document.getElementById("deposit").innerHTML = data.bookPrice;
					document.getElementById("bookdetail").style.display = "block";
					document.getElementById("bookblock").style.marginTop = "0px";
					document.getElementById("bookblock").style.marginBottom = "0px";
				} else if(data.exist == "2"){
					alert("This book is not aviliable for now.")
					document.getElementById("bookdetail").style.display = "none";
					document.getElementById("bookblock").style.marginTop = "50px";
					document.getElementById("bookblock").style.marginBottom = "50px";
				} else if(data.exist == "0"){
					alert("Server error!")
					document.getElementById("bookdetail").style.display = "none";
					document.getElementById("bookblock").style.marginTop = "50px";
					document.getElementById("bookblock").style.marginBottom = "50px";
				}
				
			},
			error : function(data) {
				alert("服务端异常！");
			}
		});
	}
	function lent() {
		if(document.getElementById("userID").value==""){
			alert("Please enter userID.");
		}else if(document.getElementById("bookID").value==""){
			alert("Please enter bookID.");
		}else {
			if (confirm("This will deduct ￥"+document.getElementById("deposit").innerHTML+"from your account as deposit.")) {
				$.ajax({
				url : "http://127.0.0.1:8080//Elibrary/LentBook?readerid=" + document.getElementById("userID").value
					+ "&bookid=" + document.getElementById("bookID").value + "&total=" + document.getElementById("deposit").innerHTML,
				type : 'get',
				dataType : "json",
				success : function(data) {
					if (data.exist=="1") {
						alert("Lent success!")
						document.getElementById("bookdetail").style.display = "none";
						document.getElementById("bookblock").style.marginTop = "50px";
						document.getElementById("bookblock").style.marginBottom = "50px";
					}
					else if(data.exist=="0"){
						alert("Failed to lent, please check your infomation.");
					}else if(data.exist=="2"){
						alert("This book has been borrowed.");
					}
				},
				error : function(data) {
					alert("服务端异常！");
				}
				});
			}
		}
	}

	function useridget() {
		setReaderInfo();
	}
	function bookidget(obj) {
		setBookDetail();
	}
</script>
</head>

<body>

	<section id="main-content"> <section class="wrapper">
	<div class="col-sm-9 col-md-12 main">
		<h1 style="background:#dddddd;" class="page-header">
			<br>&nbsp;&nbsp;Lent books <img
				style="height:50px;width:250px;float:right;margin:0px 100px 0px 0px"
				src="img/logo.png"> <br>
			<br>
		</h1>
		<div class="row">
			<div class="col-sm-1 col-md-1">
				
			</div>
			<div class="col-sm-9 col-md-9">
				<form class="form-horizontal"
					style="display: block;margin:100px 0px;" id="bookblock" role="form">
					<label>userID</label> <input type="text" class="form-control"
							id="userID" placeholder="userID" onchange="useridget()"><br>
					<label>bookID</label> <input type="text" class="form-control"
						id="bookID" placeholder="userID" onchange="bookidget(this)"><br>
				</form>
				<div class="panel-default" style="background:#dddddd; display:none"
					id="bookdetail">
					<div>
						<div style="float:left;margin:15px" id="bookImg">
						</div>
						<div style="float:left;margin:30px;font-size:140%">
							Title:<label id="title"></label><br>BookID:<label
								id="bookidshow"></label><br>Author:<label id="authorshow"></label>
							<br>Publisher:<label id="publisher"></label><br>ISBN:<label
								id="isbnshow"></label><br>
						</div>
						<div style="float:left;margin:0px 0px 0px 150px;font-size:140%"">
							<br>
							<br>
							<br>
							<br>
							<br>
							<br> <br>Deposit: <font color="#FF7F50">￥</font><font
								id="deposit" color="#FF7F50"></font>
						</div>
						<br>
					</div>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<hr style="border:1px solid grey">
					<span style="margin:10px"><font color="#FF8247">NOTICE:</font><label
						style="margin:10px">The Reader should return the book back
							to the library in 30 days(Before <%
						Calendar c = Calendar.getInstance();
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						c.setTime(new Date());
						c.add(Calendar.DATE, 30);
						Date d2 = c.getTime();
						String s = df.format(d2);
						out.println("<font color='#FF4500'>" + "</font>");
					%> ), Or pay a bit money for delayed days.
					</label></span>
					<div class="row">
						<div class="col-sm-offset-5 col-xs-offset-5 col-md-offset-5">
							<button type="submit" class="btn btn-success" style="margin:20px"
								onclick="lent()">Lent</button>
						</div>
					</div>
				</div>
				<br>

			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	</section> </section>

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

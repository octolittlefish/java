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
	function onScrap(obj){
		document.getElementById("reason").style.display="block";
		document.getElementById("reasonIn").value="";
		document.getElementById("rowNum").innerHTML=obj.parentElement.parentElement.rowIndex;
	}
	function onReasonCancel(){
		document.getElementById("reason").style.display="none";
		document.getElementById("reasonIn").value="";
	}
	function scrap(){
		document.getElementById("reason").style.display="none";
		var scrapTable = document.getElementById("scrapTable");
		var bookTable = document.getElementById("booksTable");	
		var row = scrapTable.insertRow();
		var num = Number(document.getElementById("rowNum").innerHTML);
		row.insertCell().innerHTML = bookTable.rows[num].cells[1].innerHTML;
		row.insertCell().innerHTML = bookTable.rows[num].cells[0].innerHTML;
		row.insertCell().innerHTML = bookTable.rows[num].cells[7].innerHTML;
		row.insertCell().innerHTML = bookTable.rows[num].cells[8].innerHTML;
		row.insertCell().innerHTML = document.getElementById("reasonIn").value;
		row.insertCell().innerHTML = "<div class='btn btn-danger' onclick='remove2(this)'>Delete</div>";
		document.getElementById("reasonIn").value="";
		bookTable.deleteRow(num);
		bookTable.deleteRow(num);
	}
	function ScrapToServer(){
		var scrapTable = document.getElementById("scrapTable");
		if(scrapTable.rows.length!=1){
		if(confirm("Sure to Scrap?")){
			for (var i = 1; i < scrapTable.rows.length; i++) {
			$.ajax({
					url : "http://127.0.0.1:8080//Elibrary/ScrapBook"
						+ "?title="
						+ encodeURI(encodeURI(scrapTable.rows[i].cells[0].innerHTML))
						+ "&bookid="
						+ encodeURI(encodeURI(scrapTable.rows[i].cells[1].innerHTML))
						+ "&readerid="
						+ encodeURI(encodeURI(scrapTable.rows[i].cells[2].innerHTML))
						+ "&price="
						+ scrapTable.rows[i].cells[3].innerHTML.split(" ")[1]
						+ "&reason="
						+ encodeURI(encodeURI(scrapTable.rows[i].cells[4].innerHTML)),
					type : 'get',
					dataType : "json",
					success : function(data) {
						alert(data.isSuccess);
						if(data.isSuccess=="1"){
							alert("success");
						}else if(data.isSuccess=="2"){
							alert("This book has been borrowed.");
						}else if(data.isSuccess=="3"){
							alert("This book has been appointed.");
						}else if(data.isSuccess=="0"){
							alert("failed");
						}
					}
				});
		}
		var rowNum = scrapTable.rows.length;
		for (var i = 1; i < rowNum; i++) {
			scrapTable.deleteRow(i);
			rowNum = rowNum - 1;
			i = i - 1;
		}
		}
					
		}else {
			alert("No book tp scrap.");
		}
		
		
	}
	
	function submit(){
		var booksTable = document.getElementById("booksTable");
		if(booksTable.rows.length!=1){
		var total_cost = 0;
		var total_refund = 0;
		for (var i = 1; i < booksTable.rows.length-1; i++){
			total_cost+=parseFloat(booksTable.rows[i+1].cells[8].innerHTML.split(" ")[2]);
			total_refund+=parseFloat(booksTable.rows[i+1].cells[9].innerHTML.split(" ")[2]);
		}
		if (confirm("Totally it will cost ￥"+total_cost+" from the deposit,and return the left part(￥"+total_refund+
		") will be back to the account.")) {
			for (var i = 1; i < booksTable.rows.length; i++) {
			$.ajax({
					url : "http://127.0.0.1:8080//Elibrary/ReturnBook"
						+ "?bookid="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[0].innerHTML))
						+ "&startdate="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[4].innerHTML))
						+ "&cost="
						+ booksTable.rows[i+1].cells[8].innerHTML.split(" ")[2]
						+ "&refund="
						+ booksTable.rows[i+1].cells[9].innerHTML.split(" ")[2]
						+ "&readerid="
						+ booksTable.rows[i].cells[7].innerHTML,
					type : 'get',
					contentType : "text;charset=UTF-8",
					dataType : "text",
					success : function(data) {
						if(data=="1"){
							alert("This book is appointed.");
						}else {
							alert("Success");
						}
					}
				});
				i++;
		}
		var rowNum = booksTable.rows.length;
		for (var i = 1; i < rowNum; i++) {
			booksTable.deleteRow(i);
			rowNum = rowNum - 1;
			i = i - 1;
		}
		}
		
		}else {
			alert("No book to return.");
		}
	}
	
	function getDetails(){
		//window.open("http://localhost:8080//Elibrary/GetReturnDetail?bookid=" +
			//	document.getElementById("bookID").value);
		$.ajax({
			url : "http://127.0.0.1:8080//Elibrary/GetReturnDetail?bookid=" +
				document.getElementById("bookID").value,
			type : 'post',
			dataType : "json",
			contentType:"application/json",
			success : function(data) {
				if(data.exist=="1"){
					var booktable = document.getElementById("booksTable");
					var titles = data.titles.split("^");
					var authors = data.authors.split("^");
					var publishers = data.publishers.split("^");
					//var prices = data.prices.split("^");
					var startdates = data.startdates.split("^");
					var expectdates = data.expectdates.split("^");
					var deposits = data.deposits.split("^");
					var costs = data.cost.split("^");
					
					var reader = data.reader.split("^");
					for(var i = 0; i < reader.length; i++){
						var row = booktable.insertRow();
						row.insertCell().innerHTML = document.getElementById("bookID").value;
						row.insertCell().innerHTML = decodeURI(titles[i]) ;
						row.insertCell().innerHTML = decodeURI(authors[i]);
						row.insertCell().innerHTML = decodeURI(publishers[i]);
						//row.insertCell().innerHTML = prices[i];
						row.insertCell().innerHTML = startdates[i];
						row.insertCell().innerHTML = expectdates[i];
						row.insertCell().innerHTML = "￥ "+deposits[i];
						//row.insertCell().innerHTML = costs[i];
						row.insertCell().innerHTML = decodeURI(reader[i]);		
						row.insertCell().innerHTML = "￥ "+costs[i]//Number(deposits[i]);
						row.insertCell().innerHTML = "<div class='btn btn-danger' onclick='onScrap(this)'>Scrap</div>";
						row.insertCell().innerHTML = "<div class='btn btn-danger' onclick='remove1(this)'>Delete</div>";
						var row1 = booktable.insertRow();
						row1.insertCell();
						row1.insertCell();
						row1.insertCell();						
						row1.insertCell();
						row1.insertCell();
						row1.insertCell();
						row1.insertCell();
						row1.insertCell().innerHTML = "Deposit ￥ "+deposits[i];
						row1.insertCell().innerHTML = "Cost ￥ "+costs[i];
						row1.insertCell().innerHTML = "Refund ￥ "+(parseFloat(deposits[i])-parseFloat(costs[i]));
					}
				}else if(data.exist=="2"){
					alert("Cannot find this book, please check the id.");
				}else if(data.exist=="3"){
					alert("This book has not been borrowed by anyone.");
				}
			},
			error : function(data,type,exception) {
				alert("Error！");
			}
		});
	}
	function remove1(obj){
		var booksTable = document.getElementById("booksTable");
		var rowNum = obj.parentElement.parentElement.rowIndex;
		booksTable.deleteRow(rowNum);
		booksTable.deleteRow(rowNum);
	}
	function remove2(obj){
		var scrapTable = document.getElementById("scrapTable");
		scrapTable.deleteRow(obj.parentElement.parentElement.rowIndex);
	}
	
</script>
<style>
#reason {
		display:none;	
		width:500px; 
	 	height: 300px;
		border: 20px solid #CCCCCC; 
		position:fixed;
		left:35%;
		top:20%;
		z-index:999;
		background-color:#CCCCCC}
</style>
</head>

<body>
<div id="reason">
	<input type="text" class="form-control" style="height:120px;margin:30px 0px 0px 0px"
							id="reasonIn" placeholder="Enter the Reason.">
	<div align="center" style="margin:50px 0px 0px 0px">
		<button class="btn btn-default" type="submit" style="margin:20px"
				style="marginLeft:auto" onclick="onReasonCancel()">Cancel</button>
		<button class="btn btn-default" type="submit" style="margin:20px"
				style="marginLeft:auto" onclick="scrap()">Scrap</button>
				<label id="rowNum" style="display:none"></label>
	</div>
	
</div>

	<section id="main-content"> <section class="wrapper">
	<div class="col-sm-1 col-md-1"></div>
	<div class="col-sm-10 col-md-8 main">
		<h1 style="background:#dddddd;" class="page-header">
			<br>&nbsp;&nbsp;&nbsp;Return books
			<img style="height:50px;width:250px;float:right;margin:0px 100px 0px 0px" src="img/logo.png"><br> <br>
		</h1>
		<div class="row">
			<div class="col-sm-6 col-md-12">
				<div class="container-form">
					<form class="form-horizontal"
						style="display: block;margin:20px 0px;" id="useridin" role="form">
						<label>Input the ID of the book.<font color="#6495ED">(The ID is on the side of the book.)</font></label> 
						<input type="text" class="form-control"
							id="bookID" placeholder="bookID" onchange="getDetails()"><br>
					</form>
					<div style="background:#6495ED;height:150px;display: none" id="userinfo"></div>
					<div style="background:#dddddd;display: block;"
						class="table-responsive" id="bookCache">
						<label style="margin:10px 10px 10px 25px">Return List</label>
					</div>
					<div style="display: block"
						class="table-responsive" id="bookCache">
						<table class="table" id="booksTable">
							<thead style="backgroun-color:#dddddd">
								<tr>
									<th>ID</th>
									<th>Title</th>
									<th>Author</th>
									<th>Publisher</th>
									<th>StartDate</th>
									<th>ExpectDate</th>
									<th>Deposit</th>
									<th>Reader</th>
									<th>Cost</th>
								</tr>
							</thead>
						</table>
					</div>
					<hr style="border:1px solid grey">
					<div style="background:#dddddd;">
					<label style="margin:10px 10px 10px 25px">Scrap List</label>
					</div>
					<div>
						<table class="table" id="scrapTable">
							<thead>
								<tr>
									<th>Title</th>
									<th>Book Id</th>
									<th>Breaker</th>		
									<th>compensation</th>
									<th>Reason</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="row">
						<div class="col-sm-offset-5 col-xs-offset-5 col-md-offset-5">
							<button type="submit" class="btn btn-success" style="margin:20px"
								onclick="submit()">Return</button>
							<button type="submit" class="btn btn-success" style="margin:20px"
								onclick="ScrapToServer()">Scrap</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="col-sm-1 col-md-3 main"></div>
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

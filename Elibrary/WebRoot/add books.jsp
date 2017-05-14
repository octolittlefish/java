<%@ page language="java" import="java.util.*,javabean.Catalog"
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
<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

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
	function search(obj) {
		$.ajax({
			url : "https://api.douban.com/v2/book/isbn/" + obj.value,
			type : "get",
			dataType : "jsonp",
			success : function(data) {
				$('#title').val(data.title);
				$('#author').val(data.author);
				$('#pubyear').val(data.pubdate);
				$('#publisher').val(data.publisher);
				$('#price').val(data.price);
			},
			error : function(data) {
				alert("Error！");
			}
		});
	}

	function checkISBN13(code) {
		code = (code + '').replace(/[-\s]/g, '');
		if (!/^\d{12,13}$/.test(code))
			return;
		var i = 1,
			c = 0; // c:checksum
		for (; i < 12; i += 2)
			c += Math.floor(code.charAt(i));
		for (c *= 3, i = 0; i < 12; i += 2)
			c += Math.floor(code.charAt(i));
		c = (220 - c) % 10; // 220:大於(1*6+3*6)，%10==0即可。
		if (code.length == 12)
			return code + c;
		return c == code.charAt(12);
	}

	function addBooksToCache() {
		var itemNum = 0;
		$.ajax({
			url : "http://127.0.0.1:8080/Elibrary/GetItemNum",
			type : "get",
			dataType : "text",
			success : function(data) {

				itemNum = Number(data);
				var isbn = document.getElementById("isbn").value;
				//!checkISBN13(isbn)
				if (false) {
					alert("ISBN disabled!");
				} else {
					if (document.getElementById("number2").value == "") {
						alert("Please input AMOUNT");
					} else {
						var booksTable = document.getElementById("booksTable");
						var newRow = booksTable.insertRow();
						var newCell1 = newRow.insertCell();
						newCell1.innerHTML = "<div class='btn btn-danger' onclick='remove1(this)'>Remove</div>";
						newRow.insertCell().innerHTML = document
							.getElementById("title").value;
						newRow.insertCell().innerHTML = document
							.getElementById("author").value;
						newRow.insertCell().innerHTML = document
							.getElementById("publisher").value;
						newRow.insertCell().innerHTML = document
							.getElementById("pubyear").value;
						newRow.insertCell().innerHTML = document.getElementById("isbn").value;
						newRow.insertCell().innerHTML = document
							.getElementById("price").value;
						var num = document
							.getElementById("number2").value;
						newRow.insertCell().innerHTML = num;
						var cata2 = document
							.getElementById("catalog2").options[document
							.getElementById("catalog2").selectedIndex].text.split(" ");
						newRow.insertCell().innerHTML = cata2[0] + "-" + isbn.substring(10, 13) + "-" + itemNum + "-" + 0;
						newRow.insertCell().innerHTML = cata2[0] + "-" + isbn.substring(10, 13) + "-" + itemNum + "-" + num;
						/*/修改待添加书的数量
						var book_num = document.getElementById("book_num").innerHTML;
						book_num = book_num / 1;
						book_num += document.getElementById("number2").value / 1;
						document.getElementById("book_num").innerHTML = book_num;

						//修改待添加项目的数量
						var item_num = document.getElementById("item_num").innerHTML;
						item_num = item_num / 1;
						item_num += 1;
						document.getElementById("item_num").innerHTML = item_num;*/
					}
				}
			},
			error : function(data) {
				alert("Error");
			}
		});


	}

	function submit() {
		if(document.getElementById("booksTable").rows.length!=1){
			var booksTable = document.getElementById("booksTable");
		for (var i = 1; i < booksTable.rows.length; i++) {
			$
				.ajax({
					url : "http://127.0.0.1:8080/Elibrary/AddBooks"
						+ "?title="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[1].innerHTML))
						+ "&author="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[2].innerHTML))
						+ "&publisher="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[3].innerHTML))
						+ "&pubyear="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[4].innerHTML))
						+ "&isbn="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[5].innerHTML))
						+ "&price="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[6].innerHTML))
						+ "&amount="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[7].innerHTML))
						+ "&idS="
						+ encodeURI(encodeURI(booksTable.rows[i].cells[8].innerHTML)),
					type : "get",
					contentType : "application/json;charset=UTF-8",
					dataType : "jsonp",
					success : function(data) {
						$('#title').val(data.title);
						$('#author').val(data.author);
						$('#pubyear').val(data.pubdate);
						$('#publisher').val(data.publisher);
						$('#isbn').val(data.isbn13);
						$('#price').val(data.price);
					}
				});
		}
		var rowNum = booksTable.rows.length;
		for (var i = 1; i < rowNum; i++) {
			booksTable.deleteRow(i);
			rowNum = rowNum - 1;
			i = i - 1;
		}
		}else {
			alert("No book to add.");
		}
	}
	function remove1(obj) {
		if (confirm("Sure to delete?")) {

			//修改待添加书的数量
// 			var book_num = document.getElementById("book_num").innerHTML;
// 			book_num = book_num / 1;
// 			alert(booksTable.rows[0].cells[0].innerHTML);
// 			book_num -= booksTable.rows(obj.parentElement.parentElement.rowIndex).cells(7).innerText / 1;
// 			document.getElementById("book_num").innerHTML = book_num;

			//修改待添加项目的数量
// 			var item_num = document.getElementById("item_num").innerHTML;
// 			item_num = item_num / 1;
// 			item_num -= 1;
// 			document.getElementById("item_num").innerHTML = item_num;

			var booksTable = document.getElementById("booksTable");
			booksTable.deleteRow(obj.parentElement.parentElement.rowIndex);
		}

	}
	function changeCatalog1(obj) {
		var catalog2 = document.getElementById("catalog2");
		var catalog1Num = obj.selectedIndex;
		var catalogChose = obj.value.substring(0, 1);
		var resultNum = 0;
		var catalog2Length = catalog2.length;
		for (var i = 0; i < catalog2Length; i++) {
			if (catalog2.options[resultNum].text.substring(0, 1) != catalogChose) {
				catalog2.options.remove(resultNum);
			} else resultNum++;
		}
		$.ajax({
			url : "http://127.0.0.1:8080/Elibrary/GetCatalog?catalogNo=" + catalog1Num,
			type : 'get',
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				var cata2s = data.cata2s.split("*");
				for (var j = 0; j < data.cataNo; j++) {
					catalog2.options[catalog2.length] = new Option(cata2s[j], j + "");
				}

			},
			error : function(data) {
				alert("Error");
			}
		});
	}
	function changeCatalog2(obj) {
	}
</script>
</head>

<body>

	<section id="main-content"> <section class="wrapper">
	<div class="col-sm-9 col-md-12 main">
		<h1 class="page-header">Add books</h1>
		<div class="row">
			<div class="col-sm-3 col-md-3">
				<div class="container-form">
					<form class="form-horizontal" style="display: block"
						id="form_detail" role="form">
						<label>ISBN</label> <input type="text" class="form-control"
							id="isbn" placeholder="ISBN" onchange="search(this)"> <label>Title</label>
						<input type="text" class="form-control" id="title"
							placeholder="Title"> <label>Author</label> <input
							type="text" class="form-control" id="author" placeholder="Author">
						<label>Publisher</label> <input type="text" class="form-control"
							id="publisher" placeholder="Publisher"> <label>Publish
							Year</label> <input type="text" class="form-control" id="pubyear"
							placeholder="Publish Year"> <label>Price($)</label><input
							type="text" class="form-control" id="price" placeholder="Price">
						<label>Number</label> <input type="number" class="form-control"
							id="number2" placeholder="Number" onchange="updateAmount2()">
						<br>

					</form>
					<label>Catalog level 1 </label><br> <select id="catalog1"
						onchange="changeCatalog1(this)">
						<%
							Catalog catalog = new Catalog();
							for (int i = 0; i < catalog.getCatalogLevel1().length; i++) {
								out.println("<option>" + catalog.getCatalogLevel1()[i] + "</option>");
							}
						%>
						<option style="color:#99f">......new Catalog</option>
					</select> <br> <label>Catalog level 2 </label><br> <select
						id="catalog2">
						<%
							for (int j = 0; j < catalog.getCatalogLevel2()[0].length; j++) {
								out.println("<option>" + catalog.getCatalogLevel2()[0][j] + "</option>");
							}
						%>

					</select> <br> <br>
					<div class="row">
						<div class="col-sm-offset-5 col-xs-offset-5 col-md-offset-5">
							<button class="btn btn-default" type="submit"
								style="marginLeft:auto" onclick="addBooksToCache()">Add
								To List</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-9">
				<div class="panel-default">
					<div class="panel-heading">
						<span> Books to be added</span>
					</div>
					<div class="table-responsive" id="bookCache">
						<table class="table" id="booksTable">
							<thead>
								<tr>
									<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th>Book name</th>
									<th>Author</th>
									<th>Publisher</th>
									<th>Publication Year</th>
									<th>ISBN</th>
									<th>Price($)</th>
									<th>Amount</th>
									<th>ID Start</th>
									<th>ID End</th>
								</tr>
							</thead>

						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-offset-5 col-xs-offset-5 col-md-offset-5">
			<button type="submit" class="btn btn-success" onclick="submit()">Submit</button>
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

	<script type="text/javascript">
		$(document).ready(function() {
			var unique_id = $.gritter.add({
				// (string | mandatory) the heading of the notification
				title : 'Welcom to use Library Management System!',
				// (string | mandatory) the text inside the notification
				text : '欢迎使用，祝您工作愉快',
				// (string | optional) the image to display on the left
				image : 'assets/img/ui-sam.jpg',
				// (bool | optional) if you want it to fade out on its own or just sit there
				sticky : true,
				// (int | optional) the time you want it to be alive for before fading out
				time : '',
				// (string | optional) the class name you want to apply to that specific message
				class_name : 'my-sticky-class'
			});
	
			return false;
		});
	</script>

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

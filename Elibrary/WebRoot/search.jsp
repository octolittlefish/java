<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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

<title>Library Management System</title>

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
	function lent(obj) {
		var result = document.getElementById("result");
		var rowNum = obj.parentElement.parentElement.rowIndex;
		var a = result.rows[rowNum].cells[1].innerHTML;// a为变量值
		var str = "LentBook.jsp?bookid=" + a;
		//方案一（无效）
		// document.frm.action = str;

		//方案二（无效）
		// window.location.href = str;

		//方案三（有效）
		window.location.replace(str);
		return false;
	}

	function aaa(obj) {
		if (obj == document.getElementById("isbnChoice")) {
			document.getElementById("method").innerHTML = "ISBN<span class='caret'></span>";
		} else if (obj == document.getElementById("titleChoice")) {
			document.getElementById("method").innerHTML = "Title<span class='caret'></span>";
		} else if (obj == document.getElementById("authorChoice")) {
			document.getElementById("method").innerHTML = "Author<span class='caret'></span>";
		} else if (obj == document.getElementById("idChoice")) {
			document.getElementById("method").innerHTML = "BookID<span class='caret'></span>";
		}
	}
	function search() {
		var booksTable = document.getElementById("result");
		var rowNum = booksTable.rows.length;

		if (document.getElementById("input").value == "") {
			alert("Please input your search criteria.");
		} else {
			//alert("1");
			for (var i = 1; i < rowNum; i++) {
				booksTable.deleteRow(1);
			}
			$
					.ajax({
						url : "http://127.0.0.1:8080//Elibrary/GetBookCatalog"
								+ "?method="
								+ document.getElementById("method").innerHTML
								+ "&input="
								+ document.getElementById("input").value,
						type : 'get',
						dataType : "json",
						success : function(data) {
							//$('#title').val(data.title);
							//$('#author').val(data.author);
							//$('#pubyear').val(data.pubdate);
							//$('#publisher').val(data.publisher);
							//$('#isbn').val(data.isbn13);
							//$('#price').val(data.price);
							if (data.flag == "0") {
								alert("Please select a method first.");
							} else {
								var booksTable = document
										.getElementById("result");
								var nums = data.nums.split("^");
								var isbns = data.isbns.split("^");
								var books = data.books.split("^");
								var itemnum = Number(data.itemnum);
								var flag = 0;
								for (var i = 0; i < itemnum; i++) {
									var item = booksTable.insertRow();

									for (var j = 0; j < Number(nums[i]); j++, flag++) {
										var newRow = booksTable.insertRow();
										var book = books[flag].split("$");
										if (j == 0) {
											var detail = decodeURI(book[1])
													+ "(ISBN:" + isbns[i] + ")"
													+ "  " + decodeURI(book[2]);
											//alert(detail);
											item.insertCell().innerHTML = detail;
										}
										//alert(Number(nums[i]));
										if (book[8] == "false")
											newRow.insertCell().innerHTML = "<font color='#2a2'>Avaliable</font>";
										else
											newRow.insertCell().innerHTML = "<font color='#aaa'>not Avaliable(has been appointed)</font>";
										newRow.insertCell().innerHTML = decodeURI(book[0]);
										newRow.insertCell().innerHTML = decodeURI(book[1]);
										newRow.insertCell().innerHTML = decodeURI(book[2]);
										newRow.insertCell().innerHTML = decodeURI(book[3]);
										newRow.insertCell().innerHTML = decodeURI(book[4]);
										newRow.insertCell().innerHTML = decodeURI(book[5]);
										newRow.insertCell().innerHTML = decodeURI(book[6]);
										newRow.insertCell().innerHTML = decodeURI(book[7]);

										if (book[8] == "false") {
											newRow.insertCell().innerHTML = "<button type='submit' class='btn btn-success' onclick='lent(this)'>Lent</button>"
										} else {
											newRow.insertCell();
										}
										newRow.insertCell().innerHTML = "<button type='submit' class='btn btn-success' onclick='removeBook(this)'>Remove</button>"
									}
								}
								for (var i = 0; i < num; i++) {
									var newRow = booksTable.insertRow();
									var newCell1 = newRow.insertCell();

									if (data.member0.isAppoint == "0") {
										newCell1.innerHTML = "<font color='#3f0'>Available</font>";
									} else {
										newCell1.innerHTML = "<font color='#ddd'>Not Available</font>";
									}
									newRow.insertCell().innerHTML = data.member0.id;
									newRow.insertCell().innerHTML = data.member0.title;
									newRow.insertCell().innerHTML = data.member0.author;
									newRow.insertCell().innerHTML = data.member0.publisher;
									newRow.insertCell().innerHTML = "unknown";
									newRow.insertCell().innerHTML = data.member0.ISBN;
									newRow.insertCell().innerHTML = data.member0.bookPrice;
									newRow.insertCell().innerHTML = data.member0.bookNumber;
								}
							}

						}
					});
		}
	}
	function removeBook(obj) {
		var rowNum = obj.parentElement.parentElement.rowIndex;
		if (confirm("Sure to delete"
				+ document.getElementById("result").rows[rowNum].cells[1].innerHTML
				+ "？")) {
			$
					.ajax({
						url : "http://127.0.0.1:8080/Elibrary/RemoveBook?bookid="
								+ document.getElementById("result").rows[rowNum].cells[1].innerHTML,
						type : 'get',
						dataType : "json",
						success : function(data) {
							if (data.status == 'a') {
								alert("The book has been appointed. ");
							} else if (data.status == 'b') {
								alert("The book has been borrowed. ");
							} else if (data.status == 'd') {
								alert("Remove success!");
								search();
							} else
								alert("Error");
						}
					});
		}
	}
	function del() {
		if (!confirm("Sure to delete？")) {
			window.event.returnValue = false;
		}
	}
</script>
</head>

<body>
	<section id="main-content"> <section class="wrapper">
	<!-- 此处填写各个页面的具体布局 -->

	<div class="col-sm-9 col-md-10 main">
		<h1 class="page-header">Book list</h1>

		<!-- A row for searching books-->
		<div class="row">
			<div class="col-sm-5 col-md-5 input-group">
				<div class="input-group-btn">
					<button id="method" type="button"
						class="btn btn-default dropdown-toggle" data-toggle="dropdown">
						Search by...<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#" id="isbnChoice" onclick="aaa(this)">ISBN</a>
						</li>
						<li><a href="#" id="titleChoice" onclick="aaa(this)">Title</a>
						</li>
						<li><a href="#" id="authorChoice" onclick="aaa(this)">Author</a>
						</li>
						<li><a href="#" id="idChoice" onclick="aaa(this)">BookID</a>
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
						<th>Status</th>
						<th>ID</th>
						<th>Book name</th>
						<th>Author</th>
						<th>Publisher</th>
						<th>Publication Year</th>
						<th>ISBN</th>
						<th>Price(￥)</th>
						<th>Add Time</th>
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
	<script src="assets/js/zabuto_calendar.js"></script> <script
		type="text/javascript">
		$(document).ready(function() {
			var unique_id = $.gritter.add({
				// (string | mandatory) the heading of the notification
				title : 'Welcome to LMS!',
				// (string | mandatory) the text inside the notification
				text : 'Have a good day!',
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
	</script> <script type="application/javascript">
		
		
		
		
		
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
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

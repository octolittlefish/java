<%@ page language="java" import="java.util.*,javabean.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'introduce.jsp' starting page</title>

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
	function fun() {
		$.ajax({
			url : "http://127.0.0.1:8080/Elibrary/EditServlet?readerId"
		});
	}
</script>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-4 column"></div>
			
			<div class="col-md-4 column">
				<form action=" ">
					<img src="img/myphoto.png" style="width:150px;height:150px;margin-left: 150px;"><br><br>
                     <div class="form-group" style="margin-top: 40;width:600px;">
                          <label class="col-sm-2 col-sm-2 control-label">readerId</label>
                           <div class="col-sm-10">
                           <%ReaderMessage readerMessage = (ReaderMessage)request.getSession().getAttribute("readerMessage"); %>
                               <input type="text" id="disabledInput" class="form-control round-form" type="text" disabled value="<%=readerMessage.getReaderID()%>">
                          </div>
                    </div>
                    <br>
                    <div class="form-group" style="margin-top: 40;width:600px;">
                          <label class="col-sm-2 col-sm-2 control-label">idCard</label>
                           <div class="col-sm-10">
                               <input type="text" id="disabledInput" class="form-control round-form" type="text" disabled value="<%=readerMessage.getIdCard()%>">
                          </div>
                    </div>
                    <br>
                    <div class="form-group" style="margin-top: 40;width:600px;">
                          <label class="col-sm-2 col-sm-2 control-label">Name</label>
                           <div class="col-sm-10">
                               <input type="text" id="disabledInput" class="form-control round-form" type="text" disabled value="<%=readerMessage.getName()%>">
                          </div>
                    </div>
                    <br>
                    <div class="form-group" style="margin-top: 40;width:600px;">
                          <label class="col-sm-2 col-sm-2 control-label">Phone</label>
                           <div class="col-sm-10">
                               <input type="text" id="disabledInput" class="form-control round-form" type="text" disabled value="<%=readerMessage.getPhone()%>">
                          </div>
                    </div>
                    <br>
				</form>
			</div>
			
			<div class="col-md-4 column"></div>
		</div>
	</div>
	<br>
	 <div class="col-md-12 mt">
	                  	<div class="content-panel">
	                          <table class="table table-hover">
	                  	  	  <hr>
	                              <thead>
	                              <tr>
	                                  <th>Column</th>
	                                  <th>BookId</th>
	                                  <th>BookName</th>
	                                  <th>StartTime</th>
	                                  <th>ExpectReturnTime</th>
	                                  <th>IsLost</th>
	                                  <th>IsBack</th>
	                                  <th>debt</th>
	                              </tr>
	                              </thead>
	                              <tbody>
	                              <%
	                                   int i =0;
	                              		List<BorrowRecord> lists = (List) request.getSession().getAttribute("lists");
	                              		for(BorrowRecord b:lists){
	                              		i++;
	                               %>
	                              <tr>
	                                  <td><%=i %></td>
	                                  <td><%=b.getBookId() %></td>
	                                  <td><%=b.getBookName() %></td>
	                                  <td><%=b.getStartTime() %></td>
	                                  <td><%=b.getExpectReturnTime() %></td>
	                                  <td><%=b.getIsLost() %></td>
	                                  <td><%=b.getIsBack() %></td>
	                                  <td><%=b.getDebt() %></td>
	                              </tr>
	                              <%} %>
	                              </tbody>
	                          </table>
	                  	  </div><! --/content-panel -->
	                  </div><!-- /col-md-12 -->
				</div><!-- row -->
</body>
</html>

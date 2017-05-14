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

<title>My JSP 'team.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Le styles -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="assets/css/switcher.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/css/social.css" rel="stylesheet">
<link href="assets/css/style1.css" rel="stylesheet" id="colors">
<!-- !important THIS STYLE CSS ON BOTTOM OF STYLEs LIST-->
<link href="assets/css/prettyPhoto.css" rel="stylesheet" type="text/css" />
<link href="assets/js/google-code-prettify/prettify.css"
	rel="stylesheet">
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
</head>
</head>

<body style="background: #f2f2f2">
	
	<div class="container"><br><br><br>
		<!-- FILTER-->

<!--
		<div class="color-bottom-line center">
			<div class="line-proj center">
				<div class="proj">
					<div id="filters">
						<a href="#" data-filter="*" class="ione-col active">All
							departments</a> <a href="#" data-filter=".administration"
							class=" ione-col">administration</a> <a href="#"
							data-filter=".support" class="ione-col">support</a> <a href="#"
							data-filter=".design" class="ione-col">design</a>
					</div>
				</div>
			</div>
		</div>
  -->
		<div id="container-folio" class="row ufilter">
			<div id="portfolio" class="row">
				<div class="span3  project-item administration box">
					<div class="thumbnail">
						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									RongLiang Fu  <small>CEO, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 1103248903
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>
				<!-- ##################### -->
				<!-- END: team  item-->
				<!-- ##################### -->

				<!-- team  item -->
				<div class="span3  project-item administration box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									HuiXin Jiao <small>CEO, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<ul class="socialIcons">
									</ul>
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 294083274
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>
				<!-- ##################### -->
				<!-- END: team  item-->
				<!-- ##################### -->

				<!-- team  item -->
				<div class="span3  project-item administration box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									JiaXin Shi <small>CEO, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 894673968
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>
				<!-- ##################### -->
				<!-- END: team  item-->
				<!-- ##################### -->

				<!-- team  item -->
				<div class="span3  project-item administration box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									Dan Hu <small>CEO, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 863296236
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>
				<!-- ##################### -->
				<!-- END: team  item-->
				<!-- ##################### -->


				<!-- ##################### -->
				<!-- END: FIRST LINE -->
				<!-- ##################### -->


				<!-- ##################### -->
				<!-- START SECOND LINE ################################-->
				<!-- ##################### -->


				<!-- team  item -->
				<div class="span3  project-item design box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									Jing Wang <small>designer, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 1106125166
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>
				<!-- ##################### -->
				<!-- END: team  item-->
				<!-- ##################### -->

				<!-- team  item -->
				<div class="span3  project-item design box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									MingAi Dang <small>designer, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 2065635159
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>
				<!-- ##################### -->
				<!-- END: team  item-->
				<!-- ##################### -->

				<!-- team  item -->
				<div class="span3  project-item design box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									Yong Feng <small>designer, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 1446353452
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>
				<!-- ##################### -->
				<!-- END: team  item-->
				<!-- ##################### -->

				<!-- team  item -->
				<div class="span3  project-item design box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									Wang Yuan <small>designer, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 2089435433
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>



				<!-- team  item -->
				<div class="span3  project-item support box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									WenLi Li <small>support, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 475745526
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>


				<!-- team  item -->
				<div class="span3  project-item support box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									YuHao Liu <small>support, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 736440132
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>
				<!-- ##################### -->
				<!-- END: team  item-->
				<!-- ##################### -->

				<!-- team  item -->
				<div class="span3  project-item support box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									WenDa He <small>support, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 1255211254
									</div>
									</p>
								</div>
							</div>
							<!--END CAPTION -->
						</div>
						<!-- END: THUMBNAIL -->
					</div>
				</div>
				<!-- ##################### -->
				<!-- END: team  item-->
				<!-- ##################### -->

				<!-- team  item -->
				<div class="span3  project-item support box">
					<div class="thumbnail">

						<!-- IMAGE CONTAINER-->
						<div class="sample project-item-image-container">
							<img src="img/team_1.jpg" alt="iPhonegraphy" />
						</div>
						<!--END IMAGE CONTAINER-->

						<!-- CAPTION -->

						<div class="caption">
							<div class="transit-to-top">
								<h3 class="p-title standart-h3title">
									Geng Yang <small>support, VERSO</small>
								</h3>
								<p class="caption-descr">
								<div class="widget_nav_menu">
									<div class="phone-info">
										<i class="fa-icon-phone-sign"></i> + 974765830
									</div>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/js/jquery.js" type="text/javascript"></script>
	<script src="assets/js/google-code-prettify/prettify.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-transition.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-alert.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-modal.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-dropdown.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-scrollspy.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-tab.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-tooltip.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-popover.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-button.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-collapse.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-carousel.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-typeahead.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-affix.js" type="text/javascript"></script>
	<script src="assets/js/application.js" type="text/javascript"></script>
	<script type="text/javascript" src="assets/js/jquery.easing.js"></script>
	<script type="text/javascript" src="assets/js/jquery.transit.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.waitforimages.js"></script>
	<script type="text/javascript" src="assets/js/jquery.isotope.min.js"></script>
	<script src="assets/js/jquery.prettyPhoto.js" type="text/javascript"></script>
	<script src="assets/js/superfish.js" type="text/javascript"></script>
	<script src="assets/js/custom.js" type="text/javascript"></script>
	<script src="assets/js/jquery.ui.totop.js" type="text/javascript"></script>
	<script type="text/javascript" src="assets/js/switcher.js"></script>
	<script>
		jQuery.noConflict()(function($) {
			var $container = $('#container-folio');
	
			if ($container.length) {
				$container.waitForImages(function() {
	
					// initialize isotope
					$container.isotope({
						itemSelector : '.box',
						layoutMode : 'fitRows'
					});
	
					// filter items when filter link is clicked
					$('#filters a').click(function() {
						var selector = $(this).attr('data-filter');
						$container.isotope({
							filter : selector
						});
						$(this).removeClass('active').addClass('active').siblings().removeClass('active all');
	
						return false;
					});
	
				}, null, true);
			}
		});
	</script>
</body>
</html>

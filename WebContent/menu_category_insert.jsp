<!DOCTYPE html>
<html lang="en">
	
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Menu Category Insert</title>

		<meta name="description" content="Common form elements and layouts" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="maxcdnbootstrapcdn/font-awesome/4.4.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="dist/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="dist/css/chosen.min.css" />
		<link rel="stylesheet" href="dist/css/bootstrap-datepicker3.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->
		<link rel="stylesheet" href="dist/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="dist/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="dist/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="dist/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="dist/js/html5shiv.min.js"></script>
		<script src="dist/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<jsp:include page="header.jsp" />  
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

	
        	<jsp:include page="leftmenu.jsp" />  
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>


							<li>
								<a href="#">Menu Category</a>
							</li>
							<li class="active">Add New Menu Category</li>
						</ul><!-- /.breadcrumb -->

				
					</div>

					<div class="page-content">
						

						<div class="page-header">
							<h1>
								Add New Menu Category
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12 col-md-12 col-sm-12">
								<!-- PAGE CONTENT BEGINS -->
											<form id="unitForm" method="Post"  action="MenuCategoryInsertController" class="form-horizontal bv-form">
													
													<div class="form-group row ">
														<label class="col-lg-3 control-label">Menu Category Name</label>
														<div class="col-lg-6">
															<input type="text" class="form-control" placeholder="Menu Category" name="menu_category_name" data-bv-field="menu_category_name" required>
														</div>
													</div>
													
													<div class="form-group row ">
														<label class="col-lg-3 control-label">Recipe Color Code</label>
														<div class="col-lg-6">
															<input type="color" class="form-control" placeholder="Menu Color Code" name="menu_category_color" data-bv-field="uname" required>
														</div>
													</div>
													
													
													
												<div class="form-group row gutter">
													<div class="col-lg-6 col-lg-offset-6">
														<button type="submit" class="btn btn-success" >
															<span class="circless animate" style="height: 70px; width: 70px; top: -19px; left: 26.25px;"></span>Add New MenuCategory
															
														</button>
													</div>
												</div>
									
											</form>

									</div>
                                </div>	

									
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<jsp:include page="footer.jsp" />  

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="ajaxgoogleapis/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='dist/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='dist/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='dist/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="netdnabootstrapcdn/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="dist/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="dist/js/jquery-ui.custom.min.js"></script>
		<script src="dist/js/jquery.ui.touch-punch.min.js"></script>
		
		<script src="dist/js/bootbox.min.js"></script>
		<script src="dist/js/date-time/bootstrap-datepicker.min.js"></script>
		<script>
		  $('.date-picker').datepicker();
		</script>
		<script src="dist/js/jquery.hotkeys.min.js"></script>
		<!-- ace scripts -->
		<script src="dist/js/ace-elements.min.js"></script>
		<script src="dist/js/ace.min.js"></script>
        <script type="text/javascript" src="tinymce/tinymce.min.js"></script>
    <script type="text/javascript">
        tinymce.init({
	        selector: 'textarea',
	        plugins: ["image"]
	    });
    </script>


		<!-- inline scripts related to this page -->
		
	
	
	</body>

</html>

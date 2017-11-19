<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Ingredients Insert</title>

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
								<a href="#">Ingredients</a>
							</li>
							<li class="active">Add New Ingredients</li>
						</ul><!-- /.breadcrumb -->

				
					</div>

					<div class="page-content">
						

						<div class="page-header">
							<h1>
								Add New Ingredients
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12 col-md-12 col-sm-12">
								<!-- PAGE CONTENT BEGINS -->
					        <form class="form-horizontal" role="form" name="intake_insert" method="post" action="IngredientsInsertController">
									   <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Ingredients Name:</label> 
	                                        <div class="col-sm-6" >
	                                            <input placeholder=""Ingredients Name"" required class="form-control" type="text"  name="ingredients_name" required>
	                                        </div>
										</div>
										
										<div class="form-group">
											  <label class="col-lg-3 control-label">Units</label>
											   <div class="col-lg-6">
													<select name="unit_type" class="form-control">
													    <option>Select the unit type (Used in recipe)</option>
													    <c:forEach var="units" items="${units}">
															<option value="<c:out value="${units.id}"/>" ><c:out value="${units.unitName}"/></option>
														</c:forEach>
													</select>
												</div>
											</div>
											
										<div class="form-group">
											  <label class="col-lg-3 control-label">Ingredients Category Type</label>
											   <div class="col-lg-6">
													<select name="category_type" id="category_type" class="form-control" onChange="categorychange(this);">
													    <option>Select Category Type</option>
													    <c:forEach var="category" items="${category}">
															<option value="<c:out value="${category.id}"/>" ><c:out value="${category.ingredientsCategoryName}"/></option>
														</c:forEach>
													</select>
												</div>
											</div>
											
											<div id = "leadTime" class="form-group row ">
												<label class="col-lg-3 control-label">Per Day Consumption</label>
												<div class="col-lg-6">
													<input type="text" class="form-control" placeholder="perDayConsumption" name="per_day_consumption">
												</div>
											</div>
											
										
											<div class="form-group">
												  <label class="col-lg-3 control-label">Equivalent Units</label>
												   <div class="col-lg-6">
														<select name="equ_unit_type" class="form-control">
														    <option>Select Equivalent Units Type (the unit in which will come the requisition)</option>
														    <c:forEach var="units" items="${units}">
																<option value="<c:out value="${units.id}"/>" ><c:out value="${units.unitName}"/></option>
															</c:forEach>
														</select>
													</div>
												</div>
												
												
												
												
										
												<div class="form-group row ">
													<label class="col-lg-3 control-label">Equivalent Ratio</label>
													<div class="col-lg-6">
														<input type="number" class="form-control" placeholder="Equivalent Ratio" name="equ_ratio">
													</div>
												</div>

												<div class="form-group row ">
													<label class="col-lg-3 control-label">Minimum Quantity</label>
													<div class="col-lg-6">
														<input type="number" class="form-control" placeholder="Minimum Quantity" name="min_qty">
													</div>
												</div>
												
												<div class="form-group row ">
													<label class="col-lg-3 control-label">Live Stock</label>
													<div class="col-lg-6">
														<input type="number" class="form-control" placeholder="Live Stock" name="livestock">
													</div>
												</div>
												
												<div class="form-group row ">
													<label class="col-lg-3 control-label">Wastage Amount</label>
													<div class="col-lg-6">
														<input type="number" class="form-control" placeholder="per Unit wastage amount" name="wastage">
													</div>
												</div>
											
											<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
                                       
											<button name="btnAdd" class="btn btn-info" type="submit">
												<i class="ace-icon fa fa-check bigger-110"></i>
												Add New Ingredient
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
		<!-- script for handling category -->
			<script src="js/jquery.js"></script><script src="js/bootstrap.min.js"></script><script src="js/scrollup/jquery.scrollUp.js"></script><script src="js/custom.js"></script></body>
										<script>
								
										
										function categorychange(sel)
										{
		
											if($("#category_type :selected").text() =="Lead Time"){
											
												$("#leadTime").show();
											}
											else
												{
												$("#leadTime").hide();
												}
										}
										
										$(document).ready(function() {
		
											$("#leadTime").hide();
											$("#ingredient").click(function() {
												$("#sub").hide();
											});
											
										});
										</script>
		<!-- script for handling category ends -->
	
	
	</body>

</html>

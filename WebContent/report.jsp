<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Daily Sales</title>

	
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<link rel="stylesheet" href="dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="maxcdnbootstrapcdn/font-awesome/4.4.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
        
        <link rel="stylesheet" href="dist/css/bootstrap-datepicker3.min.css" />
        <link rel="stylesheet" href="dist/css/bootstrap-editable.min.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="dist/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!-- ace settings handler -->
		<script src="dist/js/ace-extra.min.js"></script>
		  
		  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		  <link rel="stylesheet" href="/resources/demos/style.css">
		  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		  
		  <!-- alif calendar -->
				<!-- Include jQuery -->
				<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
				
				<!-- Include Date Range Picker -->
				<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
				
				<script>
				    $(document).ready(function(){
				        var date_input=$('input[name="from_date"]'); //our date input has the name "date"
				        var date_input1=$('input[name="to_date"]'); //our date input has the name "date"
				        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
				        date_input.datepicker({
				            format: 'yyyy-mm-dd',
				            container: container,
				            todayHighlight: true,
				            autoclose: true,
				        }),
				        date_input1.datepicker({
				            format: 'yyyy-mm-dd',
				            container: container,
				            todayHighlight: true,
				            autoclose: true,
				        })
				    })
				</script>
				  
  
		  <!-- alif calendar -->
		  
		  
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
								<a href="#">Report</a>
							</li>
							<li class="active">Daily Sales</li>
						</ul><!-- /.breadcrumb -->

						<!--<div class="nav-search" id="nav-search">
							
						</div>--><!-- /.nav-search -->
					</div>

					<div class="page-content">
						

						<div class="page-header">
                        <div class="row">
                          <div class="col-sm-6">
							<h1>
								Daily Sales
								
							</h1>
                          </div>
                        <!-- alif calendar -->
						<div class = "col-md-2">
						    <form method="post" action = "DailySalesListController">
						      <div class="form-group"> <!-- Date input -->
						        <label class="control-label" for="date">From Date</label>
						        <input class="form-control" id="date" name="from_date" placeholder="YYYY/MM/DD" type="text"/>
						      </div>
						 </div>
						 <div class = "col-md-2">
						      <div class="form-group"> <!-- Date input -->
						        <label class="control-label" for="date">To Date</label>
						        <input class="form-control" id="date1" name="to_date" placeholder="YYYY/MM/DD" type="text"/>
						      </div>
						      <div class="form-group"> <!-- Submit button -->
						        <button class="btn btn-primary " name="submit" type="submit">Check Sales</button>
						      </div>
						  </div>
						     </form>
						
                        <!-- alif calendar ends -->
                          <div class="col-sm-2 pull-right text-right">
							<a href="#" class="btn btn-app  btn-light btn-xs" onClick ="printData();"><i class="ace-icon fa fa-print bigger-160"></i> Print</a>
							<a href="#" class="btn btn-app btn-info  btn-xs" data-toggle="modal" data-target="#myModal" ><i class="ace-icon fa fa-envelope bigger-200"></i>Email</a>
                          </div>
                        </div>
						</div><!-- /.page-header -->

						   <!-- Modal -->
							<div id="myModal" class="modal fade" role="dialog">
							  <div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
								  <div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Report Send to Owners </h4>
								  </div>
								
								 
								</div>
                                <!-- Modal content-->
							  </div>
							</div>
                           <!-- Modal -->
								<div class="row" id="report_list">
									<div class="col-xs-12">
										<div class="tab-content col-sm-11"  style="padding:0px 0px 0px 8px; border:none;">
												
											<div id="all" class="tab-pane active">
												<table border="1" cellpadding="3" id="dynamictable" class="table  table-striped table-bordered table-hover table-responsive">
                                                    <thead>
                                                         <tr >
														 
														   <th id="table_title" colspan="13" style="text-align:center;" ><strong>M Cafe Restaurant<br><?php echo $date_title; ?></strong></th>
                                                         </tr>
														 <tr >
                                                              <th width="50" align="center" ><strong>SL</strong></th>
                                                                   <th  ><strong>Invoice</strong></th>
                                                                   <th  ><strong>Sub Total</strong></th>
                                                                   <th  ><strong>Disc of ST</strong></th>
                                                                   <th  ><strong>Vat[15%]</strong></th>
                                                                   <th  ><strong>Total</strong></th>
  													               <th  ><strong>Payment</strong></th>
                                                                   <th  ><strong>Cash</strong></th>
                                                                   <th  ><strong>Card</strong></th>
                                                                   <th  ><strong>Bank Name</strong></th>
                                                                   <th  ><strong>Action</strong></th>
                                                         </tr>
                                                    </thead>
                                                    <tbody id="tbody">
                                                    
                                                   <c:forEach var="salesInfoList" items="${salesInfoList}">
                                                    <tr >
                                                      <td  height="30" align="center">1</td>
                                                      <td><c:out value="${salesInfoList.sessionId}"/></td>
                                                      <td><c:out value="${salesInfoList.subTotal}"/></td>
                                                      <td><c:out value="${salesInfoList.discount}"/></td>
                                                      <td><c:out value="${salesInfoList.vat}"/></td>
                                                      <td><c:out value="${salesInfoList.orderTotal}"/></td>
													  <td><c:out value="${salesInfoList.paidAmount}"/></td>
													  <td><c:out value="${salesInfoList.cashAmount}"/></td>
												      <td><c:out value="${salesInfoList.cardAmount}"/></td>
													  <td><c:out value="${salesInfoList.bankName}"/></td>
											
                                                       <td><a class="red" href="DailySalesDeleteController?id=<c:out value="${salesInfoList.sessionId}"/>" >
															<i class="ace-icon fa fa-trash-o bigger-130"></i>
															</a></td>
													</tr>
        											</c:forEach>  
													
													 <tr >
														  <td></td>
														  <td></td>
														  <td><strong><c:out value="${detailList.subTotal}"/></strong></td>
														  <td style="text-align:right;"><strong></strong></td>
														  <td><strong><c:out value="${detailList.totalVat}"/></strong></td>
														  <td><strong><c:out value="${detailList.orderTotal}"/></strong></td>
														  <td></td>
														  <td style="text-align:right;"><strong><c:out value="${detailList.totalCash}"/></strong></td>
														  <td><strong><c:out value="${detailList.totalCard}"/></strong></td>
														  <td style="text-align:right;"></td>
														  <td></td>

														</tr>
													
                                                	      
                                                </tbody>
			
											  </table>
											</div>
				
												
										</div>
									</div>
								</div>

								

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
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
		<script src="dist/js/dataTables/jquery.dataTables.min.js"></script>
		<script src="dist/js/dataTables/jquery.dataTables.bootstrap.min.js"></script>
		<script src="dist/js/dataTables/extensions/buttons/dataTables.buttons.min.js"></script>
		<script src="dist/js/dataTables/extensions/buttons/buttons.flash.min.js"></script>
		<script src="dist/js/dataTables/extensions/buttons/buttons.html5.min.js"></script>
		<script src="dist/js/dataTables/extensions/buttons/buttons.print.min.js"></script>
		<script src="dist/js/dataTables/extensions/buttons/buttons.colVis.min.js"></script>
		<script src="dist/js/dataTables/extensions/select/dataTables.select.min.js"></script>
        <script src="dist/js/date-time/bootstrap-datepicker.min.js"></script>
        

		<!-- ace scripts -->
		<script src="dist/js/ace-elements.min.js"></script>
		<script src="dist/js/ace.min.js"></script>
        <script>
		
			function ConfirmDelete(id,program,semester_id,intake_id,section_no)
			{
			   //alert(""+id);
				var result = confirm("Are you sure you want to Delete this Record?");
				if (result==true)
				{
					window.location = "course_offer_list?del=ok&course_id="+id+"&Program="+program+"&semester_id="+semester_id+"&intake_id="+intake_id+"&section_no="+section_no;
				}
			}
         

		</script>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
			
			jQuery(function($) {
				 $('.date-picker').datepicker({
						format: 'yyyy-mm-dd'
				});
				
				//initiate dataTables plugin
				var myTable = 
				$('#dynamic-table')
				//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
				.DataTable( {
					bAutoWidth: true,
					"aoColumns": [
					  { "bSortable": true },
					  null, null,null, null, null,  null,  null,  null,  null, null, null,
					  { "bSortable": true }
					],
					"aaSorting": [],
					
					
					//"bProcessing": true,
			        //"bServerSide": true,
			        //"sAjaxSource": "http://127.0.0.1/table.php"	,
			
					//,
					//"sScrollY": "200px",
					"bPaginate": true,
			
					//"sScrollX": "100%",
					//"sScrollXInner": "120%",
					//"bScrollCollapse": true,
					//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
					//you may want to wrap the table inside a "div.dataTables_borderWrap" element
			
					"iDisplayLength": 100,
			
			
					select: {
						style: 'multi'
					}
			    } );
			
				
				
				
				
				var defaultColvisAction = myTable.button(0).action();
				myTable.button(0).action(function (e, dt, button, config) {
					
					defaultColvisAction(e, dt, button, config);
					
					
					if($('.dt-button-collection > .dropdown-menu').length == 0) {
						$('.dt-button-collection')
						.wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
						.find('a').attr('href', '#').wrap("<li />")
					}
					$('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
				});
			
				////
			
				setTimeout(function() {
					$($('.tableTools-container')).find('a.dt-button').each(function() {
						var div = $(this).find(' > div').first();
						if(div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
						else $(this).tooltip({container: 'body', title: $(this).text()});
					});
				}, 500);
				
				
				
				
				
				myTable.on( 'select', function ( e, dt, type, index ) {
					if ( type === 'row' ) {
						$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', true);
					}
				} );
				myTable.on( 'deselect', function ( e, dt, type, index ) {
					if ( type === 'row' ) {
						$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', false);
					}
				} );
			
			
			
			
				/////////////////////////////////
				//table checkboxes
				$('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);
				
				//select/deselect all rows according to table header checkbox
				$('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function(){
					var th_checked = this.checked;//checkbox inside "TH" table header
					
					$('#dynamic-table').find('tbody > tr').each(function(){
						var row = this;
						if(th_checked) myTable.row(row).select();
						else  myTable.row(row).deselect();
					});
				});
				
				//select/deselect a row when the checkbox is checked/unchecked
				$('#dynamic-table').on('click', 'td input[type=checkbox]' , function(){
					var row = $(this).closest('tr').get(0);
					if(!this.checked) myTable.row(row).deselect();
					else myTable.row(row).select();
				});
			
			
			
				$(document).on('click', '#dynamic-table .dropdown-toggle', function(e) {
					e.stopImmediatePropagation();
					e.stopPropagation();
					e.preventDefault();
				});
				
				
				
				//And for the first simple table, which doesn't have TableTools or dataTables
				//select/deselect all rows according to table header checkbox
				var active_class = 'active';
				$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
					var th_checked = this.checked;//checkbox inside "TH" table header
					
					$(this).closest('table').find('tbody > tr').each(function(){
						var row = this;
						if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
						else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
					});
				});
				
				//select/deselect a row when the checkbox is checked/unchecked
				$('#simple-table').on('click', 'td input[type=checkbox]' , function(){
					var $row = $(this).closest('tr');
					if(this.checked) $row.addClass(active_class);
					else $row.removeClass(active_class);
				});
			
				
			
				/********************************/
				//add tooltip for small view action buttons in dropdown menu
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				
				//tooltip placement on right or left
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					//var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
				
			
			})
			
			$("#btnAdd").click(function(){
				var request;
				   var $form = $("#email_send_form");
			
					var serializedData = $form.serialize();
					 request = $.ajax({
						url: "email_send.php",
						type: "post",
						data: serializedData
					});
					
					request.done(function (response, textStatus, jqXHR){
					// Log a message to the console
					  alert(response);
					
						
					});
				
					// Callback handler that will be called on failure
					request.fail(function (jqXHR, textStatus, errorThrown){
						// Log the error to the console
						console.error(
							"The following error occurred: "+
							textStatus, errorThrown
						);
					});
		
			
			
		    });
			function printData()
			{
			   var table = "<table border='1' cellpadding='1'";
			       table += "<tr><td colspan='4' align='center'>"+$("#table_title").html()+"</td></tr>";
				   table+="<tr><td><strong>SL</strong></td>";
					 table+="<td><strong>Invoice No</strong></td>";
					 table+="<td><strong>Invoice Date</strong></td>";
					 table+="<td><strong>Total</strong></td></tr>";
				   var table_length = document.getElementById("tbody").rows.length-1;
				   for(var i=0; i<table_length; i++)
				   {
				     table+="<tr><td>"+document.getElementById("tbody").rows[i].cells[0].innerHTML+"</td>";
					 table+="<td>"+document.getElementById("tbody").rows[i].cells[1].innerHTML+"</td>";
					 table+="<td>"+document.getElementById("tbody").rows[i].cells[2].innerHTML+"</td>";
					 table+="<td>"+document.getElementById("tbody").rows[i].cells[8].innerHTML+"</td></tr>";
				   }
				   table+="<tr><td  colspan='2' ><strong>Total Amount</strong></td><td  colspan='2' >"+document.getElementById("tbody").rows[table_length].cells[8].innerHTML+"</td></tr>";
				   table+="<tr><td  colspan='2' ><strong>Total VAT</strong></td><td  colspan='2' >"+document.getElementById("tbody").rows[table_length].cells[6].innerHTML+"</td></tr>";
				   table+="<tr><td  colspan='2' ><strong>Total Service Charge</strong></td><td  colspan='2' >"+document.getElementById("tbody").rows[table_length].cells[5].innerHTML+"</td></tr>";
				   table+="<tr><td  colspan='2' ><strong>Total Discount</strong></td><td  colspan='2' >"+document.getElementById("tbody").rows[table_length].cells[4].innerHTML+"</td></tr>";
					table+="</table>";
					 newWin= window.open("");
			   newWin.document.write(table);
			   newWin.print();
			   newWin.close();
			}
		</script>
		
	</body>


</html>
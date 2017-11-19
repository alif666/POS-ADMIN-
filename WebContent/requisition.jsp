
  <jsp:include page="header1.jsp" />  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
<!-- requisition table -->
<% 
String msg = request.getParameter("msg");	
%>
<style>
.whiteFont{
	color:#FFF;
	
}

</style>
	<div class = 'container-fluid' style = 'padding :50px; text-align : center;'>
				<div><h1><%out.println(msg);%></h1></div>
	 			<div class="row" style='background-color:#364676; border-color:#31B0D5; padding : 30px; box-shadow: 10px 10px 5px #888888; border-radius: 35px;'>
					    <div class='col-sm-1 whiteFont'><input type="checkbox" name="select-all" id="select-all" /></div>
					    <div class='col-sm-4 whiteFont'><strong>Ingredient's Name</strong></div>
					    <div class='col-sm-2 whiteFont'><strong>LiveStock</strong></div>
			    		<div class='col-sm-2 whiteFont'><strong>Quantity</strong></div>
			    		<div class='col-sm-2 whiteFont'><strong>Unit</strong></div>

			  	</div>
	
	 <form action = "RequisitionController" method = "POST"> 
			  <div class = 'container-fluid' style = 'overflow: scroll ; height : 50%;'>		
				  	<c:forEach var='ingredientsList' items='${ingredientsList}'>
					  	<div class='row' style='padding : 30px;'>
					  		 <div class='form-group' >	
					  		 		<div class='col-sm-1'><input type="checkbox" name= "checkbox" id = "<c:out value='${ingredientsList.id}'/>" value = "<c:out value='${ingredientsList.id}'/>" ></div>
								    <div class='col-sm-4'><c:out value='${ingredientsList.name}'/></div>
								    <div class='col-sm-2'><c:out value='${ingredientsList.livestock}'/></div>
						    		<div class='col-sm-2'><input value="0" style = ' border-radius: 35px;;'id = "<c:out value='${ingredientsList.id}'/>" class="form-control <c:out value='${ingredientsList.id}'/>" type = 'number' name = "qty[]"></div>
									<div class='col-sm-2'><c:out value='${ingredientsList.unitId.unitName}'/></div>
							</div>
						</div>
				  	</c:forEach>
				</div>	
	 		<div class ='row'>
	  			<div class ='col-md-offset-6 col-sm-3' style = 'float: right;'><button style = "display : none;"id ='submitButton' type = 'submit' class = 'btn btn-success'>Submit</button></div>
	  		</div>
	</form>
		<!-- Trigger the modal with a button -->
			<div class ='row whiteFont'>
				<button type="button" style ='box-shadow: 10px 10px 5px #888888; background-color:#364676; border-radius: 35px;' class="col-md-offset-10 col-sm-2 btn btn-lg" data-toggle="modal" data-target="#myModal">Submit</button>
			</div>
		<!-- Modal Starts here -->	
				<!-- Modal -->
				<div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog">
				
				    <!-- Modal content-->
				    <div class="modal-content">
				      <div class="modal-header" style = 'background-color: #364676'>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4 class="modal-title whiteFont">PLEASE CONFIRM YOUR SUBMISSION</h4>
				      </div>
				      <div class="modal-body">
				        <p>Are you sure you have completed your requisition ?</p>
				      </div>
				      <div class="modal-footer" >
					      	<div class ='row'>
					  			<div class ='col-sm-6' style = "float:right;"><button style = "background-color:#364676; color: #fff;" id = 'triggerButton' type = 'button' class = 'btn btn-default'>YES</button></div>
					  			<div class ='col-sm-6 whiteFont'><button style = "float:left; background-color:#364676;" type="button" class="btn data-dismiss="modal">NO</button></div>
					  		</div>
				      </div>
				    </div>
				  </div>
				</div>
		<!-- Modal ends here -->
	</div>
	<script>
//select all configuration
	$('#select-all').click(function(event) {   
	    if(this.checked) {
	        // Iterate each checkbox
	        $(':checkbox').each(function() {
	            this.checked = true;                        
	        });
	        $('input').prop('disabled', false);
	    	 $('.'+name).val('');

	    }else{
	        $(':checkbox').each(function() {
	            this.checked = false;                        
	        });
	        $('input').prop('disabled', true);
	        $(':checkbox').prop('disabled',false);

	    }
	});
//select all configurations ends

//triggerSubmit onClick
	$('#triggerButton').click(function(event) {   
		//alert('clicked');
		$('#submitButton').trigger('click');
	});


//triggerSubmit onClick

//checkbox onclick
	$(':checkbox').click(function(event) {   
	    if(this.checked) {
	        // Iterate each checkbox
	        //var name = $("#container input:checkbox").attr("id");
	        var name = $(this).attr("id");
			//alert('checked'+$this.attr("id"));
	    	 //alert('checked'+name);
	    	 $('.'+name).prop('disabled', false);

	    	 $('.'+name).val('');
 
	    	 
	    }else{
	        // Iterate each checkbox
	        //var name = $("#container input:checkbox").attr("id");
	        var name = $(this).attr("id");
			//alert('checked'+$this.attr("id"));
	    	//alert('checked'+name);
	    	$('.'+name).prop('disabled', true);
	    	 $('.'+name).val('');

	    }
	    
	});
//checkbox onclick ends


//ready function
	$(function() {
		$('#select-all').checked = true;
        $(':checkbox').each(function() {
            this.checked = true;                        
        });
	});



//ready function ends
</script>
	<!--  requisition table ends -->



  <jsp:include page="footer1.jsp" /> 
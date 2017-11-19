<% if((session.getAttribute("user_name")==null) || (session.getAttribute("user_name")==""))
 {
 response.sendRedirect("index.jsp");
 } 
 %>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="style/dashboard.css"> 
<link rel="stylesheet" type="text/css" href="style/header.css">
  <title>UMAI</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="heading">
	<div class="container-fluid " style= "padding-left:0;">
		<div class="row">
			<div class="col-md-12 text-center" style="color:#fff;">
				 <img src ="<c:out value='${user_image}'/>"class="img-circle" style=" float:right; margin: 5px; margin-right: 50px;" alt="KaziPhoto" width="200" height="200">
				
				  <h1>Welcome to<br>UMAI Restaurant Management Portal</h1>

			</div>
		</div>
	</div>
</div>

 <!-- Modal for waiter -->
 <div class="modal fade" id="waiterModal" role="dialog">
   <div class="modal-dialog">
   
     <!-- Modal content-->
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
         <h4 class="modal-title">Waiter Creation</h4>
       </div>
       <div class="modal-body">
         <p>
 <!-- form for waiter -->
		<form action="UserRegistration" method = "POST">
			 <input type="hidden" class="form-control"  value = "Waiter"  name="user_type">
		    
		    <div class="form-group">
		      <label for="name">Waiter's Name:</label>
		      <input type="text" class="form-control" id="name" placeholder="Waiter's Name" name="user_name">
		    </div>
		    <div class="form-group">
		      <label for="email">Waiter's Email:</label>
		      <input type="email" class="form-control" id="email" placeholder="Waiter's email" name="user_email">
		    </div>
		    <div class="form-group">
		      <label for="pwd">Waiter's Password:</label>
		      <input type="password" class="form-control" id="pwd" placeholder="Waiter's password" name="user_password">
		    </div>
		    <button type="submit" class="btn btn-default">Submit</button>
		  </form>
 
 <!-- form for waiter ends -->
 
         </p>
       </div>
       <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       </div>
     </div>
     
   </div>
 </div>
 
 
 <!-- Modal for Cashier -->
 <div class="modal fade" id="cashierModal" role="dialog">
   <div class="modal-dialog">
   
     <!-- Modal content-->
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
         <h4 class="modal-title">Cashier Creation</h4>
       </div>
       <div class="modal-body">
          <!-- form for Cashier -->
				<form action="UserRegistration" method = "POST">
					 <input type="hidden" class="form-control"  value = "Cashier"  name="user_type">
				    
				    <div class="form-group">
				      <label for="name">Cashier's Name:</label>
				      <input type="text" class="form-control" id="name" placeholder="Name" name="user_name">
				    </div>
				    <div class="form-group">
				      <label for="email">Cashier's Email:</label>
				      <input type="email" class="form-control" id="email" placeholder="email" name="user_email">
				    </div>
				    <div class="form-group">
				      <label for="pwd">Cashier's Password:</label>
				      <input type="password" class="form-control" id="pwd" placeholder="password" name="user_password">
				    </div>
				    <button type="submit" class="btn btn-default">Submit</button>
				  </form>
		 
		 <!-- form for Cashier ends -->
       </div>
       <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       </div>
     </div>
     
   </div>
 </div>
 
 <!-- Modal for Kitchen Manager -->
 <div class="modal fade" id="kitchenModal" role="dialog">
   <div class="modal-dialog">
   
     <!-- Modal content-->
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
         <h4 class="modal-title">Kitchen Manager</h4>
       </div>
       <div class="modal-body">
          <!-- form for Kitchen Manager -->
				<form action="UserRegistration" method = "POST">
					 <input type="hidden" class="form-control"  value = "Kitchen Manager"  name="user_type">
				    
				    <div class="form-group">
				      <label for="name">Manager's Name:</label>
				      <input type="text" class="form-control" id="name" placeholder="Manager's Name" name="user_name">
				    </div>
				    <div class="form-group">
				      <label for="email">Manager's Email:</label>
				      <input type="email" class="form-control" id="email" placeholder="Manager's email" name="user_email">
				    </div>
				    <div class="form-group">
				      <label for="pwd">Password:</label>
				      <input type="password" class="form-control" id="pwd" placeholder="Manager's password" name="user_password">
				    </div>
				    <button type="submit" class="btn btn-default">Submit</button>
				  </form>
		 
		 <!-- form for Kitchen Manager ends -->
       </div>
       <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       </div>
     </div>
     
   </div>
 </div>
 
 
 <!-- Modal for Purchase Boy-->
 <div class="modal fade" id="purchaseModal" role="dialog">
   <div class="modal-dialog">
   
     <!-- Modal content-->
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
         <h4 class="modal-title">Purchase Boy</h4>
       </div>
       <div class="modal-body">
         <!-- form for Purchase Boy -->
				<form action="UserRegistration" method = "POST">
					 <input type="hidden" class="form-control"  value = "Purchase Boy"  name="user_type">
				    
				    <div class="form-group">
				      <label for="name">Purchase Boy's Name:</label>
				      <input type="text" class="form-control" id="name" placeholder="Name" name="user_name">
				    </div>
				    <div class="form-group">
				      <label for="email">Email:</label>
				      <input type="email" class="form-control" id="email" placeholder="email" name="user_email">
				    </div>
				    <div class="form-group">
				      <label for="pwd">Password:</label>
				      <input type="password" class="form-control" id="pwd" placeholder="password" name="user_password">
				    </div>
				    <button type="submit" class="btn btn-default">Submit</button>
				  </form>
		 
		 <!-- form for Purchase Boy ends -->
       </div>
       <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       </div>
     </div>
     
   </div>
 </div>
	

<div class="container-fluid" style = "margin:30px">
		 

  <div class ="row">
  	<div class ="col-md-6">
  		<p class = "welcome_text"><br> Welcome <c:out value='${user_name}'/>
  		<h1 class ="menu_text">USERS Panel</h1></p>
  	</div>
  	<div class ="col-md-6" style="text-align:right;">
  		<p class = "welcome_text"><a class="btn btn-success" href = "dashboard.jsp">Dashboard</a></p>
  		<p class = "welcome_text">Click to setup</p>
  	</div>
  </div>
</div>



<div class="container-fluid" style = "margin:60px"> 
  <div class="row">
    <div class="col-md-3">
	   <a class = "btn btn-lg btn-success thumbnail" href = "#" data-toggle="modal" data-target="#waiterModal">
	     	 <div class="caption">
	           <h3 align= "center" class = "welcome_text" style = "color: #AAA;">Create Waiter</h3>
	         </div>      
	     
	     </a>
    </div>
    <div class="col-md-3">
	   <a class = "btn btn-lg btn-success thumbnail" href = "#" data-toggle="modal" data-target="#cashierModal">
	     	<div class="caption">
	           <h3 align= "center" class = "welcome_text" style = "color: #AAA;">Create Cashier</h3>
	         </div>      
	     
	     </a>
    </div>
    <div class="col-md-3">
	   <a class = "btn btn-lg btn-success thumbnail" href = "#" data-toggle="modal" data-target="#kitchenModal">
	     	<div class="caption">
	           <h3 align= "center" class = "welcome_text" style = "color: #AAA;">Create Kitchen Manager</h3>
	         </div>      
	     
	     </a>
    </div>
    
    <div class="col-md-3">
	   <a class = "btn btn-lg btn-success thumbnail" href = "#" data-toggle="modal" data-target="#purchaseModal">
	     	<div class="caption">
	           <h3 align= "center" class = "welcome_text" style = "color: #AAA;">Create Purchase Boy</h3>
	         </div>      
	     
	     </a>
    </div>
    
  </div>
</div>

<div class="container">
  <h2>User List</h2>
  <table class="table">
    <thead>
      <tr>
        <th>UserType</th>
        <th>Name</th>
        <th>Email</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
		<c:forEach var="userList" items="${userList}">
			<tr>
			  <td ><c:out value="${userList.userType.typeName}"/></td>
			  <td ><c:out value="${userList.userName}"/></td>
			  <td ><c:out value="${userList.userEmail}"/></td>
			  <td >
			   		<div class="action-buttons">
					 <div class="col-sm-12">
						
					    <a href="UserDelete?id=${userList.id}" >
							<label>Remove Access</label>
						</a>
						 </div>
						</div>
			  </td>
			</tr>
		</c:forEach> 
    </tbody>
  </table>
</div>

</body>
</html>
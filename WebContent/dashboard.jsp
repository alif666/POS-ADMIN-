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
				 <!--  <img src ="<c:out value='${user_image}'/>"class="img-circle" style=" float:right; margin: 5px; margin-right: 50px;" alt="KaziPhoto" width="200" height="200">-->
				
				  <h1>Welcome to<br>M-Cafe Restaurant Management Portal</h1>

			</div>
		</div>
	</div>
</div>


	

<div class="container-fluid" style = "margin:30px">
		 

  <div class ="row">
  	<div class ="col-md-6">
  		<p class = "welcome_text"><br> Welcome <c:out value='${user_name}'/>
  		<h1 class ="menu_text">DASHBOARD</h1></p>
  	</div>
  	<div class ="col-md-6" style="text-align:right;">
  		<p class = "welcome_text">Setup Restaurant</p>
  		<p class = "welcome_text">Click to setup</p>
  	</div>
  </div>
</div>



<div class="container-fluid" style = "margin:60px"> 
  <div class="row">
    <div class="col-md-3">
	   <a class = "btn btn-lg btn-success thumbnail" href = "PieChart">
	     
		     <div class="caption">
	           <h3 align= "center" class = "welcome_text" style = "color: #AAA;">Report</h3>
	         </div>      
	     
	     </a>
    </div>
    <div class="col-md-3">
	   <a class = "btn btn-lg btn-success thumbnail" href = "IngredientsCategoryInsertController">
	     
		  <div class="caption">
	           <h3 align= "center" class = "welcome_text" style = "color: #AAA;">Ingredients & Category</h3>
	         </div>      
	     
	     </a>
    </div>
    <div class="col-md-3">
	   <a class = "btn btn-lg btn-success thumbnail" href = "TableInsertController">
	     
		  <div class="caption">
	           <h3 align= "center" class = "welcome_text" style = "color: #AAA;">Table</h3>
	         </div>      
	     
	     </a>
    </div>
    
    <div class="col-md-3">
	   <a class = "btn btn-lg btn-success thumbnail" href = "UserRegistration">
	     
		  <div class="caption">
	           <h3 align= "center" class = "welcome_text" style = "color: #AAA;">User</h3>
	         </div>      
	     
	     </a>
    </div>
    
  </div>
</div>

</body>
</html>
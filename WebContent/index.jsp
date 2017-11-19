<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" type="text/css" href="style/loginPage.css">
  <title>UMAI</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center animated pulse" id = "heading">
  <h1 id = "headingText">Welcome to<br>M-Cafe Restaurant Management Portal<br></h1>
  <h2 id = "headingText2"></h2>
</div>
  
<div class="container">
  <div class="row " align = "center">

  		<!--body box starts here-->
			    <div class=" col-md-4 col-md-offset-4 shadow animated pulse" id = "body_box" >

			    		<img style = "box-shadow: 5px 5px 5px #888888;" class="img-responsive" src="style/images/mcafelogo.png" alt="Umai"><br><br>
			    		

			      	
					  <form action="userAccessController" method ="POST" id = "boxForm">
					    <div class="form-group">
					      <input type="text" class="form-control" id="email" placeholder="Username" name="user_name" required>
					      </div>
					      <div class="form-group">
					      <input type="password" class="form-control" id="pwd" placeholder="Password" name="user_password" required>
					    </div>
					    
					    <button style="border-radius: 20px; background-color: #689350; color: #EEEEEE;" type="submit" class="btn btn-default btn-block">Submit</button>
					 </form>
				</div>
  
   <!--body box ends here-->


  </div>
</div>

</body>
</html>

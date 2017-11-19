<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Simple Sidebar - Start Bootstrap Template</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/simple-sidebar.css" rel="stylesheet">
    <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <title>M Cafe Dashboard</title>

</head>
<body>
    <nav class="navbar navbar-default no-margin"  style="background-color:#374787;">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header fixed-brand">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" style="background-color:#fff;" id="menu-toggle" >
                      <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
                    </button> 
                    <a class="navbar-brand" href="#" style="color:#fff;margin-top:5px;margin-left:5px;"> M-Cafe Restaurant</a>        
     </div><!-- navbar-header-->
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active" ><button class="navbar-toggle collapse in" data-toggle="collapse" id="menu-toggle-2"> <span style="color:#eee;"  class="glyphicon glyphicon-th-large" aria-hidden="true"></span></button></li>
                            </ul>
                

</div><!-- bs-example-navbar-collapse-1 -->
               
    </nav>
    <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper" style = "height:100%;">
            <ul class="sidebar-nav nav-pills nav-stacked" id="menu">
                <li>
                     <img style = "padding:25%;"class="img-responsive" src="style/images/mcafelogo.png" alt="LOGO"> 
                </li>
                <li>
                    <a href="PieChart"><span class="fa-stack fa-lg pull-left"><i class="fa fa-cloud-download fa-stack-1x "></i></span>Daily Sales Report</a>
                </li>
                <li>
                    <a href="RequisitionController"> <span class="fa-stack fa-lg pull-left"><i class="fa fa-cart-plus fa-stack-1x "></i></span>Requisition</a>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-youtube-play fa-stack-1x "></i></span>Costing</a>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-wrench fa-stack-1x "></i></span>Human Resource</a>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-server fa-stack-1x "></i></span>Contact</a>
                </li>
            </ul>
        </div><!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid xyz">



	
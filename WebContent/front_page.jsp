<head>
     
	  <title>M Cafe Dashboard</title>

	 
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="https://www.google.com/jsapi"></script>
	  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
      <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);
      //google.charts.setOnLoadCallback(drawChart1);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Name',Number],
          <c:forEach var="salesInfoList" items="${salesInfoList}">
           ['${salesInfoList[0]}', ${salesInfoList[1]}], 
      	  </c:forEach>
        ]);
        
        var options = {
          title: 'Daily Sales By Category',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
   
      

      google.load("visualization", "1.1", {
      packages: ["corechart"]
    });
    google.setOnLoadCallback(drawChart2);


    function drawChart2() {
    	 
        
        var data2 = google.visualization.arrayToDataTable([
           
           ['Weekly Sales', 'Total',],
           <c:forEach var="WeeklyTotalSales" items="${WeeklyTotalSales}">
              ['${WeeklyTotalSales[1]}', ${WeeklyTotalSales[0]},], 
       	</c:forEach>                                         
            
         
        ]);
        var options2 = {
            animation: {
                duration: 1500,
                startup: true
            }
        };
        chart2 = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart2.draw(data2, options2);
    }
      
    </script>
        <style>
		  @media screen and (min-width: 760px) {
			    .setWidth {
			        width: 650px;
			        height:400px;
			    }
			    .setWidth1 {
			        width: 550px;
			        height:300px;
			    }
			}
	  </style>
  </head>

    



<div class="container" style="margin-top:50px;">

      <div class="row">
        <div class="col-md-6"  align="center">
           <div id="piechart_3d" class="setWidth" style=""></div>
           <p style="margin-left:-70px;">Total Daily Sales</p>
         </div>
		 <div class="col-md-6" align="center" style="margin-top:30px;" >
              <div id="chart_div" class="setWidth1" style=""></div>
              <p style="margin-left:-70px;margin-top:70px;">Weekly Sales</p>
         </div>
      </div>

     
      <div class="row" style="margin-top:50px;">
        <div class="col-md-12">
           <h2>Highest Selling Items:</h2>
           <div style="margin-top:20px;">
	           <c:forEach var="highestSellingList" items="${highestSellingList}"  varStatus="counter">                      	
				 ${counter.count}. <c:out value="${highestSellingList[0]}"/>(<c:out value="${highestSellingList[1]}"/>)<br/>
	            </c:forEach> 
           </div>
           
         </div>
      </div>
    
      
     
</div>


</body>

</html>

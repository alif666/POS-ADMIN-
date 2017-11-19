<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);
      google.charts.setOnLoadCallback(drawChart1);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Name',Number],
     
          <c:forEach var="salesInfoList" items="${salesInfoList}">
          ['${salesInfoList[0]}', ${salesInfoList[1]}], 
      	</c:forEach>
        ]);
        
        var options = {
          title: 'Daily Sales By Category',
          //is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
      function drawChart1() {
          var data1 = google.visualization.arrayToDataTable([
                                                             
                        ['Element', 'Density', { role: 'style' }],
                        <c:forEach var="WeeklyTotalSales" items="${WeeklyTotalSales}">
                           ['${WeeklyTotalSales[1]}', ${WeeklyTotalSales[0]},'#b87333'], 
                    	</c:forEach>
                     

          ]);

          var options1 = {
            chart1: {
              title: 'Company Performance',
              subtitle: 'Sales, Expenses, and Profit: 2014-2017',
            }
          };

          var chart1 = new google.charts.Bar(document.getElementById('columnchart_material'));

          chart1.draw(data1, google.charts.Bar.convertOptions(options1));
        }
    </script>
  </head>
  <body>
  <div class="container">
     <div class="row">
        <div class="col-md-6" >
           <div id="piechart_3d" style="width: 700px; height: 500px;"></div>
         </div>
		  <div class="col-md-6" style="margin-top:40px;">
             <div id="columnchart_material" style="width: 450px; height: 400px;"></div>
            </div>
        </div>
     </div>
         
  </body>
</html>
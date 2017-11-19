package controller.salesReport;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SalesInfoDao;

/**
 * Servlet implementation class WeeklyProductWiseReport
 */
@WebServlet("/WeeklyProductWiseReport")
public class WeeklyProductWiseReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WeeklyProductWiseReport() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Object[]> salesDetailsList;
		SalesInfoDao salesInfoDao=new SalesInfoDao();
        
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();    
        String date2 = dateFormat.format(todate1);
        
        System.out.println("Today date: "+date1);
        System.out.println("Before 1 week: "+date2);
        salesDetailsList=salesInfoDao.getProductWiseList(date2,date1);
		for (Object[] aRow : salesDetailsList) {
		    System.out.println(aRow[0]);
		    System.out.println(aRow[1]);
		    System.out.println(aRow[2]);
		}
		
		  request.setAttribute("salesDetailsList", salesDetailsList);
	      RequestDispatcher rd=request.getRequestDispatcher("weekly_product_report.jsp");  
	      rd.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

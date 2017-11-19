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

import model.SalesInfo;
import dao.SalesInfoDao;

@WebServlet("/PieChart")
public class PieChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PieChart() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalesInfoDao salesInfoDao=new SalesInfoDao();
		List<Object[]> salesInfoList,WeeklyTotalSales,highestSellingList;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -6);
        Date todate1 = cal.getTime();    
        String date2 = dateFormat.format(todate1);
        
        System.out.println("Today date: "+date1);
        System.out.println("Before 1 week: "+date2);
        
		WeeklyTotalSales=salesInfoDao.getWeeklyTotalSales(date2,date1);
		salesInfoList=salesInfoDao.getCategoryWiseSales(date1);
//		for (Object[] aRow : WeeklyTotalSales) {
//		    System.out.println(aRow[0]);
//		    System.out.println(aRow[1]);
//		   // System.out.println(aRow[2]);
//		    
//		}
		highestSellingList=salesInfoDao.getProductWiseListTop5(date1);
		for (Object[] aRow : highestSellingList) {
		    System.out.println(aRow[0]);
		    System.out.println(aRow[1]);
		   // System.out.println(aRow[2]);
		    
		}
		request.setAttribute("salesInfoList", salesInfoList);
		request.setAttribute("WeeklyTotalSales", WeeklyTotalSales);
		request.setAttribute("highestSellingList", highestSellingList);
	    RequestDispatcher rd=request.getRequestDispatcher("test.jsp");
	    rd.forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

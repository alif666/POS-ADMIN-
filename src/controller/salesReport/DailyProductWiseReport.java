package controller.salesReport;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.HibernateUtil;
import dao.SalesDetailsDao;
import dao.SalesInfoDao;
import model.Recipe;
import model.SalesDetails;
import model.SalesInfo;

/**
 * Servlet implementation class DailyProductWiseReport
 */
@WebServlet("/DailyProductWiseReport")
public class DailyProductWiseReport extends HttpServlet {
	List<SalesDetails> salesList;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyProductWiseReport() {
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
		salesDetailsList=salesInfoDao.getProductWiseList(dateFormat.format(date));
		


		for (Object[] aRow : salesDetailsList) {
		    System.out.println(aRow[0]);
		    System.out.println(aRow[1]);
		    System.out.println(aRow[2]);

		}
		
		  request.setAttribute("salesDetailsList", salesDetailsList);
	      RequestDispatcher rd=request.getRequestDispatcher("daily_product_report.jsp");  
	      rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

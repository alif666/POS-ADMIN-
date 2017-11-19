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
import model.TotalCalculation;
import model.YearlyDetails;
import dao.SalesInfoDao;

/**
 * Servlet implementation class YearlyReportController
 */
@WebServlet("/YearlyReportController")
public class YearlyReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YearlyReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		SalesInfoDao salesInfoDao=new SalesInfoDao();
		List<YearlyDetails> yearlyDetails;
		yearlyDetails=salesInfoDao.getMonthDetails("2017");
			
		  request.setAttribute("yearlyDetails", yearlyDetails);
	      RequestDispatcher rd=request.getRequestDispatcher("yearly_report.jsp");
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

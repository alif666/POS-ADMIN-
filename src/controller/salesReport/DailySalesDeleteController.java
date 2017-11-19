package controller.salesReport;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SalesDetails;
import model.SalesInfo;
import dao.SalesDetailsDao;
import dao.SalesInfoDao;

/**
 * Servlet implementation class DailySalesDeleteController
 */
@WebServlet("/DailySalesDeleteController")
public class DailySalesDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailySalesDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long sessionId =Long.parseLong(request.getParameter("id"));
		SalesDetailsDao salesDetailsDao = new SalesDetailsDao();
		List<SalesDetails> salesList = salesDetailsDao.getListFromSameSession(sessionId);
		for(SalesDetails sd: salesList){
			salesDetailsDao.delete(sd);
		}
		
		
		SalesInfoDao salesInfoDao = new SalesInfoDao();
		salesInfoDao.delete((SalesInfo)salesInfoDao.checkDaoLong(sessionId));
		
		response.sendRedirect("DailySalesListController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package controller.salesReport;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import dao.SalesInfoDao;

/**
 * Servlet implementation class DailySalesListController
 */
@WebServlet("/DailySalesListController")
public class DailySalesListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailySalesListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		//System.out.println(dateFormat.format(date));
		
		SalesInfoDao salesInfoDao=new SalesInfoDao();
		List<SalesInfo> salesInfoList;
		salesInfoList=salesInfoDao.getTodayList(dateFormat.format(date));
		
		double totalVat=0,subTotal=0,orderTotal=0,totalCash=0,totalCard=0;
		for(SalesInfo list: salesInfoList){
			
			totalVat+=list.getVat();
			subTotal+=list.getSubTotal();
			System.out.print(subTotal+"");
			orderTotal+=list.getOrderTotal();
			totalCash+=Double.parseDouble(list.getCashAmount());
			totalCard+=Double.parseDouble(list.getCardAmount());
			
		}
		//rounding the value upto two decimals
			totalVat=Math.round(totalVat*100.0)/100.0;
			totalCash=Math.round(totalCash*100.0)/100.0;
			totalCard=Math.round(totalCard*100.0)/100.0;
		//rounding the value upto two decimals ends
		//SalesInfo si=new SalesInfo();
		
		TotalCalculation detailList=new TotalCalculation();
		detailList.setOrderTotal(orderTotal+"");
		detailList.setSubTotal(subTotal+"");
		detailList.setTotalCard(totalCard+"");
		detailList.setTotalCash(totalCash+"");
		detailList.setTotalVat(totalVat+"");
		
	
	  request.setAttribute("detailList", detailList);
	  request.setAttribute("salesInfoList", salesInfoList);
      RequestDispatcher rd=request.getRequestDispatcher("report.jsp");  
      rd.forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		String fromDate = request.getParameter("from_date");
		String toDate = request.getParameter("to_date");
		SalesInfoDao salesInfoDao = new SalesInfoDao();
		List<SalesInfo> salesInfoList = salesInfoDao.getCustomList(fromDate, toDate);
			
		//getting custom list 
				double totalVat=0,subTotal=0,orderTotal=0,totalCash=0,totalCard=0;
				for(SalesInfo list: salesInfoList){
					
					totalVat+=list.getVat();
					subTotal+=list.getSubTotal();
					System.out.print(subTotal+"");
					orderTotal+=list.getOrderTotal();
					totalCash+=Double.parseDouble(list.getCashAmount());
					totalCard+=Double.parseDouble(list.getCardAmount());
					
				}
				//rounding the value upto two decimals
					totalVat=Math.round(totalVat*100.0)/100.0;
					totalCash=Math.round(totalCash*100.0)/100.0;
					totalCard=Math.round(totalCard*100.0)/100.0;
				//rounding the value upto two decimals ends
				//SalesInfo si=new SalesInfo();
				
				TotalCalculation detailList=new TotalCalculation();
				detailList.setOrderTotal(orderTotal+"");
				detailList.setSubTotal(subTotal+"");
				detailList.setTotalCard(totalCard+"");
				detailList.setTotalCash(totalCash+"");
				detailList.setTotalVat(totalVat+"");
				
			
			  request.setAttribute("detailList", detailList);
			  request.setAttribute("salesInfoList", salesInfoList);
		      RequestDispatcher rd=request.getRequestDispatcher("report.jsp");  
		      rd.forward(request, response); 
		//getting custom list ends
		
	}

}

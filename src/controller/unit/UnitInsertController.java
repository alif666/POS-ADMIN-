package controller.unit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;
import dao.UnitDao;

/**
 * Servlet implementation class UnitInsertController
 */
@WebServlet("/UnitInsertController")
public class UnitInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnitInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	      RequestDispatcher rd=request.getRequestDispatcher("unit_insert.jsp");  
          rd.forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String unitName = request.getParameter("unit_name");
		UnitDao unitdao = new UnitDao();
		Unit unit = new Unit();
		unit.setUnitName(unitName);
		
		unitdao.insert(unit);
		response.sendRedirect("UnitListController");
		
		
	}

}

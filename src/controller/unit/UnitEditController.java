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
 * Servlet implementation class UnitEditController
 */
@WebServlet("/UnitEditController")
public class UnitEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnitEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int unitId = Integer.parseInt(request.getParameter("id"));
		
		UnitDao unitdao = new UnitDao();
		Unit unit = new Unit();
		unit = (Unit) unitdao.checkdao(unitId);
	    request.setAttribute("unit", unit);
	    RequestDispatcher rd=request.getRequestDispatcher("unit_edit.jsp");  
        rd.forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String unitName = request.getParameter("unit_name");
		int id = Integer.parseInt(request.getParameter("unit_id"));
		
		UnitDao unitdao = new UnitDao();
		Unit unit = new Unit();
		unit =(Unit) unitdao.checkdao(id);
		unit.setUnitName(unitName);

		unitdao.update(unit);
		response.sendRedirect("UnitListController");
	}

}

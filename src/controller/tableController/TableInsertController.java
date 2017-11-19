package controller.tableController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tables;
import dao.TableDao;

/**
 * Servlet implementation class TableInsertController
 */
@WebServlet("/TableInsertController")
public class TableInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   RequestDispatcher rd=request.getRequestDispatcher("table_create.jsp");  
	          rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int tableNumber = Integer.parseInt(request.getParameter("table_number"));
		System.out.println("Table number is "+tableNumber);
		TableDao tabledao = new TableDao();
		for(int i = 0;i<=tableNumber;i++)
		{
			
			Tables tables = new Tables();
			tables.setTableName("table "+i);
			tables.setTableStatus("unoccupied");
			tabledao.insert(tables);
		}
		
		response.sendRedirect("TableInsertController");
	}

}

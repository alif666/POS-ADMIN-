package controller.ingredientsCategory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IngredientsCategory;
import model.Unit;
import dao.IngredientsCategoryDao;

/**
 * Servlet implementation class IngredientsCategoryDeleteController
 */
@WebServlet("/IngredientsCategoryDeleteController")
public class IngredientsCategoryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngredientsCategoryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int categoryId = Integer.parseInt(request.getParameter("id"));
		IngredientsCategory category = new IngredientsCategory();
		
		IngredientsCategoryDao categorydao= new IngredientsCategoryDao();
		
		category =(IngredientsCategory) categorydao.checkdao(categoryId);
		categorydao.delete(category);
		response.sendRedirect("IngredientsCategoryListController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

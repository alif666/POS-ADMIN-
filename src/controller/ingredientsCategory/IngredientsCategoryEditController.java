package controller.ingredientsCategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IngredientsCategory;
import model.Unit;
import dao.IngredientsCategoryDao;
import dao.UnitDao;

/**
 * Servlet implementation class IngredientsCategoryEditController
 */
@WebServlet("/IngredientsCategoryEditController")
public class IngredientsCategoryEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngredientsCategoryEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int categoryId = Integer.parseInt(request.getParameter("id"));
		IngredientsCategoryDao ingredientsCategoryDao= new IngredientsCategoryDao();
		IngredientsCategory category= new IngredientsCategory();
		category = (IngredientsCategory) ingredientsCategoryDao.checkdao(categoryId);
	    request.setAttribute("category", category);
	    RequestDispatcher rd=request.getRequestDispatcher("ingredients_category_edit.jsp");  
        rd.forward(request, response); 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String categoryName = request.getParameter("category_name");
		int id = Integer.parseInt(request.getParameter("category_id"));
		
		IngredientsCategoryDao categorydao = new IngredientsCategoryDao();
		IngredientsCategory category = new IngredientsCategory();
		category =(IngredientsCategory) categorydao.checkdao(id);
		category.setIngredientsCategoryName(categoryName);

		categorydao.update(category);
		response.sendRedirect("IngredientsCategoryListController");
		
		
	}

}

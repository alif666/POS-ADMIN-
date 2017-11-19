package controller.ingredientsCategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IngredientsCategory;
import dao.IngredientsCategoryDao;

/**
 * Servlet implementation class IngredientsCategoryInsertController
 */
@WebServlet("/IngredientsCategoryInsertController")
public class IngredientsCategoryInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngredientsCategoryInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      RequestDispatcher rd=request.getRequestDispatcher("ingredients_category_insert.jsp");  
          rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Came to ingredients servlet");
		String ingredientsCategoryName = request.getParameter("ingredients_category_name");
		IngredientsCategory category = new IngredientsCategory();
		IngredientsCategoryDao categoryDao = new IngredientsCategoryDao();
		category.setIngredientsCategoryName(ingredientsCategoryName);
		categoryDao.insert(category);
		System.out.println("Insert Successfull");
		response.sendRedirect("IngredientsCategoryListController");
	}

}

package controller.recipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RecipeIngredients;
import dao.RecipeIngredientsDao;

/**
 * Servlet implementation class RecipeIngredientsController
 */
@WebServlet("/RecipeIngredientsController")
public class RecipeIngredientsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeIngredientsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int recipeId = Integer.parseInt(request.getParameter("id"));
		System.out.println(recipeId);
		RecipeIngredientsDao riDao = new RecipeIngredientsDao();
		List<RecipeIngredients> ri = riDao.showRecipeIngredients(recipeId);

		request.setAttribute("ri", ri);
	    RequestDispatcher rd=request.getRequestDispatcher("recipe_ingredients_list.jsp");  
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

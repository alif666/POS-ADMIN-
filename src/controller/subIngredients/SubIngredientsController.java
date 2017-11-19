package controller.subIngredients;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IngredientSubIngredient;
import model.RecipeIngredients;
import dao.IngredientSubIngredientDao;
import dao.RecipeIngredientsDao;
import dao.SubIngredientsDao;

/**
 * Servlet implementation class SubIngredientsController
 */
@WebServlet("/SubIngredientsController")
public class SubIngredientsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subIngredientId = Integer.parseInt(request.getParameter("id"));
		System.out.println(subIngredientId);
		IngredientSubIngredientDao siDao = new IngredientSubIngredientDao();
		List<IngredientSubIngredient> si = siDao.showIngredients(subIngredientId);

		request.setAttribute("si", si);
	
	    RequestDispatcher rd=request.getRequestDispatcher("subingredient_ingredients_list.jsp");  
        rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

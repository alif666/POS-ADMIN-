package controller.ingredients;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredients;
import model.IngredientsCategory;
import model.Unit;
import dao.IngredientsCategoryDao;
import dao.IngredientsDao;
import dao.UnitDao;

/**
 * Servlet implementation class IngredientsEditController
 */
@WebServlet("/IngredientsEditController")
public class IngredientsEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngredientsEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ingredientsId = Integer.parseInt(request.getParameter("id"));
		
		IngredientsDao ingredientsdao= new IngredientsDao();
		Ingredients ingredients = new Ingredients();
		ingredients = (Ingredients) ingredientsdao.checkdao(ingredientsId);
		IngredientsCategoryDao categorydao = new IngredientsCategoryDao();
		List<IngredientsCategory> category = categorydao.view();
		UnitDao unitdao = new UnitDao();
		List<Unit> units = unitdao.view();
		
		request.setAttribute("units", units);
		request.setAttribute("category", category);
	    request.setAttribute("ingredients", ingredients);
	    RequestDispatcher rd=request.getRequestDispatcher("ingredients_edit.jsp");  
        rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("ingredients_id"));
		String  name = request.getParameter("ingredients_name");
		
		IngredientsDao ingredientsdao = new IngredientsDao();
		Ingredients ingredients = new Ingredients();
		ingredients = (Ingredients)ingredientsdao.checkdao(id);
		
		if(!request.getParameter("per_day_consumption").isEmpty()){
			String perDayConsumption = request.getParameter("per_day_consumption");
			ingredients.setPerDayConsumption(Double.parseDouble(perDayConsumption));
		}
		if(!request.getParameter("equ_ratio").isEmpty()){
			String equRatio = request.getParameter("equ_ratio");
			ingredients.setEquivalentRatio(Double.parseDouble(equRatio));
		}
		if(!request.getParameter("min_qty").isEmpty()){
			String minQty = request.getParameter("min_qty");
			ingredients.setMinimumStock(Double.parseDouble(minQty));
		}
		if(!request.getParameter("livestock").isEmpty()){
			String livestock = request.getParameter("livestock");
			ingredients.setLivestock(Double.parseDouble(livestock));
		}

		
		
		ingredients.setId(id);
		ingredients.setName(name);

		
		ingredientsdao.update(ingredients);
		response.sendRedirect("IngredientsListController");
		
	}

}

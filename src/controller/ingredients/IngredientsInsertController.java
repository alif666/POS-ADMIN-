package controller.ingredients;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sun.imageio.plugins.common.SubImageInputStream;

import model.Ingredients;
import model.IngredientsCategory;

import model.Unit;
import dao.HibernateUtil;
import dao.IngredientsCategoryDao;
import dao.IngredientsDao;
import dao.UnitDao;

/**
 * Servlet implementation class IngredientsInsertController
 */
@WebServlet("/IngredientsInsertController")
public class IngredientsInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngredientsInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UnitDao unitdao = new UnitDao();
		List<Unit> units = unitdao.view();
		
		IngredientsCategoryDao categoryDao = new IngredientsCategoryDao();
		List<IngredientsCategory> category = categoryDao.view();
		
		IngredientsDao ingredientsdao = new IngredientsDao();
		List<Ingredients> ingredients = ingredientsdao.view();
		
		request.setAttribute("ingredients", ingredients);
		request.setAttribute("units", units);
		request.setAttribute("category", category);
		
	     RequestDispatcher rd=request.getRequestDispatcher("ingredients_insert.jsp");  
 	     rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Ingredients ingredients = new Ingredients();
		IngredientsDao ingredientsdao = new IngredientsDao();
		
		
		String ingredientsName = request.getParameter("ingredients_name");
		int categoryId = Integer.parseInt(request.getParameter("category_type"));


		int unitId = Integer.parseInt(request.getParameter("unit_type"));
		int equUnitId = Integer.parseInt(request.getParameter("equ_unit_type"));
		String equRatio = request.getParameter("equ_ratio");
		String minQty = request.getParameter("min_qty");
		String liveStock=request.getParameter("livestock");
		

		

		IngredientsCategoryDao categoryDao = new IngredientsCategoryDao();
		ingredients.setName(ingredientsName);
		ingredients.setCategoryId((IngredientsCategory) categoryDao.checkdao(categoryId));
		if(!request.getParameter("per_day_consumption").isEmpty()){
			String perDayConsumption = request.getParameter("per_day_consumption");
			ingredients.setPerDayConsumption(Double.parseDouble(perDayConsumption));
		}
		
		if(!request.getParameter("wastage").isEmpty()){
			String wastage = request.getParameter("wastage");
			ingredients.setWastage(Double.parseDouble(wastage));
		}
		
		UnitDao unitdao = new UnitDao();
		ingredients.setUnitId((Unit)unitdao.checkdao(unitId));
		ingredients.setEquivalentUnit(((Unit)unitdao.checkdao(equUnitId)));
		ingredients.setEquivalentRatio(Double.parseDouble(equRatio));
		ingredients.setMinimumStock(Double.parseDouble(minQty));
		ingredients.setLivestock(Double.parseDouble(liveStock));
		ingredientsdao.insert(ingredients);
		response.sendRedirect("IngredientsListController");
		
		
	}

}

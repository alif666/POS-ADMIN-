package controller.recipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredients;
import model.MenuCategory;
import model.Recipe;
import model.RecipeIngredients;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.HibernateUtil;
import dao.IngredientsDao;
import dao.MenuCategoryDao;
import dao.RecipeIngredientsDao;

/**
 * Servlet implementation class RecipeInsertController
 */
@WebServlet("/RecipeInsertController")
public class RecipeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IngredientsDao ingredientsdao = new IngredientsDao();
		List<Ingredients> ingredients = ingredientsdao.view();
		
		MenuCategoryDao categorydao = new MenuCategoryDao();
		List<MenuCategory> categories = categorydao.view();
		
		
		request.setAttribute("categories", categories);
		request.setAttribute("ingredients", ingredients);
		RequestDispatcher rd=request.getRequestDispatcher("recipe_insert.jsp");  
	     rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vatType = request.getParameter("vatType");
		System.out.println(vatType);

		String recipeName = request.getParameter("recipe_name");
		String recipePrice = request.getParameter("recipe_price");
		String[] quantity = new String[2];
		quantity = request.getParameterValues("qty[]");
		int menuCategoryId = Integer.parseInt(request.getParameter("category_type"));
		MenuCategoryDao menuDao = new MenuCategoryDao();
		MenuCategory menuCategory  =new MenuCategory();
		menuCategory = (MenuCategory)menuDao.checkdao(menuCategoryId);
		
		

		
		Ingredients ingredient = new Ingredients();
		IngredientsDao ingredientsdao = new IngredientsDao();
		RecipeIngredientsDao riDao = new RecipeIngredientsDao();
		
		Recipe recipe = new Recipe();
		recipe.setName(recipeName);
		recipe.setCategory(menuCategory);
		recipe.setPrice(recipePrice);
		if(vatType.contains("inclusive")){
			recipe.setNetPrice(recipePrice);
		}else if(vatType.contains("exclusive")){
			recipe.setNetPrice(0+"");
		}
		
		
		SessionFactory sessionFactory;
		sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		System.out.println("No Recipe");

			String[] ingredients = new String[2];
			ingredients = request.getParameterValues("ingredients[]");
			for(int i = 0 ;i<ingredients.length;i++)
			{
				session.beginTransaction();
				RecipeIngredients ri = new RecipeIngredients();
				if(ingredients[i].contains("NoIngredients")){
					System.out.println("no ingredients");
				}else{
					ingredient =(Ingredients) ingredientsdao.checkdao(Integer.parseInt(ingredients[i]));
					ri.setIngredients(ingredient);
				}

				ri.setRecipe(recipe);
				ri.setQuantity(Double.parseDouble(quantity[i]));
				System.out.println("Ingredients is "+ingredient.getName()+"Quantity is "+quantity[i]);
				session.persist(ri);
				session.getTransaction().commit();
			}
		

		
		session.close();
		System.out.println("Insert Successfull");
		response.sendRedirect("RecipeListController");
	}

}

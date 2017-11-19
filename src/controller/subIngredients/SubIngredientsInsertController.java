package controller.subIngredients;

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

import model.IngredientSubIngredient;
import model.Ingredients;
import model.SubIngredients;
import dao.HibernateUtil;
import dao.IngredientSubIngredientDao;
import dao.IngredientsDao;
import dao.SubIngredientsDao;


@WebServlet("/SubIngredientsInsertController")
public class SubIngredientsInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IngredientsDao ingredientsdao = new IngredientsDao();
		List<Ingredients> ingredients = ingredientsdao.view();
		request.setAttribute("ingredients", ingredients);
		RequestDispatcher rd=request.getRequestDispatcher("sub_ingredients_create.jsp");  
 	    rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subIngredientsName = request.getParameter("sub_ingredient_name");
		
		String[] quantity = new String[2];
        quantity = request.getParameterValues("qty[]");
		
        String[] ingredients = new String[2];
		ingredients = request.getParameterValues("ingredients[]");
		
		Ingredients ing=new Ingredients();
		IngredientsDao ingredientsdao=new IngredientsDao();
		
		SubIngredients sub=new SubIngredients();
		sub.setName(subIngredientsName);
		
		
	   // SubIngredientsDao subIngredientsDao=new SubIngredientsDao();
	    //subIngredientsDao.insert(sub);
		

		SessionFactory sessionFactory;
		sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		for(int i = 0; i<ingredients.length;i++)
		{
			session.beginTransaction();
			System.out.println("Ingredients is "+ingredients[i]+" and the quantity is "+quantity[i]);
			//IngredientSubIngredientDao dao=new IngredientSubIngredientDao();
			IngredientSubIngredient ingred_sub=new IngredientSubIngredient();
			ing=(Ingredients)ingredientsdao.checkdao(Integer.parseInt(ingredients[i]));
			ingred_sub.setIngredients(ing);
			ingred_sub.setSubIngredients(sub);
			ingred_sub.setQuantity(Integer.parseInt(quantity[i]));
            //dao.insert(ingred_sub);
			session.persist(ingred_sub);
            session.getTransaction().commit();
			
		}
		session.close();
		
		response.sendRedirect("SubIngredientsListController");

	}

}

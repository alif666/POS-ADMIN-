package controller.subIngredients;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IngredientSubIngredient;
import model.Ingredients;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.HibernateUtil;
import dao.SubIngredientsDao;

/**
 * Servlet implementation class SubIngredientsEditController
 */
@WebServlet("/SubIngredientsEditController")
public class SubIngredientsEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subIngredientId = Integer.parseInt(request.getParameter("id"));
		//System.out.println(subIngredientId);
		//SubIngredients subIngredient=new SubIngredients();
		//SubIngredientsDao subIngredientDao = new SubIngredientsDao();
		
		//subIngredient =(SubIngredients) subIngredientDao.checkdao(subIngredientId);
//		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//
//		Query query=session.createQuery("FROM IngredientSubIngredient s WHERE s.ingredients.id='"+subIngredientId+"'");
//		List<IngredientSubIngredient> ingredients=(List<IngredientSubIngredient>)query.list();
//		for(IngredientSubIngredient ingredient:ingredients){
//			System.out.print(ingredient.getIngredients().getName());
//		}
//		session.getTransaction().commit();
//		session.close();
		
		System.out.println(subIngredientId);
		response.sendRedirect("SubIngredientsListController");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

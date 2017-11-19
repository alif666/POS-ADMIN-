package controller.subIngredients;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SubIngredients;
import dao.SubIngredientsDao;



/**
 * Servlet implementation class SubIngredientDeleteController
 */
@WebServlet("/SubIngredientDeleteController")
public class SubIngredientDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subIngredientId = Integer.parseInt(request.getParameter("id"));
		//System.out.println(subIngredientId);
		SubIngredients subIngredient=new SubIngredients();
		SubIngredientsDao subIngredientDao = new SubIngredientsDao();
		
		subIngredient =(SubIngredients) subIngredientDao.checkdao(subIngredientId);
		subIngredientDao.delete(subIngredient);
		response.sendRedirect("SubIngredientsListController");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import model.SubIngredients;
import dao.IngredientSubIngredientDao;
import dao.IngredientsDao;
import dao.SubIngredientsDao;


@WebServlet("/SubIngredientsListController")
public class SubIngredientsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubIngredientsDao dao=new SubIngredientsDao();
        List<SubIngredients> subIngredients=dao.view();
       // for(SubIngredient sub:sub_ingred){
        	//int ingredientId=Integer.parseInt(sub.getIngredients());
        	//IngredientsDao ingredientdao=new IngredientsDao();
        	//System.out.print(sub.getName());
        	
        	
        //}
        request.setAttribute("subIngredients", subIngredients);
	      RequestDispatcher rd=request.getRequestDispatcher("sub_ingredients_list.jsp");  
        rd.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

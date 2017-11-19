package controller.menuCategory;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IngredientsCategory;
import model.MenuCategory;
import dao.IngredientsCategoryDao;
import dao.MenuCategoryDao;

/**
 * Servlet implementation class MenuCategoryListController
 */
@WebServlet("/MenuCategoryListController")
public class MenuCategoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  MenuCategoryDao categorydao= new MenuCategoryDao();
		  List<MenuCategory> category= categorydao.view();
	      request.setAttribute("category", category);
	      
	      System.out.println("No error upto this");
	      RequestDispatcher rd=request.getRequestDispatcher("menu_category_list.jsp");  
          rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("now you have to update ");
	}

}

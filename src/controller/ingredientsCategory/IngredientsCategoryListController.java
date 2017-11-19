package controller.ingredientsCategory;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IngredientsCategory;
import dao.IngredientsCategoryDao;

/**
 * Servlet implementation class IngredientsCategoryListController
 */
@WebServlet("/IngredientsCategoryListController")
public class IngredientsCategoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngredientsCategoryListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  IngredientsCategoryDao categorydao= new IngredientsCategoryDao();
		  List<IngredientsCategory> category= categorydao.view();
	      request.setAttribute("category", category);
	      
	      System.out.println("No error upto this");
	      RequestDispatcher rd=request.getRequestDispatcher("ingredients_category_list.jsp");  
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

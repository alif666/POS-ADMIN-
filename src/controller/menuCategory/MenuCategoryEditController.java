package controller.menuCategory;

import java.io.IOException;

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
 * Servlet implementation class MenuCategoryEditController
 */
@WebServlet("/MenuCategoryEditController")
public class MenuCategoryEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		MenuCategoryDao categoryDao= new MenuCategoryDao();
		MenuCategory category= new MenuCategory();
		category = (MenuCategory) categoryDao.checkdao(categoryId);
	    request.setAttribute("category", category);
	    RequestDispatcher rd=request.getRequestDispatcher("menu_category_edit.jsp");  
        rd.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = request.getParameter("category_name");
		String categoryColor= request.getParameter("category_color");
		int id = Integer.parseInt(request.getParameter("category_id"));
		
		MenuCategoryDao categorydao = new MenuCategoryDao();
		MenuCategory category = new MenuCategory();
		category =(MenuCategory)categorydao.checkdao(id);
		category.setMenuCategoryName(categoryName);
		category.setMenuCategoryColor(categoryColor);

		categorydao.update(category);
		response.sendRedirect("MenuCategoryListController");
	}

}

package controller.menuCategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MenuCategory;
import dao.IngredientsCategoryDao;
import dao.MenuCategoryDao;


@WebServlet("/MenuCategoryInsertController")
public class MenuCategoryInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   RequestDispatcher rd=request.getRequestDispatcher("menu_category_insert.jsp");  
	          rd.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String menuCategoryName = request.getParameter("menu_category_name");
		String menuCategoryColor = request.getParameter("menu_category_color");
		MenuCategory category = new MenuCategory();
		MenuCategoryDao categoryDao = new MenuCategoryDao();
		category.setMenuCategoryName(menuCategoryName);
		category.setMenuCategoryColor(menuCategoryColor);
		categoryDao.insert(category);
		
		System.out.println("Insert Successfull");
		response.sendRedirect("MenuCategoryListController");
	}

}

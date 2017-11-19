package controller.menuCategory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MenuCategory;
import dao.MenuCategoryDao;


@WebServlet("/MenuCategoryDeleteController")
public class MenuCategoryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		MenuCategory category = new MenuCategory();
		
		MenuCategoryDao categorydao= new MenuCategoryDao();
		
		category =(MenuCategory) categorydao.checkdao(categoryId);
		categorydao.delete(category);
		response.sendRedirect("MenuCategoryListController");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

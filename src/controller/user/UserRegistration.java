package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import model.Unit;
import model.UserType;
import model.Users;
import dao.UnitDao;
import dao.UserDao;
import dao.UserTypeDao;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	Users userModel = new Users();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  UserDao userDao= new UserDao();
		  List<Users> userList = userDao.view();
	      request.setAttribute("userList",userList);
	      RequestDispatcher rd=request.getRequestDispatcher("user_creation.jsp");  
          rd.forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("user_type").isEmpty()){
			response.sendRedirect("user_creation.jsp");
		}else{
			String userType = request.getParameter("user_type");
			System.out.println("The user type that came is "+userType);
			UserTypeDao userTypeDao = new UserTypeDao();
			UserType userTypeModel = userTypeDao.getUserType(userType);
			
			userModel.setUserType(userTypeModel);
		}
		
		if(request.getParameter("user_name").isEmpty()){
			response.sendRedirect("user_creation.jsp");
		}else{
			String userName = request.getParameter("user_name");
			userModel.setUserName(userName);
		}
		
		if(request.getParameter("user_password").isEmpty()){
			response.sendRedirect("user_creation.jsp");
		}else{
			EncryptPassword e = new EncryptPassword();
			String userPassword = request.getParameter("user_password");
			userModel.setUserPassword(e.encrypt(userPassword));
		}
		
		if(request.getParameter("user_email").isEmpty()){
			response.sendRedirect("user_creation.jsp");
		}else{
			String userPassword = request.getParameter("user_email");
			userModel.setUserEmail(userPassword);
		}
		
		UserDao userDao = new UserDao();
		userDao.insert(userModel);
		response.sendRedirect("UserRegistration");
		
	}

}

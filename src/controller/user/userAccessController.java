package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Users;

import dao.UserDao;

/**
 * Servlet implementation class userAccessController
 */
@WebServlet("/userAccessController")
public class userAccessController extends HttpServlet {
	HttpSession httpsession;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userAccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//initializing the classes that is needed to run this script

	EncryptPassword e = new EncryptPassword();
	//initializing the classes that is needed to run this script ends
	

	String userName = request.getParameter("user_name");
	String userPassword = e.encrypt(request.getParameter("user_password"));
	System.out.println(userName+" is the given userName ");
	System.out.println(userPassword+" is the given userPassword");
	
	

	
	Users userModel = new Users();
	
	userModel.setUserName(userName);
	userModel.setUserPassword(userPassword);
	
	UserDao userDao = new UserDao();
	boolean status = userDao.validate(userModel.getUserName(),userModel.getUserPassword());
	System.out.println(status+" IS THE STATUS OF THE CHECK");
	//checking if the user exists in the database
		if(status){
			userModel = (Users)userDao.getUser(userModel.getUserName(),userModel.getUserPassword());
			httpsession = request.getSession();
			httpsession.setAttribute("user_name", userModel.getUserName());
			httpsession.setAttribute("user_image",userModel.getUserImage());
			
			response.sendRedirect("dashboard.jsp");
			
		}else{
			response.sendRedirect("index.jsp");
		}

	
	}
}

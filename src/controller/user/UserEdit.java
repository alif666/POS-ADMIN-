package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserType;
import model.Users;
import dao.UserDao;
import dao.UserTypeDao;




@WebServlet("/UserEdit")
public class UserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Users user = new Users();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userdao = new UserDao();
		int id = Integer.parseInt(request.getParameter("id"));

		
		user = (Users)userdao.checkdao(id);
		request.setAttribute("user", user);
		
		UserTypeDao typedao = new UserTypeDao();
		List<UserType> all_types;
		all_types=typedao.view();
		request.setAttribute("all_types", all_types);
		RequestDispatcher rd=request.getRequestDispatcher("user_edit.jsp");  
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID=Integer.parseInt(request.getParameter("userid"));	
		int userTypeID=Integer.parseInt(request.getParameter("user_type"));	
		String userName=request.getParameter("user_name");
 		String userEmail=request.getParameter("user_email");	
 		String userPassword=request.getParameter("user_password");	
 		
		//String uType="customer";

		 
		 
		 UserTypeDao typedao=new UserTypeDao();
		 UserType userType=(UserType) typedao.checkdao(userTypeID);
		 
		 Users user=new Users();
		    user.setId(userID);
		    user.setUserName(userName);
		    user.setUserEmail(userEmail);
		 	user.setUserType(userType);
		    if(userPassword!=null || userPassword!=""){	
		        EncryptPassword ep=new EncryptPassword();
				String encrypt_pwd=ep.encrypt(userPassword);
			    user.setUserPassword(encrypt_pwd);		
		    }
		 UserDao userdao= new UserDao();
	 	 userdao.update(user);
		 
	      response.sendRedirect("UserList");
	}

}

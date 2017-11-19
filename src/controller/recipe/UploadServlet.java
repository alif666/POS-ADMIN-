package controller.recipe;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

  
public class UploadServlet extends HttpServlet {  
	  
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	    throws ServletException, IOException {  
	  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String realPath = getServletContext().getRealPath("");
		File destinationDir = new File(realPath);
		//File directory = new File(directoryPath);
		System.out.println(realPath);
		/*if(!directory.exists()) {
		    directory.mkdirs();
		}   */ 
		MultipartRequest m=new MultipartRequest(request,"C://xampp//htdocs//umai//images");  
	    out.print("successfully uploaded");  
	}  
}  	
package controller.requisition;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredients;
import model.ReqIngredients;
import model.Requisition;
import dao.IngredientsDao;
import dao.ReqIngredientsDao;
import dao.RequisitionDao;

/**
 * Servlet implementation class RequisitionController
 */
@WebServlet("/RequisitionController")
public class RequisitionController extends HttpServlet {
	String msg;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequisitionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Ingredients ingredients = new Ingredients();	
		IngredientsDao ingredientsDao = new IngredientsDao();
		
		List<Ingredients> ingredientsList = ingredientsDao.view();
		if(msg==null){
			msg = "Submit Requisition";
			
		}
		
	      request.setAttribute("ingredientsList", ingredientsList);
	      RequestDispatcher rd=request.getRequestDispatcher("requisition.jsp?msg="+msg);  
	      rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String[] checkBoxValues = request.getParameterValues("checkbox");
		if(!(checkBoxValues==null)){
			
			

			String[] quantities = request.getParameterValues("qty[]");
			if(!(quantities==null)){
			
			List<String> intQuantity = new ArrayList();
			
			for(int i = 0; i < quantities.length; i++){
				System.out.println("The quantity is "+quantities[i]);
				if(!(quantities[i].equals("0"))){
						intQuantity.add(quantities[i]);
	
							}
						}
							System.out.println("The size is "+intQuantity.size());
							String[] ingredientsQuantity = new String[intQuantity.size()];
							int j =0;
							for(String s: intQuantity){
								ingredientsQuantity[j]=s;
								j++;
							}
				//debugging ingredientsQuantity
					for(int i = 0;i<ingredientsQuantity.length;i++){
						System.out.println("The ingredientsQuantity is "+ingredientsQuantity[i]);
					}
				//debugging ingredientsQuantity ends
				
	//check if quantity and ingredients has the same size
			if(checkBoxValues.length==ingredientsQuantity.length){
					Requisition r = new Requisition();
					r.setDate(new Date());
					r.setStatus(false);
					RequisitionDao rDao = new RequisitionDao();
					rDao.insert(r);
					
					
					
					for(int i = 0 ; i<checkBoxValues.length ; i++){
						ReqIngredients ri = new ReqIngredients();	
						System.out.println("The ingredients is "+checkBoxValues[i]+ " with the quantity is "+ingredientsQuantity[i]);
						Ingredients ingredients = new Ingredients();
						IngredientsDao ingredientsDao = new IngredientsDao();
						ri.setIngredient((Ingredients)ingredientsDao.checkdao(Integer.parseInt(checkBoxValues[i])));
						ri.setRequisition(r);
						ri.setQuantity(Double.parseDouble(ingredientsQuantity[i]));
						
						ReqIngredientsDao riDao = new ReqIngredientsDao();
						riDao.insert(ri);
						out.println("<html><body>");
						out.println("<h1>Requisition Successful</h1>");
						out.println("</body></html>");
						System.out.println("Requisition Successful");
						msg = "Requisition Successfull";
					}
				
			}else{
				out.println("<html><body>");
				out.println("<h1>Some Problem With the requisition0"
						+ ".</h1>");
				out.println("</body></html>");
				msg = "Some Problem With The Requisition";
				System.out.println("Some Problem With The Requisition");
			}
	//check if quantity and ingredients has the same size ends
			
			}else{
				out.println("<html><body>");
				out.println("<h1>No Quantity Found</h1>");
				out.println("</body></html>");
				
				System.out.println("No quantity found");
				msg = "No Quantity Found";
			}

		}else{
	        System.out.println("No Ingredients Or Quantity selected");
	        msg = "No Ingredients Or Quantity selected";
		}
		response.sendRedirect("RequisitionController");
		
	}


}

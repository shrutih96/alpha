package serve;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServe
 */
@WebServlet("/LoginServe")
public class LoginServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String userID = request.getParameter("id");
    	String password = request.getParameter("password");
    	String ui=userID.trim();
    	ServletContext cnxt = getServletContext();
    	System.out.println(cnxt.getInitParameter("Project"));
    	
    	PrintWriter pw= response.getWriter();
    	
    	Connection con=DBConnect.getConnection();
    	boolean flag=DBConnect.validateUser(ui, password, con);
    	
    	 if(flag){
        	 
        	 if(ui.toUpperCase().equals("ADMIN")){
        		 
        			RequestDispatcher rd= request.getRequestDispatcher("AdminPage.jsp");
                   	rd.forward(request, response);
                   	
        	 }
        	 else {
        		 
        	   RequestDispatcher rd= request.getRequestDispatcher("Registration.jsp");
        	   rd.forward(request, response);
              	
        	 }
    	 }
           else{
           	
           	response.setContentType("text/html");
           	pw.println("<h3 style='color:red'>You have entered wrong username and password</h3>"); 	
           	RequestDispatcher rd= request.getRequestDispatcher("index.html");
           	rd.include(request, response);
           }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

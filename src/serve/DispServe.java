package serve;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispServe
 */
@WebServlet("/DispServe")
public class DispServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("DispServe");
		
		String userID = request.getParameter("name");
		System.out.println(userID);
		ServletContext cnxt = getServletContext();
    	System.out.println(cnxt.getInitParameter("Project"));
    	
    	PrintWriter pw= response.getWriter();
    	
		Connection con=DBConnect.getConnection();
		
		ArrayList<Data> al=DBConnect.display(userID,con);
		
    	if(al.size()!=0){
    		request.setAttribute("employee", al);
     	   RequestDispatcher rd= request.getRequestDispatcher("Display.jsp");
           	rd.forward(request, response);
        }
 	
        else{
        	
        	response.setContentType("text/html");
        	pw.println("<h3 style='color:red'>No details available</h3>"); 	
        	RequestDispatcher rd= request.getRequestDispatcher("AdminPage.jsp");
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


import java.io.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

/**
 * Servlet implementation class customer_db
 */
@WebServlet("/customer_db")
public class customer_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customer_db() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int cid=Integer.parseInt(request.getParameter("cid"));
		//String id=request.getParameter("requests");
		int status=-1;
		int service=Integer.parseInt(request.getParameter("requests"));
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");    
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
			System.out.println("connection established"+con);
			Random rand = new Random();
			int n = rand.nextInt(50) + 1;
			Statement stmt=con.createStatement(); 
			String str1="INSERT INTO cust values('"+name+"','"+email+"',"+service+","+status+","+cid+","+n+")";
			stmt.executeUpdate(str1);
			//System.out.println(str1);
			HttpSession session1 = request.getSession();
			String d=session1.getId();
			session1.setAttribute("rid",n);
			session1.setMaxInactiveInterval(30*60);
			response.sendRedirect("account.html");
				
								        
			
		}
		catch(Exception e) { System.out.println(e);}
	}

}

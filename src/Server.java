import java.sql.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Server
 */
@WebServlet("/Server")
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Server() {
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
		int count=0;
		String[] name=new String[20];
		String[] email=new String[20];
		int [] id=new int[15];
		int[] status=new int[15];
		int[] cust_id=new int[15];
		int[] rid=new int[15];
		int value= Integer.parseInt(request.getParameter("service"));
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
		              Class.forName("oracle.jdbc.driver.OracleDriver");
			          Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			          Statement stmt =con.createStatement();
		              ResultSet rs=stmt.executeQuery("select * from cust where service_id = "+value);
		              for(int i=0;rs.next();i++)
		                 {
		                     count++;
		                     name[i]=rs.getString(1);
		                     email[i]=rs.getString(2);
		                     id[i]=rs.getInt(3);
		                     status[i]=rs.getInt(4);
		                     cust_id[i]=rs.getInt(5);
		                     rid[i]=rs.getInt(6);
		                 }
		              	out.println("<h3>name &nbsp email &nbsp&nbsp service_id &nbsp&nbsp customer_id &nbsp&nbsp reference_id &nbsp status</h3>");
		              	
		              	out.println("<br><br>");
		              	String statu="";
		        		String services="";
		        		
		              	
		            	 for(int i=0;i<count;i++)
		            	 {
		            		 
		            		 if(status[i]==-1)
				        			statu="Accepted";
				        		if(id[i]==1)
				        			services="Account issues";
				        		else if(id[i]==2)
				        			services="credit card issues";
				        		else
				        			services="other issues";
		            		out.println(name[i]+"&nbsp"+"&nbsp"+email[i]+"&nbsp"+"&nbsp"+"&nbsp"+services+"&nbsp"+"&nbsp"+cust_id[i]+"&nbsp"+rid[i]);
		            		out.println("<select name=\"requests\"><option value=\"0\">New</option><option value=\"1\">Inprogress</option><option value=\"2\">Resolved</option></select>");
		            		out.println("<br><br>");
		            	 }
		            	 out.println("<button type=\"submit\">submit</button>");
		            			// RequestDispatcher rd=request.getRequestDispatcher("Server");
		            			//rd.forward(request,response);
		            	 //response.sendRedirect("Server");
		}
		catch(Exception e)
		{
			out.println(e.getMessage());
		}
	}

	}



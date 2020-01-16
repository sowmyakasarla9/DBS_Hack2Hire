
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.util.Random;

@WebServlet("/process")
public class process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public process() {
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
		String account=request.getParameter("account");
		String branch=request.getParameter("branch");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session1 = request.getSession();
		String d=session1.getId();
		int n=(int)session1.getAttribute("rid");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<br><br>");
		

		
		out.println("your request has been accepted");
		out.println("<br><br>");
		out.println("your Reference id  "+ n);
		out.println("<body><html>");
		
		
	}

}

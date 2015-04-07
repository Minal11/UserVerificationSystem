package net.codejava.email;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class AccessCodeEmailSending
 */
@WebServlet("/AccessCodeEmailSending")
public class AccessCodeEmailSending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessCodeEmailSending() {
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
		// TODO Auto-generated method stub
		 String Sanswer1 = request.getParameter("Sanswer1");    
		    String Sanswer2 = request.getParameter("Sanswer2");
		    HttpSession session = request.getSession();
		    String username = (String) session.getAttribute("userid");
		    String answer1 = null;
			String emailadd=null;
			String answer2 = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null){
			for(Cookie cookie : cookies){
			  
			 
			   if(cookie.getName().equals("Sanswer1")) answer1 = cookie.getValue();
			   
			   if(cookie.getName().equals("Sanswer2")) answer2 = cookie.getValue();
			   if(cookie.getName().equals("emailid")) emailadd = cookie.getValue();
			}
			}
			//JOptionPane.showMessageDialog(null, answer1);
			//JOptionPane.showMessageDialog(null, answer2);
			
		if(Sanswer1.equals(answer1) && Sanswer2.equals(answer2))
		{
		//	JOptionPane.showMessageDialog(null, Sanswer2);
			ServletContext sc = getServletContext();  
		RequestDispatcher rd = sc.getRequestDispatcher("/EmailSendingServlet");  
			rd.forward(request, response); 
		//response.sendRedirect("resetpassword.jsp");
		}
		else{
			response.sendRedirect("index.jsp");
		}
			
			}
	}


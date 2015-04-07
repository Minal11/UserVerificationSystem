package net.codejava.email;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class GetUser
 */
@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletRequest session=null;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUser() {
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
		 String userid = request.getParameter("userid");    
		 
		// JOptionPane.showMessageDialog(null, user);
		    
		    try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userVerificationdb",
			            "root", "root");
			  
			    Statement st = con.createStatement();
			    
			  ResultSet rs;
			    rs = st.executeQuery("select * from account where username='" + userid + "'");
			    if (rs.next()) {
			       String Squestion1=rs.getString("Squestion1");
			       String Sanswer1=rs.getString("Sanswer1");
			       String Squestion2=rs.getString("Squestion2");
			       String Sanswer2=rs.getString("Sanswer2");
			       String emailid=rs.getString("emailid");
			      // JOptionPane.showMessageDialog(null, Squestion1);
			     
			       
			       
			       
			       
			       
			       HttpSession session = request.getSession();
		            session.setAttribute("userid", userid);
		            //setting session to expiry in 30 mins
		            session.setMaxInactiveInterval(30*60);
		            Cookie userName = new Cookie("userid", userid);
		            Cookie question1 = new Cookie("Squestion1", Squestion1);
		            Cookie answer1 = new Cookie("Sanswer1", Sanswer1);
		            Cookie question2 = new Cookie("Squestion2", Squestion2);
		            Cookie answer2 = new Cookie("Sanswer2", Sanswer2);
		            Cookie emailadd = new Cookie("emailid", emailid);
		            userName.setMaxAge(30*60);
		            response.addCookie(userName);
		            response.addCookie(question1);
		            response.addCookie(answer1);
		            response.addCookie(question2);
		            response.addCookie(answer2);
		            response.addCookie(emailadd);
			       response.sendRedirect("SecurityQuestion.jsp");
			    
			    } else {
			    	JOptionPane.showMessageDialog(null, "no user");
			    	 response.sendRedirect("InvalidUserNPass.jsp");  
			    }

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  

	}

}

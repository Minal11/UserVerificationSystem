package net.codejava.email;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.Random;
import java.io.IOException;

import net.codejava.email.Hashing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		Random rand=new Random();
	    String user = request.getParameter("uname");    
	    String pwd1 = request.getParameter("pass");
	    String repwd=request.getParameter("repassword");
	   // char[] charArray = pwd1.toCharArray();
	    String email = request.getParameter("email");
	    String securityQ1=request.getParameter("securityQ1");
	    String securityA1=request.getParameter("securityA1");
	    String securityQ2=request.getParameter("securityQ2");
	    String securityA2=request.getParameter("securityA2");
	   int salt=rand.nextInt(50)+1;
	   	
	   		String pwd = null;
		try {
			pwd = Hashing.createHash(pwd1);
			
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   	
	   	//String s=Timepass.getstr();
	   	//JOptionPane.showMessageDialog(null,s);
	   	
	   	
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userVerificationdb",
		            "root", "root");
		    Statement st = con.createStatement();
		    //ResultSet rs;
		    int i = st.executeUpdate("insert into account(username, password, emailid, Squestion1, Sanswer1, Squestion2, Sanswer2, salt) values('" + user + "','" + pwd + "','" + email + "','" + securityQ1 + "','" + securityA1 + "','" + securityQ2 + "','" + securityA2 + "','" + salt + "')");
		    if (i > 0) {
		     
		        response.sendRedirect("accountcreated.jsp");
		     
		    } else {
		        response.sendRedirect("index.jsp");
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

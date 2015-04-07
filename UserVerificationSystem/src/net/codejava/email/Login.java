package net.codejava.email;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static Connection con;
	ServletRequest session=null;
	private static Boolean check=true;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		    String pwd = request.getParameter("pwd");
		  
		    try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userVerificationdb",
			            "root", "root");
			  
			    Statement st = con.createStatement();
			    
			  ResultSet rs;
			    rs = st.executeQuery("select username from account where username='" + userid + "'");
			    if (rs.next()) {
			       
			//	session.setAttribute("userid", userid);
			        //out.println("welcome " + userid);
			        //out.println("<a href='logout.jsp'>Log out</a>");
			    	ResultSet rs2=st.executeQuery("select password from account where username='" + userid + "'");
			    	if(rs2.next()){
			    		String pwd1=rs2.getString("password");
			    		check=Hashing.validatePassword(pwd, pwd1);
			    	}
			    	if(check)
			    	{
			    		//JOptionPane.showMessageDialog(null, "match");
			    		HttpSession session = request.getSession();
			            session.setAttribute("userid", userid);
			            //setting session to expiry in 30 mins
			            session.setMaxInactiveInterval(30*60);
			            Cookie userName = new Cookie("userid", userid);
			            userName.setMaxAge(30*60);
			            response.addCookie(userName);
			         
			        response.sendRedirect("loginsuccess.jsp");
			    	}
			    	else
			    	{
			    		JOptionPane.showMessageDialog(null, "no match");
			    		 response.sendRedirect("InvalidUserNPass.jsp"); 
			    	}
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
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		  

		 
		    	}
	

}

package net.codejava.email;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*; //database connectivity
import java.util.Random;

//import java.util.*;
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
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 * 
 * @author www.codejava.net
 * 
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;
	private static Connection con; 
	ResultSet r=null;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		
		String uname="";
		String accesscode="";
		// reads form fields
		String recipient = request.getParameter("emailid");
		if(recipient!=null){
			
				int flag;
				try {
						flag = databaseConnectivity(recipient);

						if(flag==1){
								String subject = "User Verification System";
								uname=getusername(recipient);
								String content = "Your username:"+uname;
								String resultMessage = "";
			
								try {
									EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
					
									resultMessage = "Your username is sent to your email address";
								} catch (Exception ex) {
									ex.printStackTrace();
									resultMessage = "There were an error: " + ex.getMessage();
								} finally {
									request.setAttribute("Message", resultMessage);
									getServletContext().getRequestDispatcher("/usernameLink.jsp").forward(request, response);
					
								}//connection closing is remaining
						}
						else{
								JOptionPane.showMessageDialog(null, "Invalid Emailaddress");
								response.sendRedirect("forgotUsername.jsp");
						}
				} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
	else{
				
				String emailadd=null;
			
				Cookie[] cookies = request.getCookies();
				if(cookies !=null)
				{
							for(Cookie cookie : cookies)
							{
							   
							   if(cookie.getName().equals("emailid")) emailadd = cookie.getValue();
							}
				}
				//JOptionPane.showMessageDialog(null, answer1);
				recipient=emailadd;
				String subject = "User Verification System";
				
				
				Random rand=new Random();
				int posRandInt = rand.nextInt( Integer.MAX_VALUE ) + 1; 

					 String str=Integer.toString(posRandInt);

						String content = "AccessCode:"+str;
						String resultMessage = "";

								try {
									EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
					
									resultMessage = "Your username is sent to your email address";
								} catch (Exception ex) {
									ex.printStackTrace();
									resultMessage = "There were an error: " + ex.getMessage();
								} finally {
									request.setAttribute("Message", resultMessage);
									HttpSession session = request.getSession();
									session.setAttribute("accesscode",str);
									getServletContext().getRequestDispatcher("/resetpassword.jsp").forward(request, response);
					
								}//connection closing is remaining
						//JOptionPane.showMessageDialog(null, "AccessCode");
						//response.sendRedirect("resetpassword.jsp");
			}	

				 

				
	
	}
	
	protected int databaseConnectivity(String emailid) throws IOException, SQLException, ClassNotFoundException  {
	
		
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userVerificationdb",
		            "root", "root");
		  
		    Statement st = con.createStatement();
		    
		  ResultSet rs;
		    rs = st.executeQuery("select username,emailid from account where emailid='" + emailid +"'");
		    if (rs.next()) {
		      int flag=1;
		       return flag;
		       // response.sendRedirect("loginsuccess.jsp");
		    } else {
		    	// response.sendRedirect("InvalidUserNPass.jsp");  
		    int flag=0;
		    	return flag;
		    }
		    
		}
		
		
	protected String getusername(String emailid) throws IOException, SQLException, ClassNotFoundException  {
		
		String uname="";
		 Class.forName("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userVerificationdb",
		            "root", "root");
		  
		    Statement st = con.createStatement();
		    
		  ResultSet rs;
		    rs = st.executeQuery("select username from account where emailid='" + emailid +"'");
		    if (rs.next()) {
		     uname=rs.getString("username");
		       return uname;
		       }
		    return uname;
	}
	
}
	
	
	
	



package net.codejava.email;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

import javax.swing.JOptionPane;

/**
 * Servlet implementation class Updation
 */
@WebServlet("/Updation")
public class Updation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updation() {
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
		HttpSession session1 = request.getSession();
        
        String newpwd =(String)session1.getAttribute("newpwd");
		String accode=(String)request.getParameter("access");
        String newpass1=(String)request.getParameter("newpass");
        String confirmpass1=(String)request.getParameter("confirmpass");
      
        String code = (String)session1.getAttribute("accesscode");
        String userid=(String)session1.getAttribute("userid");
    
        
        
     String remoteAddr = request.getRemoteAddr();
     ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
     reCaptcha.setPrivateKey("6LcuJvISAAAAAD7BS-MgJGWlwWCuMXemibnqFsuX");

     String challenge = request.getParameter("recaptcha_challenge_field");
     //out.println("challenge is" + challenge);
     
     String uresponse = request.getParameter("recaptcha_response_field");
     //out.println("uresponse is" + uresponse);
     ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
 
 	   
 	 //   JOptionPane.showMessageDialog(null,newpass1);
       //  JOptionPane.showMessageDialog(null,confirmpass1);
     if(newpass1.equals(confirmpass1))
     	
     {
     //	JOptionPane.showMessageDialog(null,"confirm password matches");
     	
     //	JOptionPane.showMessageDialog(null,code);
       //  JOptionPane.showMessageDialog(null,accode);
        
         //JOptionPane.showMessageDialog(null,newpass1);
        // JOptionPane.showMessageDialog(null,confirmpass1);
         //JOptionPane.showMessageDialog(null,userid);
         
         
          if (reCaptchaResponse.isValid()) {
	            	 
			    		String pwd =null;
						try {
			    			pwd = Hashing.createHash(newpass1);
			//    			JOptionPane.showMessageDialog(null,pwd);
			    	         
			    			
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
			    		    int i = st.executeUpdate("update account set password='"+pwd+"' where username='"+userid+"'");
			    		    if (i > 0) {
			    		     
			    		        response.sendRedirect("successreset.jsp");
			    		     
			    		    } else {
			    		        response.sendRedirect("forgotPassword.jsp");
			    		    }
			    		} catch (ClassNotFoundException e) {
			    			// TODO Auto-generated catch block
			    			e.printStackTrace();
			    		} catch (SQLException e) {
			    			// TODO Auto-generated catch block
			    			e.printStackTrace();
			    		}
			            
			  //          JOptionPane.showMessageDialog(null,"catchpa is valid");
	        				
	             }
     
     
			        else {
			        	
			        	JOptionPane.showMessageDialog(null,"Captcha value is not correct");
			        
			        	response.sendRedirect("resetpassword.jsp");
			        	//String site = new String("http://localhost:8080/User_Verification_System/resetpassword.jsp");
			        //doubt when it redirects what about session value
			       // response.setStatus(response.SC_MOVED_TEMPORARILY);
			        //response.setHeader("Location", site);
			        }
			          
         // JOptionPane.showMessageDialog(null,"Access Code Match");
     	   }
        else{
     	   JOptionPane.showMessageDialog(null,"Access code does not match");
        }	
     	
     }
   /*  else
     {
     	JOptionPane.showMessageDialog(null,"New Password and Confirm Password do not match");
     	
     	response.sendRedirect("resetpassword.jsp");
     	//String site = new String("http://localhost:8080/User_Verification_System/resetpassword.jsp");
         
        // response.setStatus(response.SC_MOVED_TEMPORARILY);
         //response.setHeader("Location", site);
         	
     }*/

}

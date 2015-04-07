<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse" %>
<%@page import ="java.sql.*" %>
<%@page import="javax.swing.JOptionPane" %>


           <%
           String accode=(String)request.getParameter("access");
           String newpass1=(String)request.getParameter("newpass");
           String confirmpass1=(String)request.getParameter("confirmpass");
         
           String code = (String) session.getAttribute("accesscode");
       
           
           
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LcuJvISAAAAAD7BS-MgJGWlwWCuMXemibnqFsuX");

        String challenge = request.getParameter("recaptcha_challenge_field");
        //out.println("challenge is" + challenge);
        
        String uresponse = request.getParameter("recaptcha_response_field");
        //out.println("uresponse is" + uresponse);
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
    
    	   
    	    JOptionPane.showMessageDialog(null,newpass1);
            JOptionPane.showMessageDialog(null,confirmpass1);
        if(newpass1.equals(confirmpass1))
        	
        {
        	JOptionPane.showMessageDialog(null,"confirm password matches");
        	
        	JOptionPane.showMessageDialog(null,code);
            JOptionPane.showMessageDialog(null,accode);
           if(accode.equalsIgnoreCase(code)) 
        	   {
        	   
            JOptionPane.showMessageDialog(null,newpass1);
            JOptionPane.showMessageDialog(null,confirmpass1);
            
             if (reCaptchaResponse.isValid()) {
	            	 HttpSession session1 = request.getSession();
			            session1.setAttribute("newpwd", newpass1);
	          
			            JOptionPane.showMessageDialog(null,"catchpa is valid");
	        				response.sendRedirect("/Updation");
	             }
        
        
			        else {
			        	
			        	JOptionPane.showMessageDialog(null,"Captcha value is not correct");
			        
			        	response.sendRedirect("resetpassword.jsp");
			        	//String site = new String("http://localhost:8080/User_Verification_System/resetpassword.jsp");
			        //doubt when it redirects what about session value
			       // response.setStatus(response.SC_MOVED_TEMPORARILY);
			        //response.setHeader("Location", site);
			        }
			          
             JOptionPane.showMessageDialog(null,"Access Code Match");
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
        	
      %>

          
        



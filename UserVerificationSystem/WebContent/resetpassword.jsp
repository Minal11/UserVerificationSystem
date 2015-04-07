<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Verification System</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
<!-- HTML shim for IE backwards compatibility -->
	<!--[if lt IE 9]>
    	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
        </script>
        <![endif]-->
<style>
.headercolor{
	color:
	#000;
	background-color:
	#FFF;
}
.foot{
	margin-top:650px;
	text-align:right;
	background-color:
	#000;
	color:#FFF;
	height:50px;
	
}
.leftpanel{
	background-color:
	#000;
	color:#FFF;
	height:50px;
}
.wrap{
	background-color:#0080C0;
	width:900px;
	margin:0 auto;
}
.image{
	
	
}
</style>
</head>

<body>
<div class="wrap">
<form action="Updation" method="post">
<%
 String code = (String) session.getAttribute("accesscode");
%>

	<div class="leftpanel">
		<center><h3> User Verification System</h3></center>
  	</div>
   
		<div style="margin-left:250px; margin-top:30px" class="span3 hero-unit ">
		            	<center><h3>Reset Password</h3></center>
       			<label>Access code</label><input type="text" name="access" width="100px" required="required">
       			<label>New Password</label><input type="password" name="newpass" width="100px" required="required"/>
            <label>Confirm Password</label><input type="password" name="confirmpass" width="100px" required="required"/>
         
         <%
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LcuJvISAAAAAFqmLvaUbH5LyNurGRakBtJOzGTK", "6LcuJvISAAAAAD7BS-MgJGWlwWCuMXemibnqFsuX", false);
          out.print(c.createRecaptchaHtml(null, null));
        %>
         
         
            
            <input class="btn btn-primary" type="submit" value="Login" name="Login" align="middle">
          <button class="btn">Cancel</button>

        </div>
        </form>
         <div>
<div class="foot">
	&copy; 2014 RM
</div>
  </div>
 
</div>		



<script src ="http://code.jquery.com/jquery-latest.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>

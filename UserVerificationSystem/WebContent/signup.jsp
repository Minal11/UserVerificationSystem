<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	margin-top:800px;
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
	width:1000px;
	height:900px;
	margin:0 auto;
}
.image{
	
	
}
</style>
<script>
function Submit(){
	 var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
	 var femail = document.form.emailid.value;
	 
	
	    
	   if (femail == "" )
	 {
	  document.form.Email.focus();
	  document.getElementById("errorBox").innerHTML = "enter the email";
	  return false;
	  }else if(!emailRegex.test(femail)){
	  document.form.emailid.focus();
	  document.getElementById("errorBox").innerHTML = "enter the valid email";
	  return false;
	  }
	   
	
	     
	}
</script>

</head>

<body>
<div class="wrap">
<form method="POST" action="Registration">

	<div class="leftpanel">
		<center><h3> User Verification System</h3></center>
  	</div>
  	<!-- <form  action="accountcreated.jsp" method="post"> -->
   <div class="errorbox">
		<div style="margin-left:250px; margin-top:30px" class="span4 hero-unit ">
     	<center><h3>Sign Up</h3></center>
        <label>Username</label><input type="text" name="uname" width="100px" required/>
            <label>Password</label><input type="password" name="pass" width="100px" required/>
            <label>Re-enter Password</label><input type="password" name="repassword" width="100px" required/>
            <label>Email address</label><input type="email" name="email" width="100px" required/>
            <label>Select Security Question 1</label>
            <select name="securityQ1">
            	<option value="">select</option>
         
                <option value="Comment on your favorite movie?">Comment on your favorite movie? </option>
                <option value="I liked my school because?">I liked my school because?</option>
                <option value="Describe your memorable moment?">Describe your memorable moment? </option>
                <option value="What street did you live on in third grade?">What street did you live on in third grade?</option>
                <option value="What is your goal in life?">What is your goal in life? </option>
                
                <option value="What is the name of your favorite childhood teacher?">What is the name of your favorite childhood teacher?</option>
            </select> 
            <label>Security Answer</label><input type="text" name="securityA1" width="100px" required/><br>
            <label>Select Security Question 2</label>
            <select name="securityQ2">
            	<option value="">select</option>
                 <option value="Describe your ideal life partner?">Describe your ideal life partner?</option>
                <option value="What you like to do in leisure time?">What you like to do in leisure time?</option>
                <option value="Tell me about your Mother?">Tell me about your Mother? </option>
                <option value="Tell me about your Father">Tell me about your Father</option>
                <option value="What is your wildest fantacy?">What is your wildest fantacy? </option>
                <option value="Something you hide from others?">Something you hide from others?</option>
            </select> 
            <label>Security Answer</label><input type="text" name="securityA2" width="100px" required/><br>
             <input class="btn btn-primary" type="submit" value="Submit" name="SignUp" align="middle" >
             <a href="index.jsp"><input class="btn" type="button" value="Cancel" /></a>
            
 
  </div>

        </div>
        <div >
        Tips:
        <ul>
        	<li>Length should be greater than 8</li>
        	<li>Use atleast 1 upperCase 1 lowercase 1number 1 special symbol</li>
        	<li>Use a paraphrase with bad grammar</li>
        </ul>
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

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

</style>
<!--  
<script>
function check(answer1,answer2)
{
	
	var ans=answer1;
	var ans2=answer2;
	
	var userAnswer1=document.getElementById('ans1').value;
	
	var userAnswer2=document.getElementById('ans2').value;
	
	if(userAnswer1==ans && userAnswer2==ans2)
		{
		
		 window.location.href = "AccessCodeEmailSending";
		
		}
	else
		{
		
		window.location="index.jsp"
		}
	}
</script>
-->
</head>

<body>

<div class="wrap">

	<%
//allow access only if session exists
String userid =null;
if(session.getAttribute("userid") == null){
	    response.sendRedirect("index.jsp");
}else userid = (String) session.getAttribute("userid");
String userName = null;
String question1 = null;
String answer1 = null;
String question2 = null;
String answer2 = null;
String emailadd=null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("userid")) userName = cookie.getValue();
   if(cookie.getName().equals("Squestion1")) question1 = cookie.getValue();
   if(cookie.getName().equals("Sanswer1")) answer1 = cookie.getValue();
   if(cookie.getName().equals("Squestion2")) question2 = cookie.getValue();
   if(cookie.getName().equals("Sanswer2")) answer2 = cookie.getValue();
   if(cookie.getName().equals("emailid")) emailadd = cookie.getValue();
}
}
%>
	<div class="leftpanel">
		<center><h3> User Verification System</h3></center>
  	</div>
  	<form action="AccessCodeEmailSending" method="post" >
  

		<div style="margin-left:250px; margin-top:100px" class="span3 hero-unit ">
		  
         <label><%=question1 %></label><input type="text" name="Sanswer1" id="ans1" width="100px" required=required>
         <label><%=question2 %></label><input type="text" name="Sanswer2" id="ans2" width="100px" required="required">
         <button class="btn btn-primary" type="submit" value="Next" name="next"  align="middle" >Next</button>
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
<script src="js/bootstrap.min.js"></script>
</body>

</html>

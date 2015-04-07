
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
</head>

<body>
<div class="wrap">
<form action="Logout" method="post">

	<div class="leftpanel">
		<center><h3> User Verification System</h3></center>
  	</div>
   
		<div style="margin-left:250px; margin-top:100px" class="span3 hero-unit ">
		
		<%
//allow access only if session exists
String userid = null;
if(session.getAttribute("userid") == null){
    response.sendRedirect("index.jsp");
}else userid = (String) session.getAttribute("userid");
String userName = null;
//String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("userid")) userName = cookie.getValue();
  //  if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
		<h3> Hi <%=userName %>, Login successful. </h3>
<br>


         
  
<input type="submit" value="Logout" >
      
     
        </div>
         <div>
<div class="foot">
	&copy; 2014 RM
</div>
  </div>

</form>   
</div>
<script src ="http://code.jquery.com/jquery-latest.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
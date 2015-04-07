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
.image{
	
	
}
</style>
</head>

<body>
<form action="EmailSendingServlet" method="POST">
<div class="wrap">
	<div class="leftpanel">
		<center><h3> User Verification System</h3></center>
  	</div>
		<div style="margin-left:250px; margin-top:100px" class="span3 hero-unit ">
	        <center><h3>Forgot Username?</h3></center>
 			    <label>Enter your email address</label><input type="text" name="emailid" width="100px"/>
     			     <input class="btn btn-primary" type="submit" value="send" name="submit" align="middle">
           				 <button class="btn">Cancel</button>
       </div>
     <div>
<div class="foot">
	&copy; 2014 RM
</div>
  </div>
 
</div>		

<script src ="http://code.jquery.com/jquery-latest.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</form>
</body>

</html>
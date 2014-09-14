<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Indian Oil</title>
<script type="text/javascript">
function validateLogin() {
	var x=document.forms["LoginForm"]["EmpNo"].value;
	var y=document.forms["LoginForm"]["EmpPassword"].value;
	if(x==null || x=="")
		{
		alert("Please fill Contractor Name !!");
		return false;
		}
	if(y==null || y=="")
		{
		alert("Please fill Contractor Id !!");
		return false;
		}
	return true;
}
</script>
</head>
<style>
body {
	background-color: #FFC;
	color: #006;
	column-fill: balance;
	margin-left: 4in;
	margin-right: 4in;
	margin- top: 10in;
	margin- bottom: 4in;
	font-family: "Times New Roman";
	font-size: 18px;
	font-style: normal;
	text-decoration: blink;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
}

form {
	background-color: #FFC;
	alignment-adjust: central;
	width: inherit;
}

h1 {
	font-family: "Times New Roman", Times, serif;
	font-size: 35px;
	font-weight: bold;
	text-decoration: blink;
}

p {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: 20px;
}
</style>
<body>
	<center><img height="100" width="100" src="images/indianoilsymbol.png">
	<h1 style="background-color: #FFC">CAR BOOKING SYSTEM
	</h1>
	<s:form action="ContractorLogin" method="post" id="LoginForm" onsubmit="return validateLogin()">
		<s:textfield label="Name" key="ContractorName" id="EmpNo"/>
		<s:textfield label="Id" key="ContractorId" id="EmpPassword"
			type="password" />
		<br />
		<s:reset />
		<s:submit />
	</s:form>
	<br />
	<s:property value="ContractorLoginLogoutStatus"/>
	<br/>
	<s:property value="ErrorStatus"/>
	</center>
		<a href="index.jsp"><img height="100" width="100"
		src="images/home.png"> </a>
</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="org.apache.struts2.components.Param"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script type="text/javascript" src="jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function()
	{
	
		$("#password").keypress(function(evt){
			var no=evt.which;
			if(!(no>=48 && no <= 57))
				{
				evt.preventDefault();
				}
		});
		//$("#logout").fadeOut(2000);
		//$("#msg").fadeIn(2000);
		//$("#msg").slideUp(2000);
		//$("#msg").slideDown(2000);
		//$("#msg").hide(2000);
		//$("#msg").show(2000);
		//$("#msg").animate({left:'900px',top:'450px'},1500);
		//$("#msg").animate({left:'900px'},1000);
		//$("#msg").animate({top:'450px'},1000);
		//$("#msg").animate({left:'0px'},1000);
		//$("#msg").animate({top:'0px'},1000);
		$("#username").keypress(function(evt){
			var no=evt.which;
				{
			if(!(no>=65 && no <=90)&& !(no>=97 && no<=122) &&(no==64)&&!(no>=35 && no<=38))
				evt.preventDefault();
				}
		});
	});

</script>
<title>Untitled Document</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
<div class="banner">
<img src="images/emblem.gif" class="emblem"	  />
<img src="images/bannertext.jpg" class="bannertext"  />
</div>

<img src="images/banner.jpg" class="bannerimage" width="100%" />

</div>

<!--left starts here -->

<div class="main">
<section>
<section class="left">
<section class="box">
<section class="innerbox">News & highlights</section>
<marquee  direction="up" height="140px" 	>
<ul>
<li><a href="#">To open the Pictures library
Click to open the Pictures library. </a></li>

<li><a href="#">Show contentHide content To browse the Pictures library and view pictures</a></li>

<li><a href="#">To Do this See a larger preview of a picture thumbnail</a></li>

<li><a href="#">On the toolbar, click the Preview pane button Picture of the preview pane button, and then click the picture.</a></li></ul></marquee>
</section>
</section>
<section class="left">
<section class="box">
<section class="innerbox">pending post</section>
<marquee  direction="up" height="140px" onmousemove="">
<ul>
<li><a href="#">To open the Pictures library
Click to open the Pictures library.</a> </li>

<li><a href="#">Show contentHide content To browse the Pictures library and view pictures</a></li>

<li><a href="#">To Do this See a larger preview of a picture thumbnail</a></li>

<li><a href="#">On the toolbar, click the Preview pane button Picture of the preview pane button, and then click the picture.</a></li></ul></marquee>
</section>
</section>
</section>
<!-- -->

<div class="midcontent">
<div class="midcontent_box">
<div class="nav">
<img src="images/icon1.jpg" class="navicon" /><span class="nav1"><a href="index.jsp">Home</a></span>
<img src="images/icon2.jpg" class="navicon" /><span class="nav1"><a href="#">About Us</a></span>
<img src="images/icon3.jpg" class="navicon" /><span class="nav1"><a href="#">Politial World</a></span>
<img src="images/icon4.jpg" class="navicon" /><span><a href="#">Contact Us</a></span>
</div>
</div>
<div style="width:100%; margin-top:10px; float:left; text-align:left; color:#2fabab; font-family:'Times New Roman', Times, serif; font-size:18px; font-style:italic;">Welcome to our website !</div>
<p style="margin-top:15px;">An easy way to locate and view pictures on your computer is to use the Pictures library. By default, the Pictures library shows all the pictures located in the My Pictures folder, but you can include other folders in your Pictures library, too. For more information, see Include folders in a library.<br /><br>

An easy way to locate and view pictures on your computer is to use the Pictures library. By default, the Pictures library shows all the pictures located in the My Pictures folder, but you can include other folders in your Pictures library, too. For more information, see Include folders in a library.An easy way to locate and view pictures on your computer is to use the Pictures library. By default, the Pictures library shows all the pictures located in the My Pictures folder, but you can include other folders in your Pictures library, too. For more information, see Include folders in a library.</p>
<ul>
<li class="bullet">An easy way to locate and view pictures on your computer is to use the Pictures library. </li>

<li class="bullet">An easy way to locate and view pictures on your computer is to use the Pictures library. </li>
</ul>
<div style="width:auto; font-weight:lighter; margin-top:15px; float:right; font-family:Verdana, Geneva, sans-serif; font-size:14px; color:#228f8f; text-decoration:underline; font-style:italic;"><a href="#">Read More..</a></div>
</div>

<section style=" float:right;">
<section class="left">
<section class="box">
<section class="innerbox">User Login</section>
<form action="login" method="post" id="myForm"  >
	<div style="width:91%; font-family:Verdana, Geneva, sans-serif; color:#6d7676; font-style:italic; font-size:12px; text-align:left; margin-left:10px; margin-top:15px; float:left; ">
	Username:<input type="text"  name="username"  style="float:right; width:62%; border-radius:5px; border:1px solid #e4e4e4;  text-align:left;" /></div>
	<div style="width:91%; font-family:Verdana, Geneva, sans-serif; color:#6d7676; font-style:italic; font-size:12px; text-align:left; margin-left:10px; margin-top:15px; float:left; ">
	Password<input type="password" name="password" id="password" style="float:right; width:62%; border-radius:5px; border:1px solid #e4e4e4;  text-align:left;" /></div>
				<div style="width:91%; font-family:Verdana, Geneva, sans-serif; color:#6d7676; font-style:italic; font-size:12px; text-align:left; margin-left:10px; margin-top:15px; float:left; ">
	ID<input type="password" name="id" id="id" style="float:right; width:62%; border-radius:5px; border:1px solid #e4e4e4;  text-align:left;" /></div>
			<div style="width:91%; margin-left:15px; float:left; text-align:right; margin-top:25px; margin-bottom:5px;">
			<input type="submit" value="submit"/></div>
			<b><i><s:property value="loginerror" /></i></b>
		</form>
<div style="width:45%; margin-left:15px; text-align:left; float:left; font-family:Verdana, Geneva, sans-serif; font-size:10px; text-decoration:underline; color:#6d7676;"><a href="ForgotPassword.jsp">Forgot Password ?</a><br/>

<div style="width:45%;  text-align:left; float:left; font-family:Verdana, Geneva, sans-serif; font-size:10px; text-decoration:underline; color:#6d7676;"><a href="RegisterPage.jsp">Register</a>
</div>
</div>


</section>
</section>

<div style="width:95%; border-radius:5px; text-align:left; padding-left:15px; background-image:url(images/icon_bg.jpg); background-repeat:repeat-x; height:54px; float:left; margin-bottom:15px;">
<a href="#"><img src="images/icon_app.jpg"  /></a>

</div>
<div style="width:95%;  border-radius:5px; text-align:left; padding-left:15px; background-image:url(images/icon_bg.jpg); background-repeat:repeat-x; height:54px; float:left; margin-bottom:15px;">
<a href="#"><img src="images/icon_info.jpg"  /></a>

</div>
<div style="width:95%; border-radius:5px; text-align:left; padding-left:15px; background-image:url(images/icon_bg.jpg); background-repeat:repeat-x; height:54px; float:left; margin-bottom:15px;">
<a href="#"><img src="images/icon_email.jpg"  /></a>

</div>
</section>

</div>

<div style="width:100%; float:left; padding-top:12px; background-image:url(images/FOOTERBG.jpg); background-repeat:repeat-x; height:59px; ">
<div style="width:85%; text-align:center; float:left; font-family:Verdana, Geneva, sans-serif; font-size:12px; font-style:italic; line-height:16px; color:#79e4e6;">
Designed , developed and hosted by Cyber Parliament <br />Copyright @ Cyber Parliament ... All rights reserved 
</div>
<div style="width:10%; text-align:right; margin-right:10px; float:right;">
<a href="#"><img src="images/fb_icon.jpg"  /></a>
<a href="#"><img src="images/twtr_icon.jpg"  /></a>
<a href="#"><img src="images/gm_icon.jpg"  /></a>
</div>
</div>
</body>
</html>

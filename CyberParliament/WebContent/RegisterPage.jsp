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
	$(document).ready(
			function() {
				/*$("body").mousedown(function(evt){
					var no=evt.which;
					if(no==3)
						{
						alert("you cannot do this");
						evt.preventDefault();
						}
				});
				
				$("body").mousemove(function(evt){
					$("#para").html("X : " + evt.pageX + " Y : " + evt.pageY);
				});
				
				//$("#image").mouseover(function(){
					//$("#image").fadeOut(500);
				//});
				$("#image").mouseover(function(){
					$("#image").animate({left:'800px',opacity:'0'},2000);
					//$("#msg").fadeOut(300);
				});*/
				$("#age")
						.keypress(
								function(evt) {
									var no = evt.which;
									if (!(no >= 48 && no <= 57)
											&& (!(no == 9 || no == 14
													|| no == 15 || no == 8))) {
										evt.preventDefault();
									}
								});
				$("#username").keypress(
						function(evt) {
							var no = evt.which;
							if (!(no >= 65 && no <= 90)
									&& !(no >= 97 && no <= 122) && (no == 64)
									&& !(no >= 35 && no <= 38)) {
								evt.preventDefault();
							}
						});
				$("#name")
						.keypress(
								function(evt) {
									var no = evt.which;
									if ((!(no >= 65 && no <= 90))
											&& (!(no >= 97 && no <= 122))
											&& (!(no == 9 || no == 14
													|| no == 15 || no == 8))) {
										evt.preventDefault();
									}
								});
				$("#password")
						.keypress(
								function(evt) {
									var no = evt.which;
									if (!(no >= 48 && no <= 57)
											&& (!(no == 9 || no == 14
													|| no == 15 || no == 8))) {
										evt.preventDefault();
									}
								});
				/*$("a").mouseover(function(evt){
					$(this).fadeOut(200);
					evt.preventDefault();
				});*/
				//$("#msg").fadeOut(2000);
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

			});
	function check() {
		var nameVal = document.forms["myForm"]["confirmpassword"].value;
		var nameVal1 = document.forms["myForm"]["confirmpassword"].value;
		if (nameval == nameval1) {
			return true;
			alert("Password does not match!!!");
		} else
			return false;
	}
</script>
<title>Untitled Document</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="header">
		<div class="banner">
			<img src="images/emblem.gif" class="emblem" /> <img
				src="images/bannertext.jpg" class="bannertext" />
		</div>

		<img src="images/banner.jpg" class="bannerimage" width="100%" />

	</div>

	<!--left starts here -->

	<div class="main">
		<section> <section class="left"> <section
			class="box"> <section class="innerbox">News &
		highlights</section> <marquee direction="up" height="140px">
		<ul>
			<li><a href="#">To open the Pictures library Click to open
					the Pictures library. </a></li>

			<li><a href="#">Show contentHide content To browse the
					Pictures library and view pictures</a></li>

			<li><a href="#">To Do this See a larger preview of a picture
					thumbnail</a></li>

			<li><a href="#">On the toolbar, click the Preview pane
					button Picture of the preview pane button, and then click the
					picture.</a></li>
		</ul>
		</marquee> </section> </section> <section class="left"> <section class="box"> <section
			class="innerbox">pending post</section> <marquee direction="up"
			height="140px" onmousemove="">
		<ul>
			<li><a href="#">To open the Pictures library Click to open
					the Pictures library.</a></li>

			<li><a href="#">Show contentHide content To browse the
					Pictures library and view pictures</a></li>

			<li><a href="#">To Do this See a larger preview of a picture
					thumbnail</a></li>

			<li><a href="#">On the toolbar, click the Preview pane
					button Picture of the preview pane button, and then click the
					picture.</a></li>
		</ul>
		</marquee> </section> </section> </section>
		<!-- -->

		<div class="midcontent">
			<div class="midcontent_box">
				<div class="nav">
					<img src="images/icon1.jpg" class="navicon" /><span class="nav1"><a
						href="#">Home</a></span> <img src="images/icon2.jpg" class="navicon" /><span
						class="nav1"><a href="#">About Us</a></span> <img
						src="images/icon3.jpg" class="navicon" /><span class="nav1"><a
						href="#">Politial World</a></span> <img src="images/icon4.jpg"
						class="navicon" /><span><a href="#">Contact Us</a></span>
				</div>
			</div>
			<div
				style="width: 100%; margin-top: 10px; float: left; text-align: left; color: #2fabab; font-family: 'Times New Roman', Times, serif; font-size: 18px; font-style: italic;">
				<s:form action="register" method="post" onsubmit=" return check()"
					id="myFrom" name="myForm">
					<s:textfield key="c.name" label="Enter name:" id="name" />
					<s:textfield key="c.username" label="Enter username:" id="username" />
					<s:textfield key="c.age" type="number" label="Enter age:" id="age" />
					<s:select list="{'Male','Female'}" key="c.gender"
						label="Select gender:" />
					<s:textfield key="c.email" type="email" label="Enter email:" />
					<s:password key="c.password" label="Enter password:" type="number"
						id="password" />
					<s:password key="c.confirmpassword" label="Confirm Password:"
						type="number" id="password" errorPosition="bottom" />
					<s:submit />
					<s:reset />
				</s:form>
				<s:property value="registrationsuccess" />
			</div>
		</div>
	</div>
	<div
		style="width: 100%; float: left; padding-top: 12px; background-image: url(images/FOOTERBG.jpg); background-repeat: repeat-x; height: 59px;">
		<div
			style="width: 85%; text-align: center; float: left; font-family: Verdana, Geneva, sans-serif; font-size: 12px; font-style: italic; line-height: 16px; color: #79e4e6;">
			Designed , developed and hosted by Cyber Parliament <br />Copyright
			@ Cyber Parliament ... All rights reserved
		</div>
		<div
			style="width: 10%; text-align: right; margin-right: 10px; float: right;">
			<a href="#"><img src="images/fb_icon.jpg" /></a> <a href="#"><img
				src="images/twtr_icon.jpg" /></a> <a href="#"><img
				src="images/gm_icon.jpg" /></a>
		</div>
	</div>
</body>
</html>

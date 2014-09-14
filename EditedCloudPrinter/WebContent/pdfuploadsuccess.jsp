<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="style1.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div
		style="background-image: url(images/bg.jpg); width: 1000px; text-align: center; height: 646px; margin-left: 15%;">
		<div class="banner">
			<img src="images/logo.gif" class="logo" />
			<div class="bannertext">Cloud Printing</div>
			<div class="menu">
				<a href="index.jsp"><img src="images/home.jpg" /></a>Home
			</div>
			<div style="margin-left: 1%;" class="menu">
				<a href="about.jsp"><img src="images/aboutus.jpg" /></a>About Us
			</div>
			<div style="margin-left: 1.5%;" class="menu">
				<a href="contact.jsp"><img src="images/contact-us.jpg" /></a>Contact
				Us
			</div>
		</div>

		<div class="main">
			<div class="login">
				<div class="loginbg">
					<h1 style="margin-top: 56px">
						<a href="logout"><input type="button" value="Logout" /></a>
					</h1>
				</div>
				<br /> <br /> <br /> <br /> <br />
				<div class="loginbox">
					<img src="images/cloudprinthost.png" alt="Cloud Print"
						style="height: 140px; width: 180px;" />
					<sj:menu id="menuWithItems"
						cssStyle="background-color:#ebebeb;height:auto;">
						<sj:menuItem title="Create Files" href="upload.jsp"
							cssStyle="background-color:#ebebeb;" />
						<sj:menuItem title="Open Files"
							cssStyle="background-color:#ebebeb;">
							<sj:menu id="subMenuPlugins"
								cssErrorStyle="background-color:#ebebeb;">
								<sj:menuItem title="Text" href="showfiles" />
							</sj:menu>
						</sj:menuItem>
						<sj:menuItem title="Upload Files"
							cssStyle="background-color:#ebebeb;">
							<sj:menu id="" cssStyle="width:auto;background-color:#ebebeb;">
								<sj:menuItem title="Text" href="uploadtextfile.jsp" />
								<sj:menuItem title="Image" href="fileuploadformat.jsp" />
								<sj:menuItem title="Pdf" href="uploadpdf.jsp" />
							</sj:menu>
						</sj:menuItem>
						<sj:menuItem title="Print Files"
							cssStyle="background-color:#ebebeb;">
							<sj:menu cssStyle="width:auto;background-color:#ebebeb;">
								<sj:menuItem title="Text" href="showfilesforprint" />
								<sj:menuItem title="Image" href="showimagefiles" />
								<sj:menuItem title="Pdf" href="showpdffiles" />
							</sj:menu>
						</sj:menuItem>
					</sj:menu>
					<img src="images/cloudprint.png" alt="Cloud Print"
						style="height: 140px; width: 180px;" />
				</div>
			</div>


			<div class="main2">
				<div class="maincontent_bg">
					<h1 style="width: 100%; text-align: center;">
						UPLOAD STATUS 
					</h1>
				</div>
				<div
					style="width: 430px; height: 415px; float: left; background-color: #ebebeb;">
					<center>
						<p style="margin-left: 90px; width: 190px;">

							<s:if test="#session.username!=null">
								<s:property value="fileuploadstatus" />
							</s:if>
							<s:else>
								<jsp:forward page="Error.jsp" />
							</s:else>

						</p>
					</center>
				</div>
			</div>
		</div>
	</div>
	<div
		style="width: 100%; float: left; height: 200px; background-image: url(images/footerbg.jpg);">
		<img src="images/logo.gif" width="79px" height="57px;"
			style="float: left; margin-top: 14%; margin-left: 14%;" />
		<div
			style="width: 558px; margin-left: 2%; text-align: left; float: left; font-family: Verdana, Geneva, sans-serif; font-size: 12px; font-style: italic; line-height: 16px; color: #fff; margin-top: 15%;">
			Designed , developed and hosted by Cyber Parliament <br />Copyright
			@ Cyber Parliament ... All rights reserved
		</div>
		<div
			style="width: 10%; text-align: right; margin-right: 10px; float: left; margin-top: 15%;">
			<a href="#"><img src="images/fb_icon.jpg" /></a> <a href="#"><img
				src="images/twtr_icon.jpg" /></a> <a href="#"><img
				src="images/gm_icon.jpg" /></a>
		</div>
	</div>
	</div>
</body>
</html>

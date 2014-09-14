<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#home").show();
		$("#aboutus").hide();
		$("#carbooking").hide();
		$("#contactus").hide();
		$("#menu2").click(function() {
			$("#aboutus").fadeIn(1000);
			$("#home").hide();
			$("#carbooking").hide();
			$("#contactus").hide();
		});
		$("#menu1").click(function() {
			$("#home").fadeIn(1000);
			$("#aboutus").hide();
			$("#carbooking").hide();
			$("#contactus").hide();
		});
		$("#menu3").click(function() {
			$("#carbooking").fadeIn(1000);
			$("#home").hide();
			$("#aboutus").hide();
			$("#contactus").hide();
		});
		$("#menu4").click(function() {
			$("#contactus").fadeIn(1000);
			$("#home").hide();
			$("#carbooking").hide();
			$("#aboutus").hide();
		});
	});
</script>
<script type="text/javascript">
	function changesource() {
		var x = document.getElementById("banner");
		if (x.src.match("images/indianoilheader1.jpg")) {
			x.src = "images/indianoilheader2.jpg";
		} else if (x.src.match("images/indianoilheader2.jpg")) {
			x.src = "images/indianoilheader3.jpg";
		} else if (x.src.match("images/indianoilheader3.jpg")) {
			x.src = "images/indianoilheader4.jpg";
		} else {
			x.src = "images/indianoilheader1.jpg";
		}
	}
</script>
</head>
<body>
	<div class="header" style="border: 1px solid #e4e4e4;">
		<img src="images/indianoilheader1.jpg" height="153px" width="1190px"
			id="banner" onmouseover="changesource()" margin-right="0px" />
		<div class="banner">
			<img src="images/indianoilsymbol.png" class="emblem" height="120px"
				width="100px" />
		</div>
	</div>
	<!--left starts here -->
	<div class="main">
		<section style="height:350px;"> <section class="left"
			style="height:350px;"> <section class="box"
			style="height:350px;"> <section class="innerbox">News
		& highlights</section> <marquee direction="up" height="340px"
			onMouseOver="this.setAttribute('scrollamount', 0, 0);"
			OnMouseOut="this.setAttribute('scrollamount', 6, 0);">
			<ul>
				<li><a href="#">To open the Pictures library Click to open
						the Pictures library. </a></li>

				<li><a href="#">Show contentHide content To browse the
						Pictures library and view pictures</a></li>

				<li><a href="#">To Do this See a larger preview of a
						picture thumbnail</a></li>

				<li><a href="#">On the toolbar, click the Preview pane
						button Picture of the preview pane button, and then click the
						picture.</a></li>
			</ul>
		</marquee> </section> </section> </section>
		</section>
		<!-- -->
		<div class="midcontent" >
			<div class="midcontent_box">
				<div class="nav">
					<img src="images/icon1.jpg" class="navicon" /><span class="nav1"><a
						href="#" id="menu1">Home</a></span> <img src="images/icon2.jpg"
						class="navicon" /><span class="nav1"><a href="#"
						id="menu2">About Us</a></span> <img src="images/car_icon.gif"
						height="21px" width="21px" class="navicon" /><span class="nav1"><a
						href="#" id="menu3">Car Booking</a></span> <img src="images/icon4.jpg"
						class="navicon" /><span><a href="#" id="menu4">Contact
							Us</a></span>
				</div>
			</div>
			<div
				style="width: 100%; margin-top: 10px; float: left; text-align: left; color: #2fabab; font-family: 'Times New Roman', Times, serif; font-size: 18px; font-style: italic;">Welcome
				to our Transport Booking Section !!</div>
			<p style="margin-top: 15px;" id="home">
				An easy way to locate and view pictures on your computer is to use
				the Pictures library. By default, the Pictures library shows all the
				pictures located in the My Pictures folder, but you can include
				other folders in your Pictures library, too. For more information,
				see Include folders in a library.<br /> <br> An easy way to
				locate and view pictures on your computer is to use the Pictures
				library. By default, the Pictures library shows all the pictures
				located in the My Pictures folder, but you can include other folders
				in your Pictures library, too. For more information, see Include
				folders in a library.An easy way to locate and view pictures on your
				computer is to use the Pictures library. By default, the Pictures
				library shows all the pictures located in the My Pictures folder,
				but you can include other folders in your Pictures library, too. For
				more information, see Include folders in a library.
			</p>
			<p style="margin-top: 15px;" id="aboutus">
				An easy way to locate and view pictures on your computer is to use
				the Pictures library. By default, the Pictures library shows all the
				pictures located in the My Pictures folder, but you can include
				other folders in your Pictures library, too. For more information,
				see Include folders in a library.<br /> <br> An easy way to
				locate and view pictures on your computer is to use the Pictures
				library. By default, the Pictures library shows all the pictures
				located in the My Pictures folder, but you can include other folders
				in your Pictures library, too. For more information, see Include
				folders in a library.An easy way to locate and view pictures on your
				computer is to use the Pictures library. By default, the Pictures
				library shows all the pictures located in the My Pictures folder,
				but you can include other folders in your Pictures library, too. For
				more information, see Include folders in a library.
			</p>
			<p style="margin-top: 15px;" id="carbooking">
				An easy way to locate and view pictures on your computer is to use
				the Pictures library. By default, the Pictures library shows all the
				pictures located in the My Pictures folder, but you can include
				other folders in your Pictures library, too. For more information,
				see Include folders in a library.<br /> <br> An easy way to
				locate and view pictures on your computer is to use the Pictures
				library. By default, the Pictures library shows all the pictures
				located in the My Pictures folder, but you can include other folders
				in your Pictures library, too. For more information, see Include
				folders in a library.An easy way to locate and view pictures on your
				computer is to use the Pictures library. By default, the Pictures
				library shows all the pictures located in the My Pictures folder,
				but you can include other folders in your Pictures library, too. For
				more information, see Include folders in a library.
			</p>
			<p style="margin-top: 15px;" id="contactus">
				An easy way to locate and view pictures on your computer is to use
				the Pictures library. By default, the Pictures library shows all the
				pictures located in the My Pictures folder, but you can include
				other folders in your Pictures library, too. For more information,
				see Include folders in a library.<br /> <br> An easy way to
				locate and view pictures on your computer is to use the Pictures
				library. By default, the Pictures library shows all the pictures
				located in the My Pictures folder, but you can include other folders
				in your Pictures library, too. For more information, see Include
				folders in a library.An easy way to locate and view pictures on your
				computer is to use the Pictures library. By default, the Pictures
				library shows all the pictures located in the My Pictures folder,
				but you can include other folders in your Pictures library, too. For
				more information, see Include folders in a library.
			</p>
			<ul>
				<li class="bullet">An easy way to locate and view pictures on
					your computer is to use the Pictures library.</li>

				<li class="bullet">An easy way to locate and view pictures on
					your computer is to use the Pictures library.</li>
			</ul>
			<div
				style="width: auto; font-weight: lighter; margin-top: 15px; float: right; font-family: Verdana, Geneva, sans-serif; font-size: 14px; color: #228f8f; text-decoration: underline; font-style: italic;">
				<a href="#">Read More..</a>
			</div>
		</div>

		<section style=" float:right; height:350px;"> <section
			class="left" style="height:350px;"> <section class="box"
			style="height:350px;"> <section class="innerbox"
			height="390px">Employee Login</section> <marquee direction="up"
			onMouseOver="this.setAttribute('scrollamount', 0, 0);"
			OnMouseOut="this.setAttribute('scrollamount', 6, 0);"
			id="marqueeright" height="250px">
			<img height="200" width="330" src="images/1.jpg"> <img
				height="200" width="330" src="images/2.jpg"> <img height="200"
				width="330" src="images/3.jpg"> <img height="200" width="330"
				src="images/4.jpg"> <img height="200" width="330"
				src="images/5.jpg">
		</marquee> <br>
		<br>
		<a href="index.jsp"><img height="55" width="150"
			src="images/6.jpg"></a> </section> </section> </section>
	</div>
	<br />
	<br />
	<div
		style="width: 100%; float: left; padding-top: 12px; background-repeat: repeat-x; height: 89px; background-color: #FFDB94; border: 1px solid #e4e4e4;">
		<div
			style="width: 85%; text-align: center; float: left; font-family: Verdana, Geneva, sans-serif; font-size: 12px; font-style: italic; line-height: 16px;">
			Designed , developed and hosted by <b>RS Company</b> <br />Copyright
			@ <em><b>RS Company</b></em> ... All rights reserved
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
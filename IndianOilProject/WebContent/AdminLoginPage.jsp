<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#approved").hide();
		$("#rejected").hide();
		$("#submit").hide();
		$("#approve").click(function() {
			$("#approved").show();
			$("#approve").fadeOut(1000);
			$("#reject").fadeIn(1000);
			$("#rejected").hide();
			$("#submit").show();
		});
		+$("#reject").click(function() {
			$("#rejected").show();
			$("#submit").show();
			$("#approved").hide();
			$("#reject").fadeOut(1000);
			$("#approve").fadeIn(1000);
		});
		$("#validaterequests").fadeOut(2000);
	});
	function validateLogin() {
		var x1 = document.forms["MyForm"]["radiocheck"].value;
		var x2 = document.forms["MyForm"]["station"].value;
		var x3 = document.forms["MyForm"]["name"].value;
		var x4 = document.forms["MyForm"]["contact"].value;
		if (x1 == null || x1 == "") {
			alert("Please fill the  reqd. fields !!");
			return false;
		}
		if (x2 == null || x2 == "") {
			alert("Please fill the  reqd. fields !!");
			return false;
		}

		if (x3 == null || x3 == "") {
			alert("Please fill the  reqd. fields !!");
			return false;
		}

		if (x4 == null || x4 == "") {
			alert("Please fill the  reqd. fields !!");
			return false;
		}
		return true;
	}
	function validateLogin1() {
		var x5 = document.forms["MyForm"]["reason"].value;
		if (x5 == null || x5 == "") {
			alert("Please fill the  reqd. fields !!");
			return false;
		}
		return true;
	}
	function validate() {
		var y = document.getElementById("approve").value;
		var z = document.getElementById("reject").value;
		if (form.result[0].checked == true) {
			validateLogin();
		} else if (form.result[1].checked == true) {
			validateLogin1();
		}
	}
	function resettext() {
		var c = document.getElementById("reason");

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="header" style="border: 1px solid #e4e4e4;">
		<img src="images/indianoilheader1.jpg" height="153px" width="1190px"
			margin-right="0px" />
		<div class="banner">
			<img src="images/indianoilsymbol.png" class="emblem" height="120px"
				width="100px" />
		</div>
	</div>
	<!--left starts here -->
	<div class="main">
		<s:if test="#session.AdminKey!=null">
			<form action="AdminRequest" method="post"
				onsubmit="return validate()" id="MyForm">
				<!------>
				<div class="midcontent"
					style="width: 60%; float: right; margin-right: 150px;">
					<div class="midcontent_box">
						<div class="nav">
							<center>
								<a href="logout"><img src="images/logout.png" height="26px"
									alt="Logout"></a>
							</center>
							<!--<a href="logout"><img src="images/logout.png" height="26px"
									alt="Logout"></a>-->
							<!-- 	<table >
								<tr>
									<td align="left"><a href="logout"><img src="images/logout.png"
											height="26px" alt="Logout"></a></td>
									<td align="right"><a href="logout"><img src="images/logout.png"
											height="26px" width="150px" alt="Logout"></a></td>
									<td></td>
									<td></td>

								</tr>


							</table>
							-->
						</div>
					</div>
					<div
						style="width: 100%; margin-top: 10px; float: left; text-align: left; color: #2fabab; font-family: 'Times New Roman', Times, serif; font-size: 18px; font-style: italic;">
						<br />
						<table cellspacing="0px" border="2px" style="width: 800px;">
							<tr>
								<td><b><i>SELECT</b></i></td>
								<td><b><i><center>Employee No.</center></b></i></td>

								<td align="center"><b><i>Employee Purpose</b></i></td>

								<td align="center"><b><i>Repoting Date</b></i></td>

								<td align="center"><b><i>Repoting Time</b></i></td>

								<td align="center"><b><i>Car Name</b></i></td>

								<td align="center"><b><i>Car Type</b></i></td>

								<td align="center"><b><i>Request Date</b></i></td>
							</tr>
							<s:iterator var="e" value="tr">
								<tr>
									<td><center>
											<input type="radio" value="<s:property value="#e.Pk" />"
												name="obtainedempno" id="select" />
										</center></td>
									<td><center>
											<s:property value="#e.EmpNo" />
										</center></td>

									<td><center>
											<s:property value="#e.EmpPurpose" />
										</center></td>
									<td><center>
											<s:property value="#e.CarReportingDate" />
										</center></td>
									<td><center>
											<s:property value="#e.CarReportingTime" />
										</center></td>
									<td><center>
											<s:property value="#e.CarName" />
										</center></td>
									<td><center>
											<s:property value="#e.CarType" />
										</center></td>
									<td><center>
											<s:property value="#e.DateofBookingRequest" />
										</center></td>
								</tr>
							</s:iterator>
						</table>
						<br /> <input type="radio" name="result" id="approve"
							value="Approve" />Approve<br /> <br /> <input type="radio"
							name="result" id="reject" value="Reject" />Reject <br /> <br />
						<div id="validaterequests"
							style="text-decoration: blink; text-shadow: red; color: red;">
							<s:property value="ValidateApproveStatus" />
							<br />
							<s:property value="ApprovalStatus" />
							<br />
							<s:property value="ValidateRejectStatus" />
							<br />
							<s:property value="RejectionStatus" />
							<br />
							<s:property value="MailStatus" />
						</div>
					</div>
				</div>
				<!------->

				<section style="width:25%;height:360px;float:right"> <section
					class="left" style="height:360px;"> <section class="box"
					style="height:360px;"> <section class="innerbox">
				Please Fill !!</section> <br />
				<div id="approved" style="margin-top: 20px;">
					Select Trip(<font color="#ff0000">*</font>) :<input type="radio"
						name="trip" id="radiocheck" value="80.Km-9hrs" />80.Km-9hrs <input
						type="radio" name="trip" id="radiocheck" value="40.Km-4.5hrs" />40.Km-4.5hrs
					<input type="radio" name="trip" id="radiocheck"
						value="OutstationTrip" />OutstationTrip <input type="radio"
						name="trip" id="radiocheck" value="Hill Area Trip" />Hill Area
					Trip <br /> <br /> Airport/Rly.Station :<input type="checkbox"
						value="Airport/Rly.Station" name="station" id="station" /> <br />
					(Remarks: Car after dropping at Airport/Rly. St. must report back
					at IOCL office, Scope Complex, Core-2.) <br /> <br /> Name of
					SAO/AM(<font color="#ff0000">*</font>) :<input type="text"
						name="name" id="name" /> <br /> <br /> Contact Nos. (Icom)(<font
						color="#ff0000">*</font>) :<input type="text" name="contact"
						id="contact" /> <br /> <br /> Select Contractor(<font
						color="#ff0000">*</font>):<select name="ContractorId">
						<s:iterator var="e" value="cd">
							<option value="<s:property value="#e.ContractorId"/>" />
							<s:property value="ContractorId" />-<s:property
								value="#e.ContractorName" />
						</s:iterator>
					</select> <br />
				</div>
				<div id="rejected" style="margin-top: 20px;">
					Reason:
					<textarea rows="10" cols="30" id="reason" name="reason">click here to type.....</textarea>
					<br /> <br />
				</div>
				<br />
				<input type="submit" value="submit" id="submit">
			</form>
			</section>
			</section>
			</section>
			</section>
		</s:if>
		<s:else>
			<jsp:forward page="NotInSession.jsp" />
		</s:else>
	</div>
	<br />
	<br />
	<div
		style="width: 100%; margin-top: 50px; float: left; padding-top: 12px; background-repeat: repeat-x; height: 69px; background-color: #FFDB94; border: 1px solid #e4e4e4;">
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

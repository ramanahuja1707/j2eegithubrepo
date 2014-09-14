<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function validateLogin() {
		var x1 = document.forms["MyForm"]["att"].value;
		var x2 = document.forms["MyForm"]["att2"].value;
		var x3 = document.forms["MyForm"]["att3"].value;
		var x4 = document.forms["MyForm"]["att4"].value;
		var x5 = document.forms["MyForm"]["att5"].value;
		var x6 = document.forms["MyForm"]["att6"].value;
		var x7 = document.forms["MyForm"]["att7"].value;
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

		if (x5 == null || x5 == "") {
			alert("Please fill the  reqd. fields !!");
			return false;
		}

		if (x6 == null || x6 == "") {
			alert("Please fill the  reqd. fields !!");
			return false;
		}

		if (x7 == null || x7 == "") {
			alert("Please fill the  reqd. fields !!");
			return false;
		}
		return true;
	}
</script>
<sj:head />
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
		<s:if test="#session.EmpNo!=null">
			<section style="width:25%;height:360px;"> <section
				class="left" style="height:360px;"> <section class="box"
				style="height:360px;"> <section class="innerbox">Employee
			Details</section>
			<table    style="width:25%;height:AUTO;background-color: #ffc">
				<tr>
					<td>Employee Name:</td>
					<td><input type="text"
						value="<s:property value="ed1.EmpName"/>" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Designation:</td>
					<td><input type="text"
						value="<s:property value="ed1.EmpDesig"/>" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Grade:</td>
					<td><input type="text"
						value="<s:property value="ed1.EmpGrade"/>" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Department:</td>
					<td><input type="text"
						value="<s:property value="ed1.EmpDept"/>" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Employee No.:</td>
					<td><input type="text" value="<s:property value="ed1.Empno"/>"
						disabled="disabled" /></td>
				</tr>

				<tr>
					<td>Employee Unit:</td>
					<td><input type="text"
						value="<s:property value="ed1.EmpUnit"/>" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Office Contact:</td>
					<td><input type="text"
						value="<s:property value="ed1.EmpContact"/>" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Employee Email:</td>
					<td><input type="text"
						value="<s:property value="ed1.EmpEmail"/>" disabled="disabled" /></td>
				</tr>
			</table>
			<br/>
			<center><img src="images/logout1.png" height="21px" width="21px"
						class="navicon" /><a href="logout" id="menu4">Logout
							</a></center>
			</section> </section> </section>
			</section>

			<!------>

			<div class="midcontent"
				style="width: 60%; float: right; margin-right: 150px;">
				<div class="midcontent_box" style="background-color: #ffdb94">
				<div class="nav">
					<img src="images/checkstatus.png"  height="21px" width="21px" class="navicon" /><span class="nav1"><a
						href="CheckStatus.jsp" id="menu1">Check Status</a></span> <img src="images/booknow.png"
						class="navicon"  height="21px" width="21px" /><span class="nav1"><a href="BookNow"
						id="menu2">Book Now</a></span> <img src="images/history1.png"
						height="21px" width="21px" class="navicon"  height="21px" width="21px"/><span class="nav1"><a
						href="ShowRejectedRequests" id="menu3">Rejected</a></span> <img src="images/approved.jpg" height="21px" width="21px"
						class="navicon" /><span class="nav1"><a href="ShowApprovedRequests" id="menu4">Approved
							</a></span>
				</div>
			</div>
				<div
					style="width: 100%; margin-top: 10px; float: left; text-align: left; color: #2fabab; font-family: 'Times New Roman', Times, serif; font-size: 18px; font-style: italic;">PLEASE FILL CONVIENCE DETAILS !
				<br/>
					<s:form action="EmployeeRequest" method="post" id="MyForm"
						onsubmit="return validateLogin()">
						<s:textarea label="Reporting Address:" key="ti.EmpAddress"
							style="width: 136px; height: 51px;" id="att" />
						<s:textfield label="Mobile No.:" key="ti.EmpMobileNo" id="att2" />
						<s:textarea label="Purpose:" key="ti.EmpPurpose"
							style="width: 136px; height: 51px;" id="att3" />
						<sj:datepicker name="ti.CarReportingDate" label="Mention Date:"
							id="att4" />
						<s:textfield label="Mention Timings:" key="ti.CarReportingTime"
							id="att5" />
						<s:radio list="{'Ambassador','Indica','Esteem','Lancer'}"
							label="Select Car:" name="ti.CarName" value="Ambassador"
							id="att6" />
						<s:radio list="{'Ac','Non-Ac'}" label="Select Car Type:"
							name="ti.CarType" value="Ac" id="att7" />
						<s:reset />
						<s:submit onclick="return validateLogin()" />
					</s:form>
				 <br />
					<font style="color: red;"><s:property
							value="ValidateFieldStatus" /> <s:property value="RequestCheck" /></font>
			</div>
			</div>
		</s:if>
		<s:else>
			<jsp:forward page="NotInSession.jsp" />
		</s:else>
	</div>
	<br />
	<br />
	<div
		style="width: 100%; float: left; padding-top: 12px; background-repeat: repeat-x; height: 69px; background-color: #FFDB94; border: 1px solid #e4e4e4;">
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

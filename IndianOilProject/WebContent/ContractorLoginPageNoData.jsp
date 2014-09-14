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

		$("#validaterequests").fadeOut(1000);
		
	});
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
		<s:if test="#session.ContractorId!=null">
			<!------>
			<div class="midcontent"
				style="width: 60%; float: right; margin-right: 150px;">
				<div class="midcontent_box">
					<div class="nav">
						<center>
							<a href="ContractorLogout"><img src="images/logout.png" height="26px"
								alt="Logout"></a>
						</center>
					</div>
				</div>
				<div
					style="width: 100%; margin-top: 10px; float: left; text-align: left; color: #2fabab; font-family: 'Times New Roman', Times, serif; font-size: 18px; font-style: italic;">
					<br />
					<center>
						<em><h2>ALL REQUESTS RESOLVED</h2></em>
					</center>
					<div id="validaterequests">
						<s:property value="ValidateApproveStatus" />
						<s:property value="ApprovalStatus" />
						<s:property value="ValidateRejectStatus" />
						<s:property value="RejectionStatus" />
					</div>
				</div>
			</div>
			<!------->
		</s:if>
		<s:else>
			<jsp:forward page="NotInSession.jsp" />
		</s:else>
	</div>
	<br />
	<br />
	<div
		style="width: 100%; margin-top: 300px; float: left; padding-top: 12px; background-repeat: repeat-x; height: 69px; background-color: #FFDB94; border: 1px solid #e4e4e4;">
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

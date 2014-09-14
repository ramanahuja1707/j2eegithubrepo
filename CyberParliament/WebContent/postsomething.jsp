<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page
	import="java.util.ArrayList,
 java.util.List,
 java.util.Map,
 org.apache.struts2.dispatcher.SessionMap,
 org.apache.struts2.interceptor.SessionAware,
 org.hibernate.Query,
 org.hibernate.Session,
 org.hibernate.SessionFactory,
 org.hibernate.cfg.Configuration,
 com.cyber.model.Client"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="success.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function clear() {
		var x = document.getElementById("text").value = '';
		return false;
	}
</script>
</head>

<body>
	<s:if test="#session.username!=null">
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
				class="box"> <section class="innerbox">Information
			<br />
			<ul>
				<li><a href="post">SEE POST</a></li>
				<li>POST
					<Ol>
						<li><a href="postsomething.jsp">POST SOMETHING</a></li>
						<li><a href="search.jsp">SEARCH</a></li>
					</Ol>
				</li>
				<li>APPROVAL
					<Ol>
						<li><a href="sent">Sent</a></li>
						<li><a href="approved">Approved</a></li>
					</Ol>
				</li>
				<li><a href="#">MESSAGES</a></li>
				<li><a href="profile">PROFILE</a></li>
				<li><a href="#">CONTACT US</a></li>
				<li><a href="logout">LOGOUT</a></li>
			</ul>
			</section> </section> </section> <section class="left"></section> </section>
			<s:if test="#session.username!=null">
			<s:form action="postsomething" method="post"
				onsubmit=" return clear()">
				<s:select
					list="{'Agricultures & Cooperation','Animal Husbandry & Fishing','Art & Culture','Coal & Mine','Chemicals & Fertilizers','Commerce & Industry','Communications & Information Technology','Defences','Education & Training','Employment & Labour','Energy & Power','Environment & Natural Resources','Finance, Banking & Insurance','Food & Public Distribution','Forestry & Wildlife','Governance & Administration','Health & Family welfare','Home affairs & National Security','Housing & Urban Development','Information & Broadcasting','International Affairs','Law & Justice','People & Organisations','Petroleum, Oil & Natural Gas','Rural Development & Panchayati Raj','Science, Technology & Research','Social Justice & Empowerment','Tourism','Transport & Infrastructure','Youth Affairs & Sports'}"
					key="p.department" label="Select Department:" />
				<s:textarea key="p.post" label="Post"
					style="width: 586px; height: 160px;" id="text" />
				<s:submit label="Update Post" />
			</s:form>
			<!-- -->
			<br />
			<s:property value="#session.posted" /></s:if>
			<s:else>
			<jsp:forward page="notwithinsession.jsp"></jsp:forward></s:else>
			<section style=" float:right;"> <section class="left">
			</section> </section>
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
				<a href="www.facebook.com"><img src="images/fb_icon.jpg" /></a> <a
					href="www.twitter.com"><img src="images/twtr_icon.jpg" /></a> <a
					href="www.gmail.com"><img src="images/gm_icon.jpg" /></a>
			</div>
		</div>
	</s:if>
	<s:else>
		<jsp:forward page="error.jsp"></jsp:forward>
	</s:else>
</body>
</html>

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
				<s:if test="posttosearch.size!=null">
					<s:iterator var="e" value="posttosearch">
						<form action="action">
							<div
								style="width: 60%; margin-top: 10px; margin-left: 400px; margin-right: 20px; border: 1px solid #e4e4e4; background-color: #F0FFFF">
								<img alt="" src="images/images.jpg" width="10%" height="10%">
								NAME:<a href=""><s:property value="#e.postusername" /></a> <br>
								DEPARTMENT:<a href=""><s:property value="#e.department" /></a>
								<br> DATE:
								<s:property value="#e.postdate" />
								<br>
								<textarea><s:property value="#e.post" /></textarea>
								<br> <a href=""><u>Like.</u></a> <a href=""><u>Share</u></a>
								<br>
								<textarea style="width: 148px; height: 37px"></textarea>
								<br> <a href=""><input type="button" value="Comment"
									style="background-color: #F0FFFF;" /></a>
							</div>
						</form>
					</s:iterator>
				</s:if>
			</s:if>
			<s:else>
				<jsp:forward page="notwithinsession.jsp" />
			</s:else>
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

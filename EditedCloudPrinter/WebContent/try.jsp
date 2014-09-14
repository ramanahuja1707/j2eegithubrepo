<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
 <%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<sj:head jqueryui="true"/>
<script type="text/javascript">
    $.subscribe('before', function(event,data) {
      var fData = event.originalEvent.formData;
         alert('About to submit: \n\n' + fData[0].value + ' to target '+event.originalEvent.options.target+' with timeout '+event.originalEvent.options.timeout );
      var form = event.originalEvent.form[0];
      if (form.echo.value.length < 2) {
          alert('Please enter a value with min 2 characters');
          // Cancel Submit comes with 1.8.0
          event.originalEvent.options.submit = false;
      }
    });
    $.subscribe('complete', function(event,data) {
         alert('status: ' + event.originalEvent.status + '\n\nresponseText: \n' + event.originalEvent.request.responseText + 
     '\n\nThe output div should have already been updated with the responseText.');
    });
    $.subscribe('errorState', function(event,data) {
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status);
    });
    </script>
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
					<table>
						<tr>
							<td><b><i><font color="#067aa7">CREATE FILES</font></i>
							</b> <br /> <a href="upload.jsp"><img alt="Upload Files"
									width="20px" height="20px" src="images/upload.png"> </a></td>
						</tr>
						<tr>
							<td><b><i><font color="#067aa7">COLLECT TEXT
											FILES</font></i></b><a href="showfiles"><img alt="Show Files"
									width="20px" height="20px" src="images/showfiles.jpg"> </a></td>
						</tr>
						<tr>
							<td><b><i><font color="#067aa7">SHOW TEXT
											FILES</font></i></b><br /> <a href="showfilesforprint"><img
									alt="Show Files" width="20px" height="20px"
									src="images/print.jpg"></td>
						</tr>
						<tr>
							<td><b><i><font color="#067aa7">UPLOAD IMAGE
											FILES</font></i></b><a href="fileuploadformat.jsp"><img alt="Show Files"
									width="20px" height="20px" src="images/uploadimage.jpg"></td>
						</tr>
						<tr>
							<td><b><i><font color="#067aa7">COLLECT IMAGE
											FILES</font></i></b><br /> <a href="showimagefiles"><img
									alt="show image files" width="20px" height="20px"
									src="images/showimage.jpg"></td>
						</tr>
						<tr>
							<td><b><i><font color="#067aa7">UPLOAD TEXT
											FILES</font></i></b><a href="uploadtextfile.jsp"><img
									alt="show image files" width="20px" height="20px"
									src="images/uploadtext.jpg"></td>
						</tr>
						<tr>
							<td><b><i><font color="#067aa7">COLLECT TEXT
											FILES</font></i></b><a href="showtextfiles"><img alt="show image files"
									width="20px" height="20px" src="images/showtext.jpg"></td>
						</tr>
						<tr>
							<td><b><i><font color="#067aa7"></font></i></b><a
								href="uploadpdf.jsp">UPLOAD PDF FILES</a></td>
						</tr>
						<tr>
							<td><b><i><font color="#067aa7"></font></i></b><a
								href="showpdffiles">PRINT PDF FILES</a></td>
						</tr>

					</table>
				</div>
			</div>
			<br /> <br /> <br /> <br /> <br /> <br />
			<p>
			<center>
				WELCOME : <b><s:property value="#session.username" /></b> <br />

				<s:property value="s1" />
				<br>
				<s:property value="printstatus" />
				<br>

			</center>
			</p>
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
	<br/>
<s:url var="echourl" action="echo"/>
    <sj:menu
            id="menuStringList"
            href="%{echourl}"
            paramName="echo"
            targets="result"
            cssStyle="width:50%"
            list="#{'Java', 'JavaScript', 'Scala', 'JRuby'}"
            />
    <strong>Result Div :</strong>
<br/>

    <sj:menu id="menuWithItems" cssStyle="width:30%;" >
        <sj:menuItem title="Struts2" href="http://struts.apache.org/2.x/index.html" />
        <sj:menuItem title="Struts2 jQuery News" menuIcon="ui-icon-extlink" href="http://www.jgeppert.com/category/java/struts2-jquery/"/>
        <sj:menuItem title="Struts2 Plugins">
            <sj:menu id="subMenuPlugins" cssStyle="width:50%">
                <sj:menuItem title="Struts2 Plugins" href="https://cwiki.apache.org/S2PLUGINS/home.html"/>
                <sj:menuItem title="Struts2 jQuery Plugin" href="http://code.google.com/p/struts2-jquery/"/>
                <sj:menuItem title="Struts2 Bootstrap Plugin" href="http://code.google.com/p/struts2-jquery/"/>
            </sj:menu>
        </sj:menuItem>

        <sj:menuItem title="Struts2 @ Social Media">
            <sj:menu id="subMenuSocialMedia" cssStyle="width:50%">
                <sj:menuItem title="Struts2 @ Twitter" href="https://twitter.com/TheApacheStruts"/>
                <sj:menuItem title="Struts2 @ Google+" href="https://www.google.com/+ApacheStruts"/>
                <sj:menuItem title="Struts2 @ Facebook" href="http://www.facebook.com/struts2"/>
            </sj:menu>
        </sj:menuItem>

        <sj:menuItem title="AJAX">
            <sj:menu id="subMenuAjax" cssStyle="width:50%">
                <s:url var="ajax1" value="/ajax1.action"/>
                <sj:menuItem title="Ajax 1" href="%{ajax1}" targets="result"/>
                <s:url var="ajax2" value="/ajax2.action"/>
                <sj:menuItem title="Ajax 2" href="%{ajax2}" targets="result" effect="highlight" effectDuration="2500"/>
                <s:url var="ajax3" value="/ajax3.action"/>
                <sj:menuItem title="Ajax 3" href="%{ajax3}" targets="result" onBeforeTopics="beforeLink"
                             onCompleteTopics="completeLink"/>
                <s:url var="ajax4" value="/ajax4.action"/>
                <sj:menuItem title="Ajax 4" href="%{ajax4}" menuIcon="ui-icon-gear" targets="result" effect="bounce" effectDuration="1000"/>
            </sj:menu>
        </sj:menuItem>
    </sj:menu>
<br/>
<sj:progressbar id="progressbar" value="50"/>
<br/>
 <sj:spinner
        name="spinner2"
        id="spinner2"
        min="5"
        max="50"
        step="2"
        value="25"/>

<sj:dialog id="mydialog1" title="Local Dialog">
     Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
   </sj:dialog>
<br/>
  <s:url var="remoteurl" action="myremoteaction"/>
    <sj:dialog id="mydialog2" href="%{remoteurl}" title="Remote Dialog"/>
<br/>
<s:form id="form" action="echo" theme="xhtml">
                            <sj:checkboxlist
                                        id="checkboxbuttonset"
                                    tooltip="Choose your Friends"
                                    label="Friends"
                                    list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
                                    name="echo"/>
                    <sj:submit 
                        targets="formResult" 
                        value="AJAX Submit" 
                        indicator="indicator"
                        button="true"
                    />
    </s:form>
<br/>
<sjt:tree id="treeStatic" jstreetheme="default" openAllOnLoad="true">
                <sjt:treeItem title="Struts2">
                        <sjt:treeItem title="General">
                                <sjt:treeItem title="Struts2" href="http://struts.apache.org/2.x/index.html"/>
                                <sjt:treeItem title="Struts2 @ Facebook" href="http://www.facebook.com/pages/Struts2-Users/103890046351798"/>
                        </sjt:treeItem>
                        <sjt:treeItem title="Plugins">
                                <sjt:treeItem title="Struts2 Plugins" href="https://cwiki.apache.org/S2PLUGINS/home.html"/>
                                <sjt:treeItem title="Struts2 jQuery Plugin" href="http://code.google.com/p/struts2-jquery/"/>
                                <sjt:treeItem title="Struts2 Full Hibernate Plugin" href="http://code.google.com/p/full-hibernate-plugin-for-struts2/"/>
                        </sjt:treeItem>
                        <sjt:treeItem title="Blogs">
                                <sjt:treeItem title="Struts2 jQuery News" href="http://www.jgeppert.com/category/java/struts2-jquery/"/>
                        </sjt:treeItem>
                        <sjt:treeItem title="AJAX Links">
                                        <s:url id="ajax1" value="/ajax1.action"/>
                                <sjt:treeItem title="Ajax 1" href="%{ajax1}" targets="result"/>
                                        <s:url id="ajax2" value="/ajax2.action"/>
                                <sjt:treeItem title="Ajax 2" href="%{ajax2}" targets="result" effect="highlight" effectDuration="2500"/>
                                        <s:url id="ajax3" value="/ajax3.action"/>
                                <sjt:treeItem title="Ajax 3" href="%{ajax3}" targets="result" onBeforeTopics="beforeLink" onCompleteTopics="completeLink"/>
                                        <s:url id="ajax4" value="/ajax4.action"/>
                                <sjt:treeItem title="Ajax 4" href="%{ajax4}" targets="result" effect="bounce" effectDuration="1000"/>
                        </sjt:treeItem>
                </sjt:treeItem>
        </sjt:tree>

<br/>
<center>
<s:form>
                <s:url var="urlsimpleecho" action="simpleecho"><s:param name="echo">remote content for textfield!</s:param></s:url>
                <sj:textfield href="%{urlsimpleecho}" id="echo" name="echo" loadingText="Loading content of textfield ..."/>
        </s:form>
        <br/>
        <s:form id="formevent" action="echo" theme="simple" cssClass="yform">
        <fieldset>
            <legend>AJAX Form</legend>
                <div class="type-text">
                    <label for="echo">Echo: </label>
                    <s:textfield id="echo" name="echo" value="Hello World!!!"/>
                </div>
                <div class="type-button">
                    <sj:submit  targets="result" 
                                        value="AJAX Submit" 
                                        timeout="2500" 
                                        indicator="indicator" 
                                        onBeforeTopics="before" 
                                        onCompleteTopics="complete" 
                                        onErrorTopics="errorState"  
                                        effect="highlight" 
                                        effectOptions="{ color : '#222222' }" 
                                        effectDuration="3000"/>
                </div>
        </fieldset>
    </s:form>

    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    
    
    <s:form id="formeventerror" action="file-does-not-exist.html" theme="simple" cssClass="yform">
        <fieldset>
            <legend>AJAX Form with Error Result</legend>
            <div class="type-text">
                <label for="echo">Echo: </label>
                <s:textfield id="echo" name="echo" value="Hello World!!!"/>
            </div>
            <div class="type-button">
                <sj:submit      targets="result" 
                                        value="AJAX Submit with Error" 
                                        timeout="2500" 
                                        indicator="indicator" 
                                        onBeforeTopics="before" 
                                        onCompleteTopics="complete" 
                                        onErrorTopics="errorState" 
                                        effect="highlight" 
                                        effectOptions="{ color : '#222222' }" 
                                        effectDuration="3000"/>
            </div>
        </fieldset>
    </s:form>
        
        </center>
        
</body>
</html>

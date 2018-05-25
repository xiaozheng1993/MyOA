<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ page import="com.demo.struts.util.Constants"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<html>
<head>
<title>Demo - <decorator:title default="Welcome!" /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
<decorator:head />
</head>

<body>
<div align="center"><%if (session.getAttribute(Constants.USERNAME_KEY) != null) {%>
<table width="100%">
	<tr style="height: 100px;background-color: pink">
		<%--<td><img src='images/<bean:message key="image.logo" />'></td>
		<td><img src='images/<bean:message key="image.banner" />' height="90"></td>--%>
			<td>ZZL</td>
			<td> MyOA</td>
	</tr>
	<tr>
		<td colspan="2">
		<hr>
		</td>
	</tr>
	<tr>
		<td width="160" bgcolor="#EEEEEE" valign="top">
		<table width="100%">
			<tr>
				<td><li><a href="welcome.do"><bean:message key="frame.main" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="address.do?method=list"><bean:message key="frame.address" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="schedule.do?method=list"><bean:message key="frame.schedule" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="worklog.do?method=list"><bean:message key="frame.worklog" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="sms.do?method=list"><bean:message key="frame.sms" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="notice.do?method=list"><bean:message key="frame.notice" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="meeting.do?method=list"><bean:message key="frame.meeting" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="logout.do"><bean:message key="frame.logout" /></a></li></td>
			</tr>
		</table>
		</td>
		<td align="left" valign="top"><decorator:body /></td>
	</tr>
</table>
<%} else {%> <decorator:body /> <%}%>
<hr>
2018 copyright  1182972642@qq.com</div>
</body>
</html>

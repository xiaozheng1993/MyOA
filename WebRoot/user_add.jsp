<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<html:html locale = "true"/> 
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><bean:message key="meeting_add.page.position" /></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="styles.css">
	<link type="text/css" rel="stylesheet" href="css/jeDate-test.css">
	<link type="text/css" rel="stylesheet" href="css/jedate.css">
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="js/jquery.jedate.js"></script>
	<script type="text/javascript">
        /**
         * jeDate 演示
         */
        $(function () {
            //常规选择
            $("#test03").jeDate({
                format: "YYYY-MM-DD"
            });
            $("#test04").jeDate({
                format: "YYYY-MM-DD"
            });


        });
	</script>
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><bean:message key="meeting_add.page.position" /></TD>
		<TD align="right"><a href="meeting.do?method=back"><bean:message
			key="meeting_add.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form name="form1" action="meeting_add.do?method=insert" method="post">
<b><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></b>
<TABLE border="0" width="100%">
	<TR>
		<TD><bean:message key="meeting.page.starttime" /></TD>
		<TD>
			<input type="text" id="test03" name="starttime" maxlength="100">
		</TD>
	</TR>
	<TR>
		<TD><bean:message key="meeting.page.endtime" /></TD>
		<TD>
			<input type="text" id="test04" name="endtime" maxlength="100">
		</TD>
	</TR>
	<TR>
		<TD><bean:message key="meeting.page.address" /></TD>
		<TD><logic:present name="meetingFormBean">
			<html:text property="address" name="meetingFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="meetingFormBean">
			<input type="text" name="address" maxlength="100">
		</logic:notPresent> <html:errors property="address" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="meeting.page.title" /></TD>
		<TD><logic:present name="meetingFormBean">
			<html:text property="title" name="meetingFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="meetingFormBean">
			<input type="text" name="title" maxlength="100">
		</logic:notPresent> <html:errors property="title" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="meeting.page.content" /></TD>
		<TD><textarea name="content" cols="60" rows="15"><logic:present name="meetingFormBean"><bean:write property="content" name="meetingFormBean" /></logic:present></textarea>  <html:errors property="content" /></TD>
	</TR>
	<TR>
		<TD colspan="2"><input type="submit"
			value="<bean:message key='button.submit' />"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

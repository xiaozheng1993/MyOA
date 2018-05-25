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

<title><bean:message key="worklog_add.page.position" /></title>

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


        });
	</script>
</head>

<body>
<TABLE width="100%" class="position">
	<TR>
		<TD><bean:message key="worklog_add.page.position" /></TD>
		<TD align="right"><a href="worklog.do?method=back"><bean:message
			key="worklog_add.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form name="form1" action="worklog_add.do?method=insert" method="post">
<b><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></b>
<TABLE border="0" width="100%">
	<%--<TR>
		<TD><bean:message key="worklog.page.year" /></TD>
		<TD><logic:present name="worklogFormBean">
			<html:text property="year" name="worklogFormBean" maxlength="4"/>
		</logic:present> <logic:notPresent name="worklogFormBean">
			<input type="text" name="year" maxlength="4">
		</logic:notPresent> <html:errors property="year" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="worklog.page.month" /></TD>
		<TD><logic:present name="worklogFormBean">
			<html:text property="month" name="worklogFormBean" maxlength="2"/>
		</logic:present> <logic:notPresent name="worklogFormBean">
			<input type="text" name="month" maxlength="2">
		</logic:notPresent> <html:errors property="month" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="worklog.page.day" /></TD>
		<TD><logic:present name="worklogFormBean">
			<html:text property="day" name="worklogFormBean" maxlength="2"/>
		</logic:present> <logic:notPresent name="worklogFormBean">
			<input type="text" name="day" maxlength="2">
		</logic:notPresent> <html:errors property="day" /></TD>
	</TR>--%>
		<%--新加字段--%>
		<TR>
			<TD><bean:message key="schedule.page.time" /></TD>
			<TD><logic:present name="worklogFormBean">
				<%--<html:text property="time" name="scheduleFormBean" maxlength="10"/>--%>
			</logic:present>
				<%--<logic:notPresent name="scheduleFormBean">--%>

				<input type="text" name="time" class="jeinput" id="test03" placeholder="YYYY-MM-DD">

				<%--<input type="text" name="time" maxlength="10">--%>
				<%--</logic:notPresent> --%>
				<html:errors property="time" /></TD>
		</TR>
	<TR>
		<TD><bean:message key="worklog.page.title" /></TD>
		<TD><logic:present name="worklogFormBean">
			<html:text property="title" name="worklogFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="worklogFormBean">
			<input type="text" name="title" maxlength="100">
		</logic:notPresent> <html:errors property="title" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="worklog.page.description" /></TD>
		<TD><textarea name="description" cols="60" rows="15"><logic:present name="worklogFormBean"><bean:write property="description" name="worklogFormBean" /></logic:present></textarea>  <html:errors property="description" /></TD>
	</TR>
	<TR>
		<TD colspan="2"><input type="submit"
			value="<bean:message key='button.submit' />"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>

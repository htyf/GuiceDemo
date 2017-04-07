<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Access Status</h1>
	<h3>
		<b>Access in this session:</b>
		<s:property value="count" />
	</h3>

	<h3>
		<b>Status:</b>
		<s:property value="status" />
	</h3>
	<h3>
		<b>Message:</b>
		<s:property value="message" />
	</h3>
	<h4><%="sessionId=" + session.getId()%></h4>


</body>
</html>
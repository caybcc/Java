<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRM</title>
</head>
<body style="overflow-y:hidden;">
	<iframe src="<c:url value='header.jsp' />" name="up" style="border:none;width:100%;height:200px;border-bottom:1px solid rgba(229, 229, 229, 0.9);"></iframe><br></br>
	<iframe src="<c:url value='index.jsp' />" name="down" style="border:none;width:100%;height:420px;"></iframe>
</body>
</html>
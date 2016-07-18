<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.1.4.min.js"></script>
<title>JB's Default</title>
</head>
<body>
	<tiles:insertAttribute name="body"/>
</body>
</html>
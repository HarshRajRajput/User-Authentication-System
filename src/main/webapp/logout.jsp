<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// Invalidate the session
if (session != null) {
	session.invalidate();
}

// Prevent caching of previous pages
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<html>
<head>
<title>Logout</title>
<!-- Link external CSS -->
<link rel="stylesheet" type="text/css" href="logout-styles.css">
</head>
<body>
	<div class="container">
		<h2>You have logged out successfully</h2>
		<form action="login.jsp" method="get">
			<button type="submit">Login Again</button>
		</form>
	</div>
</body>
</html>


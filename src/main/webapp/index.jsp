
<%
// prevent browser caching
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%
// JSP automatically provides 'session' object
if (session != null && session.getAttribute("username") != null) {
	// user already logged in → redirect to home
	response.sendRedirect("home.jsp");
	return;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome - Login or Register</title>
<link rel="stylesheet" href="index-styles.css">
</head>
<body>
	<div class="container">
		<h1>Welcome</h1>
		<p class="subtitle">Choose an option to get started</p>

		<div class="button-container">
			<a href="login.jsp" class="btn btn-login"> Login </a>

			<div class="divider">
				<span>or</span>
			</div>

			<a href="registration.html" class="btn btn-register"> Register </a>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
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
<title>Login</title>
<link rel="stylesheet" href="login-styles.css">
<script type="text/javascript">
	// Prevent Cached page after logout
	window.addEventListener("pageshow", function(event) {
		if (event.persisted) {
			window.location.reload();
		}
	})
</script>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<p class="subtitle">Enter your credentials to continue</p>

		<form class="login-form" action="login" method="post">
			<div class="form-group">
				<label for="email">Email Address</label> <input type="email"
					id="email" name="email" placeholder="you@example.com" required>
			</div>

			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					id="password" name="password" placeholder="Enter password" required>
			</div>
			
			<!-- Forgot password link placed here -->
			<div class="forgot-container">
				<a href="updatePassword.html" class="forgot-link">Forgot Password?</a>
			</div>

			<button type="submit" class="btn btn-login">Sign In</button>

			<div class="form-footer">
				<p>
					Don't have an account? <a href="registration.html" class="link">Register
						here</a>
				</p>
				<a href="index.jsp" class="back-link">← Back to home</a>
			</div>
		</form>
	</div>
</body>
</html>
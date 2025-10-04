
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
if (session == null || session.getAttribute("username") == null) {
    // not logged in → redirect to login page
    response.sendRedirect("login.jsp");
    return;
}
String user = (String) session.getAttribute("username");
String created_at = (String) session.getAttribute("created_at");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome - Home</title>
<link rel="stylesheet" href="home-styles.css">
<script type="text/javascript">
  // Prevent Cached page after logout
  window.addEventListener("pageshow", function(event){
	  if (event.persisted){
		  window.location.reload();
	  }
  })
</script>
</head>
<body>
<div class="container">
    <div class="welcome-section">
        <h1>Welcome Back!</h1>
        <p class="welcome-text">You have successfully logged in to your account.</p>
        
        <div class="user-info">
            <div class="info-item">
                <span class="label">Username:</span>
                <span class="value"><%=user%></span>
            </div>
            <div class="info-item">
                <span class="label">Register on:</span>
                <span class="value"><%=created_at%></span>
            </div>
            <div class="info-item">
                <span class="label">Status:</span>
                <span class="value active">Active</span>
            </div>
        </div>
        
        <div class="logout-section">
            <form action="logout.jsp" method="post">
                <button type="submit" class="logout-btn">Logout</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>


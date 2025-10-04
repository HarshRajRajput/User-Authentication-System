package com.tech;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", 0); // Proxies
		// JSP automatically provides 'session' object
		if (session != null && session.getAttribute("username") != null) {
			// user already logged in → redirect to home
			response.sendRedirect("home.jsp");
			return;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Reading form input values sent by the user
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// JDBC CODE

		try {
			// Step-1: Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2 : Establish the Connection
			String url = "jdbc:mysql://localhost:3306/user_management_db";
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);

			// Step-3 : Prepare SQL Statement
			String query = "SELECT * FROM `user` WHERE email = ? AND password = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, userEmail);
			ps.setString(2, userPassword);

			// Step-4: Execute SQL Statement
			rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("fullname");
				String created_at = rs.getString("created_at");

				// New Session Created
				HttpSession session = request.getSession(true);
				session.setAttribute("username", name);
				session.setAttribute("created_at", created_at);

				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("error.html");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Step-5: Close the Connection
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

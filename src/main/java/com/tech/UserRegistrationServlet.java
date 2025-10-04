package com.tech;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Reading form input values sent by the user
		String userFullName = request.getParameter("fullname");
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");

		// JDBC Connection
		Connection con = null;
		PreparedStatement ps = null;
		int rowEffect = 0;
		try {
			// Step-1 : Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2 : Establish the Connection
			String url = "jdbc:mysql://localhost:3306/user_management_db";
			String user = "root";
			String password = "admin";
			con = DriverManager.getConnection(url, user, password);

			// Step-3 : Prepare SQL Statement
			String query = "INSERT INTO `user`  (fullname, email, password) VALUES (?, ?, ?)";
			ps = con.prepareStatement(query);
			ps.setString(1, userFullName);
			ps.setString(2, userEmail);
			ps.setString(3, userPassword);

			// Step-4: Execute SQL Statement
			rowEffect = ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("Database Error: " + e.getMessage());
		} finally {
			// Step-5 : Close the Connection
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (rowEffect == 1) {
			response.sendRedirect("registrationSucces.html");
		} else {
			response.sendRedirect("redistration.html");
		}

	}

}

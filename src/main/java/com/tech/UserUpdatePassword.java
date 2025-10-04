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
 * Servlet implementation class UserUpdatePassword
 */
@WebServlet("/update_password")
public class UserUpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdatePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Reading form input values sent by the user
		String email = request.getParameter("email");
		String newPassword = request.getParameter("newPassword");

		int rowEffected = 0;
		Connection con = null;
		PreparedStatement ps = null;

		try {

			// Step-1 : Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2 : Establish the Connection
			String url = "jdbc:mysql://localhost:3306/user_management_db";
			String userName = "root";
			String password = "admin";

			con = DriverManager.getConnection(url, userName, password);

			// Step-3 : Prepare SQL Statement

			String query = "update `user` " + " set password = ? " + "where email = ?";

			ps = con.prepareStatement(query);

			ps.setString(1, newPassword);
			ps.setString(2, email);

			// Step-4: Execute SQL Statement
			rowEffected = ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (rowEffected == 1) {
				response.sendRedirect("updatePasswordSucces.html");
			} else {
				response.sendRedirect("updatePasswordError.html");
			}
		}

	}

}

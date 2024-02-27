package com.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.io.Writer;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Loginpage", urlPatterns = { "/LoginServletTest" })
public class Login extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("service() method of helloServlet");
		String fname = req.getParameter("fname");
		String password = req.getParameter("password");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "parag");
			PreparedStatement pst = con.prepareStatement("select * from users where name = ? and password = ?");

			pst.setString(1, fname);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("adminloinnext.jsp");
				rd.forward(req, res);

			} else {

				out.print("<h3 style='color:red;text-align:center;'>Email or password not matched <h3>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, res);

			}

			System.out.println("completed");

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}

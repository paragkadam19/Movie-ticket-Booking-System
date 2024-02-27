package com.booking;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteMovies", urlPatterns = { "/admin2" })

public class DeleteMovies extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("service() method of helloServlet");
		String Movies =req.getParameter("movies");

		Writer out = res.getWriter();
		res.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "parag");
			PreparedStatement pst = con.prepareStatement("delete from movie where   title = ? ");

			pst.setString(1, Movies);

			int i = pst.executeUpdate();
			if (i > 0) {
				out.write("deleted");
			} else {
				out.write("sorry ! didn't matched");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}

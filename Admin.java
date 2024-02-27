package com.booking;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Adminpage", urlPatterns = { "/Admin" })
public class Admin extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("service() method of helloServlet");
		String Moviesname = req.getParameter("fname");
		String Genre = req.getParameter("gen");
		String Duration = req.getParameter("dur");
		String Director = req.getParameter("draction");

		Writer out = res.getWriter();
		res.setContentType("text/html");
		out.write("succesfuly Add movies");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "parag");
			PreparedStatement pst = con.prepareStatement("insert into  movie(title, genere, duration,director) values(?,?,?,?)");

			pst.setString(1, Moviesname);
			pst.setString(2, Genre);
			pst.setString(3, Duration);
			pst.setString(4, Director);
			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				System.out.println("sucess");
			
			} else {
				System.out.println("failed");

			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}

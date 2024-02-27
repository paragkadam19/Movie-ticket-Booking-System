package com.booking;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Schedule", urlPatterns = { "/Admin1" })
public class Schedule extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("service() method of helloServlet");
		int MovieId =Integer.parseInt(req.getParameter("moviesid"));
		int ScreenNo = Integer.parseInt(req.getParameter("scrrenno"));
		int  SlotNo =Integer.parseInt(req.getParameter("slot"));
		

		Writer out = res.getWriter();
		res.setContentType("text/html");
		out.write("succesfuly schedule movies");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ booking", "root", "parag");
			PreparedStatement pst = con
					.prepareStatement("insert into   shows( mid, screen , slot) values(?,?,?)");

			pst.setInt(1, MovieId);
			pst.setInt(2, ScreenNo);
			pst.setInt(3, SlotNo);
			
			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				System.out.println("sucess");
				System.out.println("1");

			} else {
				System.out.println("failed");
				System.out.println("0");

			}
			// dispatcher.forward(req,res);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}


}

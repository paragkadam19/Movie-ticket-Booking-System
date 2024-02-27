package com.booking;

import java.io.IOException;
import java.sql.Connection;
import java.io.Writer;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name ="registerpage", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("service() method of helloServlet");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String phoneNo = req.getParameter("phone");
		String password = req.getParameter("password");

		Writer out = res.getWriter();
		res.setContentType("text/html");
		/*
		 * out.write("<h1>Response from hello servlet");
		 * out.write("<hr/>request parameter"); out.write("<br/>fname:" + fname);
		 * out.write("<br/>laname:" + lname); out.write("<br/>email:" + email);
		 * out.write("<br/>password:" + password);
		 * 
		 */
		out.write("Successfully Register Done.....");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "parag");
			PreparedStatement pst = con.prepareStatement("insert into users(name,lastname,email,phoneNo,password) values(?,?,?,?,?)");

			pst.setString(1,fname);
			pst.setString(2,lname);
			pst.setString(3, email);
			pst.setString(4, phoneNo);
			pst.setString(5, password);
			int rowCount = pst.executeUpdate();

			if (rowCount > 0) {
				System.out.println("sucess");
				
			} else {
				System.out.println("failed");
				
			}
			// dispatcher.forward(req,res);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}

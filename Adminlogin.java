package com.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Adminlogin", urlPatterns = { "/loginadmin" })

public class Adminlogin extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		 if ("admin123@gmail.com".equals(email) && "admin123".equals(password)) {
	            // Successful login
	            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin.html");
	            dispatcher.forward(request, response);
	            System.out.println("completed");
	        } else {
	            // Login failed
	           out.println("<h3 style='color:red;text-align:center; '>Doesn't match!<h3>");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("adminLogin.jsp");
	            dispatcher.include(request, response);//include means html page connect show krwata hain message
	        }
	}

	// Get the PrintWriter object to write the HTML page

}

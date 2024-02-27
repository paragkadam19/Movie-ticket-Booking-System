package com.booking;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Booking", urlPatterns = { "/BookingTest"})
public class Booking extends HttpServlet {

	 private static final long serialVersionUID = 1L;
	 
	 private static Map<String, Integer> bookedSeats = new HashMap<>();

	    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
	        
	    	 
	         String seats = req.getParameter("seats");
	         String seatType = req.getParameter("seatType");
	         String paidAmount = req.getParameter("paidAmount");
	         String title =req.getParameter("title");

	       
	         if (seats != null && seatType != null && title != null) {
	             try {
	                 int numSeats = Integer.parseInt(seats);
	                 
	                 res.setContentType("text/html");
	                 PrintWriter out = res.getWriter(); // Declare PrintWriter once

	                 out.write("successfully Add booking");
	         		try {
	         			Class.forName("com.mysql.cj.jdbc.Driver");

	         			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking?useSSL=false", "root", "parag");
	         			PreparedStatement pst = con.prepareStatement("insert into  booked(seats, seatType, paidAmount,title) values(?,?,?,?)");

	         			pst.setString(1, seats);
	         			pst.setString(2, seatType);
	         			pst.setString(3, paidAmount);
	         			pst.setString(4, title);
	         			int rowCount = pst.executeUpdate();

	         			if (rowCount > 0) {
	         				System.out.println("sucess");
	         			
	         			} else {
	         				System.out.println("failed");

	         			}
	         			
	         		} catch (Exception e) {
	         			e.printStackTrace();

	         		}
	         	

	                 // Implement your booking logic here (e.g., check availability, update database
	                 // For simplicity, let's assume a fixed price per seat based on the seat type
	                 int pricePerSeat = getPricePerSeat(seatType);
	                 int totalAmount = numSeats * pricePerSeat;

	                 // Check availability and book seats
	                 boolean isAvailable = checkAvailability(seatType, numSeats);
	                 
	                 if (isAvailable) {
	                     bookSeats(seatType, numSeats);
	                     

	                     
	                     out.println("<html><body>");
	                     out.println("<h2>Tickets Booked Successfully!</h2>");
	                     out.println("<p>Number of Seats: " + numSeats + "</p>");
	                     out.println("<p>Seat Type:" + seatType + "</p>");
	                     out.println("<p>Total Amount: $" + totalAmount + "</p>");
	                     out.println("</body></html>");
	                 } else {
	                    
	                     out.println("<html><body>");
	                     out.println("<h2>Sorry, Shows Full!</h2>");
	                     out.println("</body></html>");
	                 }
	             } catch (NumberFormatException e) {
	                 // Handle invalid number of seats
	            	 res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number of seats.");
	             }
	         } else {
	             // Handle missing parameters
	        	 res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters.");
	         }
	     }

	     private boolean checkAvailability(String seatType, int seats) {
	         // Implement your availability logic here (e.g., check against total capacity)
	         // For simplicity, let's assume a total capacity of 100 for each seat type
	         int totalCapacity = 100;
	         int bookedSeatsForType = bookedSeats.getOrDefault(seatType, 0);
	         int availableSeats = totalCapacity - bookedSeatsForType;

	         return availableSeats >= seats;
	     }

	     private void bookSeats(String seatType, int seats) {
	         // Update booked seats in the in-memory storage
	         bookedSeats.put(seatType, bookedSeats.getOrDefault(seatType, 0) + seats);
	     }

	     private int getPricePerSeat(String seatType) {
	         // You can implement a more complex pricing logic based on seat type
	         switch (seatType) {
	             case "silver":
	                 return 100;
	             case "gold":
	                 return 150;
	             case "platinum":
	                 return 200;
	             default:
	                 return 0; // Default or error case
	         }
	     }
	 }


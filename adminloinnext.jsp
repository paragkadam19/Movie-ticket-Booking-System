<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Table</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<head>
<style>
body {
    background-image:url("Image/pic3.jpg");
	background-size: 100% 700px;
}

.sm {
	padding: 5px 40px;
	border: 1px solid rgb(219, 219, 219);
	outline: none;
	color: rgb(40, 116, 240);
	font-weight: 500px;
	border-radius: 2px;
	height: 32px;
	cursor: pointer;
	font-size: 16px;
	font-family: Arial, Helvetica, sans-serif;
	box-shadow: -1px -1px 10px rgb(54, 54, 54), 1px 1px 10px rgb(54, 54, 54);
	letter-spacing: .1px;
	margin-left: 70px;
	margin-bottom: 20px;
}

.table3 {
	margin: 0 auto;
	position: absolute;
	left: 40%;
	width: 20%;
	background-color: #202124;
	color: white;
}
</style>

</head>
<body>
	<div class="container">
		<h3>Ticket Booking</h3>
		<table class="table table-bordered table-dark table-hover">
			<thead>
				<tr>
					<th>RADIO</th>
					<th>MOVIE</th>
					<th>SHOW SLOT</th>
					<th>DURATION</th>
					<th>SCREEN NO.</th>
					<th>AVAILABLE</th>
				</tr>
			</thead>
			<%
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/booking";
				String uname = "root";
				String pass = "parag";
				String sql = "SELECT m.title, s.slot, m.duration, s.screen, s.booked FROM movie m INNER JOIN shows s ON m.id = s.MID";
				Connection con = DriverManager.getConnection(url, uname, pass);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

				while (rs.next()) {
			%>
			<tr>
				<td><input type="radio" name="selectedRow"
					value="<%=rs.getString("title")%>"></td>
				<td><%=rs.getString("title")%></td>
				<td><%=rs.getString("slot")%></td>
				<td><%=rs.getString("duration")%></td>
				<td><%=rs.getString("screen")%></td>
				<td><%=rs.getString("booked")%></td>
			</tr>
			<%
			}
			con.close();
			} catch (Exception e) {
			out.println(e);
			}
			%>
		</table>
	</div>
	<div class="table3" action="BookingTest">
		<fieldset>
			<legend> </legend>
			<form action="" method="post">
				<h2>BOOKING MOVIE</h2>
				<label for="number">SEAT book</label> 
				<input type="number" name="seats" placeholder="Enter booked"> 
				<br> <br>
				<label>Seat Type:</label>
        <input type="radio" name="seatType" value="silver"> Silver (100)
        <input type="radio" name="seatType" value="gold"> Gold (150)
        <input type="radio" name="seatType" value="platinum"> Platinum (200)
        <br/>
		<a href="Booking.java"><button class="sm">BOOK NOW</button></a>
			</form>
		</fieldset>
	</div>
	<br>
	<br>

</body>
</html>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image: url("Image/movie1.jpg");
	background-size: 100% 700px;
}

.contain h1 {
	color: aqua;
}

.contain {
	border-radius: 20px;
	width: 300px;
	height: 300px;
	background-color: black;
	background: rgba(0, 0, 0, 0.4);
	text-align: center;
	color: #e73c3c;
	margin-left: 36%;
	margin-top: 7%;
}

.contain .text {
	position: relative;
	top: 7%;
}

.inp1 {
	border: none;
	border-radius: 10px;
	background-color: rgba(0, 0, 0, 0.5);
	border-bottom: 2px solid white;
	width: 250px;
	font-size: 20px;
	margin-top: 5px;
	outline: none;
	color: white;
}

.inp2 {
	border: none;
	border-radius: 10px;
	background-color: rgba(0, 0, 0, 0.5);
	border-bottom: 2px solid white;
	width: 250px;
	font-size: 20px;
	margin-top: 10px;
	outline: none;
	color: white;
}

.inp3 {
	width: 200px;
	height: 40px;
	background-color: red;
	border: none;
	font-size: 20px;
	border-radius: 20px;
	margin-top: 20px;
	cursor: pointer;
}

button {
	width: 250px;
	height: 44px;
	background-color: blue;
	color: black;
	border: none;
	font-size: 22px;
	border-radius: 25px;
	margin-top: 5px;
	cursor: pointer;
	color: black;
}


.contain .text{
	color: aqua;
	font-size:17px;
	}
</style>
</head>
<body>
<form action="loginadmin">
		<div class="contain">
			<div class="text">
				<h1>Admin</h1>
				<input class="inp1" type="text" placeholder="Email" name="email" id="123"
					required="required">
					 <input class="inp2" type="password"
					placeholder="Password" name="password" required="required"
					id="myInput"> <br> <br>
				<!-- show password -->
				<input type="checkbox" onclick="myFunction()">Show Password
				
				<button onclick="fun()">SignIn</button>

			</div>
		</div>
	</form>
<!-- show password code -->
	<script>
		function myFunction() {
			var x = document.getElementById("myInput");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>
	
</body>
</html>
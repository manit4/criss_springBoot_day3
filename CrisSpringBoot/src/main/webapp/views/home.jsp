<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<h2 style="margin-left: 300px; color: red;">Enter your details for Login!!</h2>
<div  style="margin-left: 500px; margin-top: 50px; margin-right: 600px">
<h2>${errorMessage}</h2>
<form action="login"  method="post">
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Username</label>
		<input type="text" name="username" class="form-control" id="exampleFormControlInput1">
	</div>
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Password</label>
		<input type="text" name="password" class="form-control" id="exampleFormControlInput1">
	</div>
	
	<button type="submit" class="btn btn-primary">Login</button><br>
	
	</form>
	
	<a href="registrationPage">New User? Register here!!</a>
	
	</div>
</body>
</html>
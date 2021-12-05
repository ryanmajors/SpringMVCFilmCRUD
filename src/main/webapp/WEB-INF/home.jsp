<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Spring MVC Film Site</title>
</head>
<body>
	<div class="header">
		<img src="logo.jpg" alt="logo">
		<div class="header-right">
			<a class="active" href="#home">Home</a> <a href="#contact">Contact</a>
			<a href="#about">About</a>
		</div>
	</div>
	<!-- <h1>R&J Films Inc</h1> -->

	<form action="getfilmbyid.do" method="GET">
		Search film by FilmId: <input type="text" name="filmid" min="1" />
	</form>

	<form action="getfilmbykeyword.do" method="GET">
		Search film by keyword or phrase/pattern: <input type="text"
			name="filmphrase" min="1" />
	</form>
	<br>

	<form action="addfilm" method="POST">
		<button type="submit" name="addfilmbutton">Add Film</button>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/theme/style.css">
<meta charset="UTF-8">
<title>R&J Films</title>
</head>
<body>
<header>
	<nav>
		<ul class="nav-list">
			<li class="nav-item"><a href="#"><img class="logo"
					src="logo.jpg"></a></li>
			<li class="nav-item"><a href="home.do">HOME</a></li>
			<li class="nav-item"><a href="search">SEARCH</a></li>
			<li class="nav-item">
				<form action="addfilm" method="POST">
					<button class="add-film-button" type="submit" name="addfilmbutton">ADD
						FILM</button>
				</form>
			</li>

		</ul>
	</nav>
</header>
	<div class="about-me">
	<h1>About This Site</h1>
	<br><br><br>

	<p>What started as a simple project for class has evolved into one of the greatest film database search sites.
	This site was created using the Spring MVC model and Spring Boot. All the pages you will see were created using
	JSP files and styled with CSS. Over 30 hours were put into building this site and many lessons were learned. 
	The main functionality of this site includes: Searching for films by their assigned id in the database, Searching
	for films based on a keyword search, and the ability to delete and edit films. Custom error pages were built into
	the programming to ensure smooth operation by you.</p>
	</div>
	
	
</body>
</html>
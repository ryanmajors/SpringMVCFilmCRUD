<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/theme/style.css">
<title>R&J Film Deleted</title>
</head>
<body>
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
	
	<h1>You're film has been deleted successfully!</h1>
	<br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/theme/style.css">
<meta charset="UTF-8">
<title>Spring MVC Film Site</title>
</head>
<body>

	<nav>
		<ul class="nav-list">
			<li class="nav-item"><a href="#"><img class="logo"
					src="logo.jpg"></a></li>
			<li class="nav-item"><a href="#">HOME</a></li>
			<li class="nav-item"><a href="#">ABOUT</a></li>
			<li class="nav-item"><a href="#">SEARCH</a></li>
			<li class="nav-item">
			<form action="addfilm" method="POST">
				<button class="add-film-button" type="submit" name="addfilmbutton">ADD FILM</button>
				</form>
			</li>

		</ul>
	</nav>
	<h1>R&J Films Inc</h1>

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
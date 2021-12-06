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

</body>
</html>
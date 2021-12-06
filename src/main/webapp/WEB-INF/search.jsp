<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/theme/style.css">
<title>Insert title here</title>
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

	<form action="getfilmbyid.do" method="GET">
		Search film by FilmId: <input type="text" name="filmid" min="1" />
	</form>



	<form action="getfilmbykeyword.do" method="GET">
		Search film by keyword or phrase/pattern: <input type="text"
			name="filmphrase" min="1" />
	</form>
</body>
</html>
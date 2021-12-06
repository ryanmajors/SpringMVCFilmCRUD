<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/theme/style.css">
<title>R&J Add Film</title>
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
	<form action="addnewfilm.do" method="GET">
		Fill out the form to edit the following film attributes: <br>Title
		<input type="text" class="data" name="title" required="required" /> <br>Description
		<input type="text" class="data" name="description" required="required" />
		<br>Release Year <input type="number" class="data"
			name="releaseyear" required="required" /> <br>Language Id <input
			type="number" class="data" name="languageid" min="1" max="6"
			required="required" /> <br>Rental Duration <input type="number"
			class="data" name="rentalduration" required="required" /> <br>Rental
		Rate <input type="text" class="data" name="rentalrate"
			required="required" /> <br>Length <input type="number"
			class="data" name="length" required="required" /> <br>Replacement
		Cost <input type="text" class="data" name="replacementcost"
			required="required" /> <br>Rating <input type="text"
			class="data" name="rating" required="required" /> <br>Category
		<input type=number class="data" name="categoryid" min="1" max="16"
			required="required" /> <br>
		<button type="submit">Submit</button>
	</form>
	<br>
</body>
</html>
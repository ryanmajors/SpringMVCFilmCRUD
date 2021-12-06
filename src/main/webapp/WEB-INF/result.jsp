<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/theme/style.css">
<title>R&J Results</title>
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
	<c:choose>
		<c:when test="${! empty film}">
				<ul>
					<li>${film.id}</li>
					<li>${film.title}</li>
					<li>${film.description}</li>
					<li>${film.releaseYear}</li>
					<li>${film.languageName}</li>
					<li>${film.rentalDuration}</li>
					<li>${film.rentalRate}</li>
					<li>${film.length}</li>
					<li>${film.replacementCost}</li>
					<li>${film.rating}</li>
					<li>${film.category}</li>
					<li>${film.actors}</li>
				</ul>
				<form action="deletefilm.do">
					<button type="submit" name="deletefilmid" value="${film.id}">Delete
						Film</button>
				</form>


				<form action="editfilm" method="POST">
					<button type="submit" name="editfilmid" value="${film.id}">Edit
						Film</button>
				</form>
		</c:when>

		<c:when test="${! empty films}">
			<c:forEach var="film" items="${films}">
				<ul>
					<li>${film.id}</li>
					<li>${film.title}</li>
					<li>${film.description}</li>
					<li>${film.releaseYear}</li>
					<li>${film.languageName}</li>
					<li>${film.rentalDuration}</li>
					<li>${film.rentalRate}</li>
					<li>${film.length}</li>
					<li>${film.replacementCost}</li>
					<li>${film.rating}</li>
					<li>${film.category}</li>
					<li>${film.actors}</li>
				</ul>
				<form action="deletefilm.do">
					<button type="submit" name="deletefilmid" value="${film.id}">Delete
						Film</button>
				</form>


				<form action="editfilm" method="POST">
					<button type="submit" name="editfilmid" value="${film.id}">Edit
						Film</button>
				</form>
			</c:forEach>

		</c:when>

		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>
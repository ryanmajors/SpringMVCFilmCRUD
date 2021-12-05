<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Film Site</title>
</head>
<body>
	<h1>R&J Films Inc</h1>
	
	<form action="getfilmbyid.do" method="GET"> 
	Search film by FilmId:
	<input type="text" name="filmid" min="1"/>
	</form>
	
	<form action="getfilmbykeyword.do" method="GET"> 
	Search film by keyword or phrase/pattern:
	<input type="text" name="filmphrase" min="1"/>
	</form>
	<br>
	
	<form action="addfilm.do" method="POST">
	Add film to the database:
	<input type="button" name="addfilmbutton" value="Add Film">
	</form>
	<a href="addfilm">Add film</a>
	
</body>
</html>
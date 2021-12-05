<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="editfilm.do" method="POST"> 
	Create Film by filling out all fields:
	<br>Title
	<input type="text" class="data" name="title" value="${film.title}"/>
	<br>Description
	<input type="text" class="data" name="description" value="${film.description}"/>
	<br>Release Year
	<input type="number" class="data" name="releaseyear" value="${film.releaseYear}"/>
	<br>Language Id
	<input type="number" class="data" name="languageid" value="${film.languageId}"/>
	<br>Rental Duration
	<input type="number" class="data" name="rentalduration" value="${film.rentalDuration}"/>
	<br>Rental Rate
	<input type="text" class="data" name="rentalrate" value="${film.rentalRate}"/>
	<br>Length
	<input type="number" class="data" name="length" value="${film.length}"/>
	<br>Replacement Cost
	<input type="text" class="data" name="replacementcost" value="${film.replacementCost}"/>
	<br>Rating
	<input type="text" class="data" name="rating" value="${film.rating}"/>
	<br>
	<input type="hidden" name="id" value="${film.id}"/>
	<button type="submit" >Submit</button>
	</form>
	<br>
	
	
	<form action="home.do">
  
  <button type="submit">HOME PAGE</button>
  </form>

</body>
</html>
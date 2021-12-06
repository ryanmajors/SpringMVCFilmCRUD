<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="editfilm.do" method="GET"> 
	Create Film by filling out all fields:
	<br>Title
	<input type="text" class="data" name="title" required="required" value="${film.title}"/>
	<br>Description
	<input type="text" class="data" name="description" required="required" value="${film.description}"/>
	<br>Release Year
	<input type="number" class="data" name="releaseyear" required="required" value="${film.releaseYear}"/>
	<br>Language Id
	<input type="number" class="data" name="languageid"  required="required" min="1" max="6" value="${film.languageId}"/>
	<br>Rental Duration
	<input type="number" class="data" name="rentalduration" required="required" value="${film.rentalDuration}"/>
	<br>Rental Rate
	<input type="text" class="data" name="rentalrate"required="required"  value="${film.rentalRate}"/>
	<br>Length
	<input type="number" class="data" name="length" required="required" value="${film.length}"/>
	<br>Replacement Cost
	<input type="text" class="data" name="replacementcost" required="required" value="${film.replacementCost}"/>
	<br>Rating
	<input type="text" class="data" name="rating" required="required" value="${film.rating}"/>
	<br>Category
	<input type="number" class="data" name="category" required="required" min="1" max="16" value="${film.category.id}"/>
	<br>
	<input type="hidden" class="data" name="id" required="required" value="${film.id}"/>
	<button type="submit" >Submit</button>
	</form>
	<br>
	
	
	<form action="home.do">
  
  <button type="submit">HOME PAGE</button>
  </form>

</body>
</html>
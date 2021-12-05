<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="addnewfilm.do" method="GET"> 
	Fill out the form to edit the following film attributes:
	<br>Title
	<input type="text" class="data" name="title" required="required"/>
	<br>Description
	<input type="text" class="data" name="description" required="required"/>
	<br>Release Year
	<input type="number" class="data" name="releaseyear"required="required"/>
	<br>Language Id
	<input type="number" class="data" name="languageid" min="1" max="6" required="required"/>
	<br>Rental Duration
	<input type="number" class="data" name="rentalduration" required="required"/>
	<br>Rental Rate
	<input type="text" class="data" name="rentalrate" required="required"/>
	<br>Length
	<input type="number" class="data" name="length" required="required"/>
	<br>Replacement Cost
	<input type="text" class="data" name="replacementcost" required="required"/>
	<br>Rating
	<input type="text" class="data" name="rating" required="required"/>
	<br>Category
	<input type=number class="data" name="category" min="1" max="16" required="required"/>
	<br>
	<button type="submit" >Submit</button>
	</form>
	<br>
	
	
	<form action="home.do">
  
  <button type="submit">HOME PAGE</button>
  </form>
</body>
</html>
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
	<input type="text" class="data" name="title"/>
	<br>Description
	<input type="text" class="data" name="description"/>
	<br>Release Year
	<input type="number" class="data" name="releaseyear"/>
	<br>Language Id
	<input type="text" class="data" name="languageid"/>
	<br>Rental Duration
	<input type="number" class="data" name="rentalduration"/>
	<br>Rental Rate
	<input type="text" class="data" name="rentalrate"/>
	<br>Length
	<input type="number" class="data" name="length"/>
	<br>Replacement Cost
	<input type="text" class="data" name="replacementcost"/>
	<br>Rating
	<input type="text" class="data" name="rating"/>
	<br>
	<button type="submit" >Submit</button>
	</form>
	<br>
	
	
	<form action="home.do">
  
  <button type="submit">HOME PAGE</button>
  </form>
</body>
</html>
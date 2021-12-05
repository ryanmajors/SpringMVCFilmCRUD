<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film</title>
</head>
<body>
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
        <li>${film.actors}</li>
      </ul>
      <form action="deletefilm.do">
  <button type="submit" name="deletefilmid" value="${film.id}">Delete Film</button>
  </form>
  
  
  <form action="editfilm" method="POST">
  <button type="submit" name="editfilmid" value="${film.id}">Edit Film</button>
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
        <li>${film.actors}</li>
      </ul>
      <form action="deletefilm.do">
  <button type="submit" name="deletefilmid" value="${film.id}">Delete Film</button>
  </form>
  
  
  <form action="editfilm" method="POST">
  <button type="submit" name="editfilmid" value="${film.id}">Edit Film</button>
  </form>
      </c:forEach>
      
    </c:when> 
    
    <c:otherwise>
      <p>No film found</p>
    </c:otherwise>
  </c:choose>
  
  
  
  <form action="home.do">
  <br>
  <button type="submit">HOME PAGE</button>
  </form>
  
</body>
</html>
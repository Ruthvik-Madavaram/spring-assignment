<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <title>Add Customer</title>
</head>
<body>
    <h2>AMAZON PRIME</h2>
  <h3>Add movie</h3>
  <form:form action="save" modelAttribute="movie" method="POST">
    <form:hidden path="id" />
    <div class="form-group">
        <label>Movie name:</label>
        <form:input path="movieName" />
    </div>
    <div class="form-group">
        <label>Movie Genre:</label>
        <form:input path="movieGenre" />
    </div>
    <div class="form-group">
        <label>Movie Link:</label>
        <form:input path="movieLink" />
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>
  <p>
    <a href="${pageContext.request.contextPath}/movies" class="btn btn-info">Back to List</a>
  </p>
</body>
</html>
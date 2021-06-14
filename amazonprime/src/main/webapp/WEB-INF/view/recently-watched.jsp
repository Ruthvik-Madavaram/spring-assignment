<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "security" uri = "http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Recently Watched</title>
</head>
<body>
<div class="container">
<table class="table table-bordered table-striped">
   <thead class="thead-dark">
    <tr>
        <th scope="col">Movie Name</th>
        <th scope="col">Movie Genre</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tempMovie" items="${movies}">
    <c:url var="removeLink" value="/deleteFromRecentlyWatched">
        <c:param name="movieId" value="${tempMovie.id}" />
    </c:url>
    <c:url var="watchLink" value="/watch">
        <c:param name="movieId" value="${tempMovie.id}" />
    </c:url>
        <tr>
            <td> ${tempMovie.movieName} </td>
            <td> ${tempMovie.movieGenre} </td>
            <td><input type="button" value="Remove" class="btn btn-danger btn-sm" onclick="window.location.href='${removeLink}'"/> |
             <input type="button" value="Watch Again" class="btn btn-primary btn-sm" onclick="window.location.href='${watchLink}'"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<p>
    <a href="${pageContext.request.contextPath}/movies" class="btn btn-info">Back to List</a>
  </p>
</body>
</html>
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
  <title>List Customers</title>
</head>
<body>
<div class="container">
    <h2>AMAZON PRIME</h2>
    <security:authorize access = "hasRole('ADMIN')">
    <input type="button" value="Add Movie" class="btn btn-primary btn-sm mb-3"
    				   onclick="window.location.href='add'; return false;"/>
    </security:authorize>
    <table class="table table-bordered table-striped">
     <thead class="thead-dark">
      <tr>
        <th scope="col">Movie Name</th>
        <th scope="col">Movie Genre</th>
        <security:authorize access = "hasRole('ADMIN')"><th scope="col">Action</th></security:authorize>
        <security:authorize access = "hasRole('CUSTOMER')"><th scope="col">Watch Movie</th></security:authorize>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="tempMovie" items="${movies}">
        <c:url var="updateLink" value="/update">
        						<c:param name="movieId" value="${tempMovie.id}" />
        					</c:url>
        <c:url var="watchLink" value="/watch">
                						<c:param name="movieId" value="${tempMovie.id}" />
                		</c:url>
        <c:url var="deleteLink" value="/delete">
        						<c:param name="movieId" value="${tempMovie.id}" />
        					</c:url>
        <tr>
          <td> ${tempMovie.movieName} </td>
          <td> ${tempMovie.movieGenre} </td>
          <security:authorize access = "hasRole('CUSTOMER')"><td><input type="button" value="Watch" class="btn btn-success btn-sm" onclick="window.location.href='${watchLink}'"/> </td></security:authorize>
          <security:authorize access = "hasRole('ADMIN')"><td><input type="button" value="Update" class="btn btn-primary btn-sm" onclick="window.location.href='${updateLink}'"/> |
          <input type="button" value="Delete" class="btn btn-danger btn-sm" onclick="if (!(confirm('Are you sure you want to delete this movie?'))) return false;window.location.href='${deleteLink}'"/></td></security:authorize>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <security:authorize access = "isAuthenticated()">
    <form:form action = "${pageContext.request.contextPath }/logout" method = "POST">
    			<input type = "submit" value = "Logout" class="btn btn-danger btn-sm mb-3"/>
    		</form:form>
    </security:authorize>
    <security:authorize access = "!isAuthenticated()">
    <a href="${pageContext.request.contextPath}/login" class="btn btn-success btn-sm mb-3">login</a>
    </security:authorize>
</div>
</body>
</html>
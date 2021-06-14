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
    <title>MOVIE</title>
</head>
<body>
     <c:url var="recentlyWatchedLink" value="/recentlyWatched"></c:url>
     <input type="button" value="Recently Watched" class="btn btn-primary" onclick="window.location.href='${recentlyWatchedLink}'"/>
    <br><br>
  <h1> Enjoy Watching: ${movie.movieName}</h1>
  <br>
  ${movie.movieLink}

</body>
</html>
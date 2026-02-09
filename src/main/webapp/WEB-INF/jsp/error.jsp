<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="${pageContext.request.contextPath}/">
    <title>Error</title>
</head>
<body>
<nav>
    <a href="home">Home</a> |
    <a href="create-task">Add new Task</a> |
    <a href="tasks-list">Show all Tasks</a>
</nav>

<h2>${requestScope['jakarta.servlet.error.message']}</h2>
<p>url: ${requestScope['jakarta.servlet.error.request_uri']}</p>

</body>
</html>

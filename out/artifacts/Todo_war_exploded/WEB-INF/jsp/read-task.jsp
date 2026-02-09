<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <base href="${pageContext.request.contextPath}/">
  <link rel="stylesheet" href="css/tasks-list.css" type="text/css">
  <title>Read Task</title>
</head>
<body>
<nav>
  <a href="home">Home</a> |
  <a href="create-task">Add new Task</a> |
  <a href="tasks-list">Show all Tasks</a>
</nav>

<h2>Task details</h2>

<p>Id: ${task.id}</p>
<p>Name: ${task.name}</p>
<p>Priority: ${task.priority}</p>

</body>
</html>

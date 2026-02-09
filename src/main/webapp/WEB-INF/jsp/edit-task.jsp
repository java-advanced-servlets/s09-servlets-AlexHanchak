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
    <title>Edit Task</title>
</head>
<body>
<nav>
    <a href="home">Home</a> |
    <a href="create-task">Add new Task</a> |
    <a href="tasks-list">Show all Tasks</a>
</nav>
<form action="${pageContext.request.contextPath}/edit-task" method="post">
    <label for="id">Id:</label><br>
    <input type="text" id="id" name="id" value="${task.id}" readonly><br>

    <label for="text">Name:</label><br>
    <input type="text" id="text" name="text" value="${task.name}"><br>

    <label for="prio">Priority:</label><br>
    <select id="prio" name="prio">
        <option value="${task.priority}">${task.priority}</option>
        <option value="LOW">Low</option>
        <option value="MEDIUM">Medium</option>
        <option value="HIGH">High</option>
    </select><br><br>

    <input type="submit" value="Edit Task">
</form>
</body>
</html>

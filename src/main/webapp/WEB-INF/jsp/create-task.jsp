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
    <title>Document</title>
</head>
<body>
<nav>
    <a href="home">Home</a> |
    <a href="create-task">Add new Task</a> |
    <a href="tasks-list">Show all Tasks</a>
</nav>

<c:if test="${param.error == 'duplicate'}">
    <p>Task with this name already exists.</p>
</c:if>

<form action="create-task" method="POST">
    <label for="text">First name:</label><br>
    <input type="text" id="text" name="text"><br>
    <label for="prio">Priority:</label><br>
    <select id="prio" name="prio">
        <option value="LOW">Low</option>
        <option value="MEDIUM">Medium</option>
        <option value="HIGH">High</option>
    </select><br><br>
    <input type="submit" value="Create" class="link-button">
    <input type="reset" value="Clear" class="link-button">
</form>
</body>
</html>

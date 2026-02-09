<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="css/tasks-list.css" type="text/css">
    <title>Tasks List</title>
</head>
<body>
<h1>To-Do List</h1>
<nav>
    <a href="home">Home</a> |
    <a href="create-task">Add new Task</a> |
    <a href="tasks-list">Show all Tasks</a>
</nav>
<table border="1">
    <tr><th>No.</th><th>Name</th><th>Priority</th><th colspan="3">Operations</th></tr>
    <c:forEach var="task" items="${tasks}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${task.name}</td>
            <td>${task.priority}</td>

            <td><a href="read-task?id=${task.id}" class="link-button">Read</a></td>
            <td><a href="edit-task?id=${task.id}" class="link-button">Edit</a></td>
            <td>
                <form method="post" action="delete-task?id=${task.id}">
                    <input type="submit" value="Delete" class="link-button">
                </form>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>

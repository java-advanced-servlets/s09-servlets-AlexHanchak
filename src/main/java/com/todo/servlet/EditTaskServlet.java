package com.todo.servlet;

import com.todo.model.Priority;
import com.todo.model.Task;
import com.todo.repository.TaskRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit-task")
public class EditTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Task id is missing.");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            Task task = TaskRepository.getInstance().get(id);
            if (task == null) {
                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND,
                        "Task with ID '" + id + "' not found in To-Do List!"
                );
                return;
            }
            request.setAttribute("task", task);
            request.getRequestDispatcher("/WEB-INF/jsp/edit-task.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Task id must be a number.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String text = request.getParameter("text");
        String prio = request.getParameter("prio");

        if (idParam == null || idParam.trim().isEmpty()
                || text == null || text.trim().isEmpty()
                || prio == null || prio.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing form data.");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            if (TaskRepository.getInstance().get(id) == null) {
                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND,
                        "Task with ID '" + id + "' not found in To-Do List!"
                );
                return;
            }
            Task task = new Task();
            task.setId(id);
            task.setName(text.trim());
            task.setPriority(Priority.valueOf(prio));
            TaskRepository.getInstance().update(task);
            response.sendRedirect(request.getContextPath() + "/tasks-list");
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid task data.");
        }
    }
}

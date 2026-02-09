package com.todo.servlet;

import com.todo.model.Task;
import com.todo.repository.TaskRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/read-task")
public class ReadTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Task id is missing.");
            request.setAttribute("fromUrl", "/read-task");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
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
            request.getRequestDispatcher("/WEB-INF/jsp/read-task.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Task id must be a number.");
        }
    }
}

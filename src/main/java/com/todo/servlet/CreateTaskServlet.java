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

@WebServlet("/create-task")
public class CreateTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String prio = req.getParameter("prio");

        if (text == null || text.trim().isEmpty() || prio == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else  {
            try {
                Task task = new Task();
                task.setName(text);
                task.setPriority(Priority.valueOf(prio));
                boolean added = TaskRepository.getInstance().add(task);
                if (added) {
                    resp.sendRedirect(req.getContextPath() + "/tasks-list");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/create-task?error=duplicate");
                }
            }  catch (IllegalArgumentException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/create-task.jsp").forward(request, response);
    }
}

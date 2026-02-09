package com.todo.servlet;

import com.todo.repository.TaskRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tasks-list")
public class TaskListServlet extends HttpServlet {

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("tasks", TaskRepository.getInstance().getAll());
        request.getRequestDispatcher("/WEB-INF/jsp/tasks-list.jsp").forward(request, response);
    }
}

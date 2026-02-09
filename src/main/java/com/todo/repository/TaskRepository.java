package com.todo.repository;

import com.todo.model.Task;
import java.util.*;

public class TaskRepository {
    private static TaskRepository instance;
    private Map<Integer, Task> tasks = new HashMap<>();
    private int nextId = 1;

    private TaskRepository() {}

    public static synchronized TaskRepository getInstance() {
        if (instance == null) instance = new TaskRepository();
        return instance;
    }

    public synchronized boolean add(Task task) {
        for (Task t : tasks.values()) {
            if (t.getName().equalsIgnoreCase(task.getName())) return false;
        }
        task.setId(nextId++);
        tasks.put(task.getId(), task);
        return true;
    }

    public Collection<Task> getAll() {
        return tasks.values();
    }

    public Task get(int id) {
        return tasks.get(id);
    }

    public void update(Task task) {
        tasks.put(task.getId(), task);
    }

    public void delete(int id) {
        tasks.remove(id);
    }
}

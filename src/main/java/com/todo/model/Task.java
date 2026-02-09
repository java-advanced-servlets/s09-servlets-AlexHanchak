package com.todo.model;

public class Task {
    private int id;
    private String name;
    private Priority priority;


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
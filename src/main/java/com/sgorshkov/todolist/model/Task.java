package com.sgorshkov.todolist.model;

public class Task {
    private static int nextId;

    private final int id;
    private String title;
    private String description;
    private boolean isCompleted;

    public Task(String title, String description) {
        this.id = ++nextId;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        String checkBox = isCompleted ? "[+]" : "[-]";
        return String.format("id:%d %s %s - %s", id, checkBox, title, description);
    }
}

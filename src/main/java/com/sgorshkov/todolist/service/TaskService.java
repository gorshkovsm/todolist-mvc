package com.sgorshkov.todolist.service;

import com.sgorshkov.todolist.model.Task;
import com.sgorshkov.todolist.repository.TaskRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String title, String description) {
        Task task = new Task(title, description);
        taskRepository.save(task);
    }

    public void removeTask(int taskId) {
        if (taskRepository.findById(taskId).isEmpty()) {
            throw new NoSuchElementException("Задача с таким id не существует");
        }
        taskRepository.delete(taskId);
    }

    public Task getTask(int taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Задача с таким id не существует"));
    }

    public void editTaskTitle(int taskId, String newTitle) {
        Task task = getTask(taskId);
        task.setTitle(newTitle);
    }

    public void editTaskDescription(int taskId, String newDescription) {
        Task task = getTask(taskId);
        task.setDescription(newDescription);
    }

    public void changeTaskStatus(int taskId) {
        Task task = getTask(taskId);
        task.setCompleted(!task.isCompleted());
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByCompletionStatus(boolean isCompleted) {
        return taskRepository.findByCompletionStatus(isCompleted);
    }
}

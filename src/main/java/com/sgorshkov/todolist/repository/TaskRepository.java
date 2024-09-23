package com.sgorshkov.todolist.repository;

import com.sgorshkov.todolist.model.Task;

import java.util.*;
import java.util.stream.Collectors;

public class TaskRepository {
    private final Map<Integer, Task> tasks = new HashMap<>();

    public Optional<Task> findById(int taskId) {
        return Optional.ofNullable(tasks.get(taskId));
    }

    public void save(Task task) {
        tasks.put(task.getId(), task);
    }

    public void delete(int taskId) {
        tasks.remove(taskId);
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public List<Task> findByCompletionStatus(boolean isCompleted) {
        return tasks.values().stream()
                .filter(task -> task.isCompleted() == isCompleted)
                .collect(Collectors.toList());
    }
}

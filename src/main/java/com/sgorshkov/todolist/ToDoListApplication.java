package com.sgorshkov.todolist;

import com.sgorshkov.todolist.controller.TaskController;
import com.sgorshkov.todolist.repository.TaskRepository;
import com.sgorshkov.todolist.service.TaskService;
import com.sgorshkov.todolist.view.TaskView;

public class ToDoListApplication {
    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();
        TaskService taskService = new TaskService(taskRepository);
        TaskView taskView = new TaskView();
        TaskController taskController = new TaskController(taskService, taskView);

        taskController.run();
    }
}

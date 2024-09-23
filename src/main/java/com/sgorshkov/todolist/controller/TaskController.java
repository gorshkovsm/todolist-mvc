package com.sgorshkov.todolist.controller;

import com.sgorshkov.todolist.model.Task;
import com.sgorshkov.todolist.service.TaskService;
import com.sgorshkov.todolist.view.TaskView;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskController {
    private final TaskService taskService;
    private final TaskView taskView;
    private final Scanner sc = new Scanner(System.in);

    public TaskController(TaskService taskService, TaskView taskView) {
        this.taskService = taskService;
        this.taskView = taskView;
    }

    public void run() {
        String command;
        do {
            taskView.printMenu();
            command = sc.nextLine();
            switch (command) {
                case "1" -> addTask();
                case "2" -> editTask();
                case "3" -> viewTask();
                case "4" -> removeTask();
                case "5" -> showTasks();
                case "6" -> showCompletedTasks();
                case "7" -> showIncompleteTasks();
                case "0" -> taskView.printExit();
                default -> taskView.printInvalidCommand();
            }
        } while (!command.equals("0"));
    }

    private void addTask() {
        taskView.promptTitle();
        String title = sc.nextLine();
        taskView.promptDescription();
        String description = sc.nextLine();
        taskService.addTask(title, description);
        taskView.printTaskAdded();
    }

    private void editTask() {
        try {
            taskView.promptTaskId();
            int taskId = Integer.parseInt(sc.nextLine());
            if (taskService.getTask(taskId) == null) {
                taskView.printTaskNotFound();
                return;
            }
            taskView.printEditMenu();
            String command = sc.nextLine();
            switch (command) {
                case "1" -> {
                    taskView.promptTitle();
                    String newTitle = sc.nextLine();
                    taskService.editTaskTitle(taskId, newTitle);
                    taskView.printTaskUpdated();
                }
                case "2" -> {
                    taskView.promptDescription();
                    String newDescription = sc.nextLine();
                    taskService.editTaskDescription(taskId, newDescription);
                    taskView.printTaskUpdated();
                }
                case "3" -> {
                    taskService.changeTaskStatus(taskId);
                    taskView.printTaskStatusUpdated();
                }
                default -> taskView.printInvalidCommand();
            }
        } catch (NumberFormatException e) {
            taskView.printInvalidId();
        }
    }

    private void viewTask() {
        try {
            taskView.promptTaskId();
            int taskId = Integer.parseInt(sc.nextLine());
            Task task = taskService.getTask(taskId);
            taskView.printTaskDetails(task);
        } catch (NumberFormatException e) {
            taskView.printInvalidId();
        } catch (NoSuchElementException e) {
            taskView.printTaskNotFound();
        }
    }

    private void removeTask() {
        try {
            taskView.promptTaskId();
            int taskId = Integer.parseInt(sc.nextLine());
            taskService.removeTask(taskId);
            taskView.printTaskRemoved();
        } catch (NumberFormatException e) {
            taskView.printInvalidId();
        } catch (NoSuchElementException e) {
            taskView.printTaskNotFound();
        }
    }

    private void showTasks() {
        taskView.printTasks(taskService.getAllTasks());
    }

    private void showCompletedTasks() {
        taskView.printTasks(taskService.getTasksByCompletionStatus(true));
    }

    private void showIncompleteTasks() {
        taskView.printTasks(taskService.getTasksByCompletionStatus(false));
    }
}

package com.sgorshkov.todolist.view;

import com.sgorshkov.todolist.model.Task;

import java.util.List;

public class TaskView {

    public void printMenu() {
        System.out.print("""
            Меню:
            1 - Добавить задачу
            2 - Редактировать задачу
            3 - Посмотреть задачу
            4 - Удалить задачу
            5 - Посмотреть все задачи
            6 - Просмотреть завершённые задачи
            7 - Просмотреть незавершённые задачи
            0 - Выход
            Выберите команду:\s""");
    }

    public void promptTitle() {
        System.out.print("Введите название задачи: ");
    }

    public void promptDescription() {
        System.out.print("Введите описание задачи: ");
    }

    public void promptTaskId() {
        System.out.print("Введите id задачи: ");
    }

    public void printTaskAdded() {
        System.out.println("Задача успешно добавлена.");
    }

    public void printTaskUpdated() {
        System.out.println("Задача успешно обновлена.");
    }

    public void printTaskRemoved() {
        System.out.println("Задача успешно удалена.");
    }

    public void printTaskStatusUpdated() {
        System.out.println("Статус задачи успешно изменён.");
    }

    public void printExit() {
        System.out.println("Выход из программы...");
    }

    public void printInvalidCommand() {
        System.out.println("Неверная команда. Попробуйте снова.");
    }

    public void printInvalidId() {
        System.out.println("Некорректный id. Введите число.");
    }

    public void printTaskNotFound() {
        System.out.println("Задача не найдена.");
    }

    public void printTaskDetails(Task task) {
        System.out.println("Детали задачи:");
        System.out.println(task);
    }

    public void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Нет задач.");
        } else {
            System.out.println("Список задач:");
            tasks.forEach(System.out::println);
        }
    }

    public void printEditMenu() {
        System.out.print("""
            Что вы хотите отредактировать?
            1 - Название задачи
            2 - Описание задачи
            3 - Статус задачи
            Выберите команду:\s""");
    }
}

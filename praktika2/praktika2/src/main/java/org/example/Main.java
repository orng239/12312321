package org.example;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "zadanie.txt";
    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Задачки");
        System.out.println("2. Добавить");
        System.out.println("3. Редактировать");
        System.out.println("4. Удалить задачу");
        System.out.println("0. Выход");
        System.out.print("Введите номер: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1:
                showTask();
                break;
            case 2:
                addTask();
                saveToFile();
                break;
            case 3:
                editTask();
                saveToFile();
                break;
            case 4:
                deleteTask();
                saveToFile();
                break;
            case 0:
                saveToFile();
                System.out.println("Вышел и сохранил");
                System.exit(0);
        }
    }

    private static void showTask() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void addTask() {
        System.out.print("Введите id задачи: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();

        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();

        tasks.add(new Task(id, title, description));
        System.out.println("Задача добавлена");
    }

    private static void editTask() {
        showTask();
        if (tasks.isEmpty()) return;
        System.out.println("номер задачк");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index > 0 && index <= tasks.size()) {
            System.out.print("Введите че то новое");
            String newText = scanner.nextLine();
            tasks.get(index - 1).setTitle(newText);
            System.out.println("изменено");

        }
    }

    private static void deleteTask() {
        showTask();
        if (tasks.isEmpty()) return;
        System.out.println("номер задачи");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Задача удалена");
        }
    }

    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                String line = task.getId() + "|" + task.getTitle() + "|" + task.getDescription();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private static void saveToFileJSON() {
        Gson gson = new Gson();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            String json = gson.toJson(tasks);
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }
}

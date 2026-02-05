package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "zadanie.txt";
    private List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }
    public static void showMenu(){
        System.out.println("\\nМеню:");
        System.out.println("1.Задачки");
        System.out.println("2.Добавить");
        System.out.println("3.Редактировать");
        System.out.println("4.Удалить задачу");
        int numbers = scanner.nextInt();
        switch (numbers){
            case 1:
                showTask();
                    break;
            case 2;
                Addtask();
                Savetask();
                break;

            case 3;
                edittask();
                Savetask();
                break;

            case 3;
                deletetask();
                savetask();
            break;



        }

    }
}

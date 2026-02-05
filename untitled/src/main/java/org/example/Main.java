package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

    }
    public static String UznatAge(int age) {
        if (age < 0 ) {
            return "Ошибка отриц число";
        }
        else if (age < 17) {
            return "ребенок";
        } else if (age < 60) {
            return "взрослый";
        } else {
            return "старик";
        }
    }
}
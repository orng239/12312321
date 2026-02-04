package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String UznatAge(int age) {
        if (age < 17) {
            return "ребенок";
        } else if (age < 55) {
            return "взрослый";
        } else {
            return "старик";
        }
    }
}
package main;

import java.util.Scanner;

import static main.Util.CheckNumbers;
import static main.RomanNumber.*;

class Calculation {
    private static boolean calculation;

    public static void StartCalculation() {
        calculation = true;

        while (calculation) {
            System.out.println("Обратите внимание, калькулятор работает с арабскими и римскими цифрами от 1 до 10 включительно." + "\nВведите цифры и арифметическую операцию через пробел, в формате '1 + 2', либо 'I + II'.");
            Scanner sc = new Scanner(System.in);
            String lineOperation = sc.nextLine();
            String[] arrOperation = lineOperation.split(" ");

            if (RomanOrArabic(arrOperation[0]) & RomanOrArabic(arrOperation[2])) {          // выполнится римский калькулятор
                System.out.println(RomanCalculate(arrOperation));
                if (RomanCalculate(arrOperation).equals("Не предусмотренная арифметическая операция!=)") || RomanCalculate(arrOperation).equals("В римских цифрах увы нет отрицательных чисел :P")) {
                    calculation = false;
                }
            } else  if (!RomanOrArabic(arrOperation[0]) & !RomanOrArabic(arrOperation[2])){ // выполнится арабский калькулятор
                ArabicCalculation(arrOperation);
            } else {                                                                        // если операнды разные, одни арабский и один римский и наоборот
                System.out.println("Не корректные данные, оба операнда должны быть либо арабскими, либо римскими цифрами!");
                calculation = false;
            }
        }
    }

    public static void ArabicCalculation(String[] arrOperation) {
        if (CheckNumbers(arrOperation)) {
            switch (arrOperation[1]) {
                case "+":
                    System.out.println(Integer.parseInt(arrOperation[0]) + Integer.parseInt(arrOperation[2]));
                    break;
                case "-":
                    System.out.println(Integer.parseInt(arrOperation[0]) - Integer.parseInt(arrOperation[2]));
                    break;
                case "*":
                    System.out.println(Integer.parseInt(arrOperation[0]) * Integer.parseInt(arrOperation[2]));
                    break;
                case "/":
                    System.out.println(Integer.parseInt(arrOperation[0]) / Integer.parseInt(arrOperation[2]));
                    break;
                default:
                    System.err.println("Не предусмотренная арифметическая операция!");
                    calculation = false;
            }
        } else {
            if (arrOperation.length == 3) { //для того чтобы оба исключения не срабатывали последовательно в методе CheckNumbers
                System.err.println("Калькулятор принимает на вход числа от 1 до 10 включительно!");
            }
            calculation = false;
        }
    }
}
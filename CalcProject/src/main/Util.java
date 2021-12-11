package main;

class Util {
    public static boolean CheckNumbers(String[] arrOperation) {
        try {
            // проверим на целые числа
            Integer.parseInt(arrOperation[0]);
            Integer.parseInt(arrOperation[2]);
        } catch (NumberFormatException e) {
            System.err.println("Калькулятор принимает на вход только целые числа!");
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {       // если пропустили пробел или что-то типо того
            System.err.println("Неверный формат ввода!");
            return false;
        }

        // поверим первое число на диапазон, если цифра меньше 1 или
        if (Integer.parseInt(arrOperation[0]) < 1 || Integer.parseInt(arrOperation[0]) > 10) {
            return false;
        }
        // проверим второе число на диапазон
        if (Integer.parseInt(arrOperation[2]) < 1 || Integer.parseInt(arrOperation[2]) > 10) {
            return false;
        }

        return true;
    }
}
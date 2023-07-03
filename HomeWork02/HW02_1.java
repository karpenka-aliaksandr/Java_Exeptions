package HomeWork02;

import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению 
// приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

public class HW02_1 {
    public static void main(String[] args) {
        System.out.println(GetFloat());//Не нравится тем, что если даже не вся строка Float то отдает значение.
        //или
        System.out.println(GetFloat2());//Не нравится как строка парсится к числу. (может возникать погрешность)
    }

    static float GetFloat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        while (!scanner.hasNextFloat()) {
            System.out.println("Неправильный ввод\nВведите дробное число(разделитель - запятая): ");
            scanner.nextLine();
        }
        float result = scanner.nextFloat();
        scanner.close();
        return result;
    }

    static float GetFloat2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        String in = scanner.nextLine();
        Float result;
        while (true) {
            try {
                result = Float.parseFloat(in);
                scanner.close();
                return result;
            } catch (Exception e) {
                System.out.println("Неправильный ввод\nВведите дробное число(разделитель - точка): ");
                in = scanner.nextLine();
            }
        }
    }
}

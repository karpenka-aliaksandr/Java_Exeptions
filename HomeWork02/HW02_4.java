package HomeWork02;
// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 

// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class HW02_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String str = GetString(scanner);
            System.out.printf("Вы ввели: %s", str);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scanner.close();
        }

    }

    static String GetString(Scanner scanner) throws Exception {
        System.out.print("Введите строку: ");
        String result = scanner.nextLine();
        if (result == "")
            throw new Exception("Пустые строки вводить нельзя");
        return result;
    }

}

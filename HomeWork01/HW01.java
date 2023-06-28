package HomeWork01;

import java.util.Arrays;
import java.util.Random;

public class HW01 {
    public static void main(String[] args) {
        Random rnd = new Random();
        
        // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
        
        //Method1();
       
        //Method2();
        
        //Method3();
        
        //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
        //и возвращающий новый массив, каждый элемент которого равен разности элементов 
        //двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.

        // int[] minuend = CreateArray(5+rnd.nextInt(2), 10, rnd);
        // int[] subtrahend = CreateArray(5+rnd.nextInt(2), 10, rnd);
        // int[] difference = Subtraction(minuend, subtrahend);
        // System.out.println(Arrays.toString(difference));

        // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
        // и возвращающий новый массив, каждый элемент которого равен частному элементов 
        // двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо 
        // как-то оповестить пользователя. 
        // Важно: При выполнении метода единственное исключение, которое пользователь 
        // может увидеть - RuntimeException, т.е. ваше.

        for (int i = 0; i < 5; i++) {
            System.out.printf("Итерация %d\n", i+1);
            int[] dividend = CreateArray(10+(rnd.nextInt(10) / 9), 10, rnd);
            int[] divisor = CreateArray(10+(rnd.nextInt(10) / 9), 10, rnd);
            System.out.println(Arrays.toString(dividend));
            System.out.println(Arrays.toString(divisor));
            Float[] quotient = Division(dividend, divisor);
            System.out.println(Arrays.toString(quotient)); 
            System.out.println();
        }
        
    }




    // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения        
    public static void Method1() {
        double i = 10;
        i = i / 0;    
    }
    public static void Method2() {
        int[] arr = new int[]{0,1,2,3,4};
        int i = arr[5];    
    }
    public static void Method3() {
        int i = Integer.parseInt("2 / 25");    
    }
    
    //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
    //и возвращающий новый массив, каждый элемент которого равен разности элементов 
    //двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
    public static int[] CreateArray(int length, int bound, Random rnd){
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(bound);            
        }
        return array;
    }

    public static int[] Subtraction(int[] minuend, int[] subtrahend) {
        int[] difference = new int[minuend.length];
        if (minuend.length == subtrahend.length) {
            for (int i = 0; i < difference.length; i++) {
                difference[i] = minuend[i] - subtrahend[i];               
            }
        } else {
            throw new RuntimeException("Массивы разной длины");
        }
        return difference;
    }

    // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
    // и возвращающий новый массив, каждый элемент которого равен частному элементов 
    // двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо 
    // как-то оповестить пользователя. 
    // Важно: При выполнении метода единственное исключение, которое пользователь 
    // может увидеть - RuntimeException, т.е. ваше.
    
    public static Float[] Division(int[] dividend, int[] divisor) {
        Float[] quotient = new Float[dividend.length];
        if (dividend.length == divisor.length) {
            for (int i = 0; i < quotient.length; i++) {
                if (divisor[i] != 0) {
                    quotient[i] = (float) dividend[i] / divisor[i];
                } else quotient[i] = null;
            }
        } else {
            throw new RuntimeException("Массивы разной длины");
        }
        return quotient;
    }


}


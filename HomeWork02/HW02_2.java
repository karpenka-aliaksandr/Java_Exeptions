package HomeWork02;

public class HW02_2 {
    // Если необходимо, исправьте данный код

    public static void main(String[] args) {

        int[] intArray = new int[] { 1, 2, 3,4,6,7,6,5,6,5,6 }; //создал и проинициализировал массив
        
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (IndexOutOfBoundsException e) {// добавил обработку выхода за пределы массива
            System.out.println("Catching exception: " + e);
        }
    }
}

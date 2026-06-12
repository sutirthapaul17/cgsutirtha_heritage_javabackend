// Type Casting Demo
// Create an integer variable and convert it into a double using implicit casting. Then convert a double into an int using explicit casting.


public class q4 {
    public static void main(String[] args) {

        // Implicit
        int num = 25;
        double doubleNum = num;

        System.out.println("Integer value: " + num);
        System.out.println("After implicit casting to double: " + doubleNum);

        // Explicit
        double price = 99.99;
        int intPrice = (int) price;

        System.out.println("Double value: " + price);
        System.out.println("After explicit casting to int: " + intPrice);
    }
}
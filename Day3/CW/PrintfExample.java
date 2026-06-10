package CW;

public class PrintfExample {
    public static void main(String[] args) {

        String name = "Alice";
        int age = 25;
        double price = 99.5;
        char grade = 'A';
        boolean passed = true;

        System.out.printf("Name: %s%n", name);
        System.out.printf("Age: %d%n", age);
        System.out.printf("Price: %.2f%n", price);
        System.out.printf("Grade: %c%n", grade);
        System.out.printf("Passed: %b%n", passed);
    }
}

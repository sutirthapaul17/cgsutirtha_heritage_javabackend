// Arithmetic Calculator
// Take two numbers as input and display:
// •	Sum
// •	Difference
// •	Product
// •	Quotient
// •	Remainder

import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.println("\nResults:");
        System.out.println("Sum = " + (num1 + num2));
        System.out.println("Difference = " + (num1 - num2));
        System.out.println("Product = " + (num1 * num2));

        if (num2 != 0) {
            System.out.println("Quotient = " + (num1 / num2));
            System.out.println("Remainder = " + (num1 % num2));
        } else {
            System.out.println("Quotient = Cannot divide by zero");
            System.out.println("Remainder = Cannot divide by zero");
        }

        sc.close();
    }
}
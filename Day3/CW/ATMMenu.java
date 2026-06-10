package CW;

import java.util.Scanner;

public class ATMMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 10000.00;

        System.out.println("=== ATM MENU ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> System.out.printf("Balance: Rs. %.2f%n", balance);
            case 2 -> {
                System.out.print("Amount to deposit: ");
                balance += sc.nextDouble();
                System.out.printf("New balance: Rs. %.2f%n", balance);
            }
            case 3 -> {
                System.out.print("Amount to withdraw: ");
                double amt = sc.nextDouble();
                if (amt <= balance) { balance -= amt; System.out.printf("Dispensed: Rs. %.2f%n", amt); }
                else System.out.println("Insufficient funds!");
            }
            case 4 -> System.out.println("Thank you. Goodbye!");
            default -> System.out.println("Invalid option.");
        }
        sc.close();
    }
}


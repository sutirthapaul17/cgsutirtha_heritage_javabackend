
import java.util.ArrayList;
import java.util.Scanner;

class ATMAccount {
    private int pin;
    private double balance;
    private ArrayList<String> transactions;

    public ATMAccount(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited $" + amount);
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance!");
            return;
        }

        balance -= amount;
        transactions.add("Withdrawn $" + amount);
        System.out.println("Please collect your cash.");
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void miniStatement() {
        System.out.println("\n===== MINI STATEMENT =====");

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }

        System.out.println("Current Balance: $" + balance);
    }
}

public class AtmMachineSimulator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATMAccount account = new ATMAccount(1234, 10000);

        System.out.print("Enter ATM PIN: ");
        int enteredPin = sc.nextInt();

        if (!account.validatePin(enteredPin)) {
            System.out.println("Invalid PIN!");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.miniStatement();
                    break;

                case 5:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
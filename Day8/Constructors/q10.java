// Create a BankAccount class with overloaded constructors: 
// Account Number only 
// Account Number + Balance 

package Constructors;

class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0; // Default balance
    }
    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println();
    }
}

public class q10 {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(1001);
        BankAccount acc2 = new BankAccount(1002, 5000.50);

        acc1.display();
        acc2.display();
    }
}
package Encapsulation;

 
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class q22 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(5000);
        account.withdraw(2000);
        System.out.println("Current Balance: ₹" + account.getBalance());
    }
}
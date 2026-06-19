//2. Banking Application
//Create:
//Account class
//SavingsAccount
//CurrentAccount
//        Use:
//inheritance
//method overriding
//encapsulation
//Implement withdrawal rules differently.


class Account {
    private int accNumber;
    private String holderName;
    private double balance;

    Account(int accNumber, String holderName, double balance) {
        this.accNumber = accNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        System.out.println("Withdrawal method not defined.");
    }

    public void display() {
        System.out.println("Account No: " + accNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends Account {

    private static final double MIN_BALANCE = 1000;

    SavingsAccount(int accNumber, String holderName, double balance) {
        super(accNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= MIN_BALANCE) {
            setBalance(getBalance() - amount);
            System.out.println("$ " + amount + " withdrawn from Savings Account.");
        } else {
            System.out.println("Withdrawal denied! Minimum balance of $1000 must be maintained.");
        }
    }

}

class CurrentAccount extends Account {

    private static final double OVERDRAFT_LIMIT = 5000;
    CurrentAccount(int accNumber, String holderName, double balance) {
        super(accNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= -OVERDRAFT_LIMIT) {
            setBalance(getBalance() - amount);
            System.out.println("$ " + amount + " withdrawn from Current Account.");
        } else {
            System.out.println("Withdrawal denied! Overdraft limit exceeded.");
        }
    }

}

public class Q2 {
    public static void main(String[] args) {

        Account p1 = new SavingsAccount(101, "Rahul", 10000);
        Account p2 = new CurrentAccount(102, "Diya", 3000);

        System.out.println("----- Savings Account -----");
        p1.display();
        p1.withdraw(8500);
        System.out.println("Balance: $" + p1.getBalance());

        System.out.println("\n----- Current Account -----");
        p2.display();
        p2.withdraw(9000);
        System.out.println("Balance: $" + p2.getBalance());
    }
}
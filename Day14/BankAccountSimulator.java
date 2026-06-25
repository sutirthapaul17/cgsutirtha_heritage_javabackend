class BankAccount {
    protected int accountNumber;
    protected String holderName;
    protected double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited.");
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountNumber, String holderName,
                          double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;

        System.out.println("Interest Added: $" + interest);
        System.out.println("New Balance: $" + balance);
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, String holderName,
                          double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println(amount + " withdrawn.");
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}
public class BankAccountSimulator {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount(
                101, "Rahul", 10000, 5);

        BankAccount acc2 = new CurrentAccount(
                102, "Priya", 5000, 3000);

        System.out.println("=== Savings Account ===");
        acc1.deposit(2000);
        acc1.withdraw(1500);
        acc1.checkBalance();
        ((SavingsAccount) acc1).calculateInterest();
        System.out.println("\n=== Current Account ===");
        acc2.withdraw(7000);
        acc2.checkBalance();

        acc2.withdraw(3000);
        acc2.checkBalance();
    }
}
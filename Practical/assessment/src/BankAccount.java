import Exception.InsufficientFundsException;

public class BankAccount {
    private double balance;
    private final String accountHolder;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Deposited: %.2f | New Balance: %.2f%n", amount, balance);
    }

    public void deposit(double amount, String remark) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Deposited: %.2f | Remark: %s | New Balance: %.2f%n",
                amount, remark, balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Withdrawal of " + amount + " exceeds current balance of " + balance);
        }
        balance -= amount;
        System.out.printf("Withdrew: %.2f | New Balance: %.2f%n", amount, balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("abc", 5000.0);
        BankAccount acc1 = new BankAccount("dey",1000);

        System.out.println("--- Dey's account ---");
        System.out.printf("Account Holder: %s | Balance: %.2f%n",acc1.accountHolder, acc1.getBalance());
        try{
            acc1.withdraw(1500);
        }catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        System.out.println("--- abc's Account ---");
        System.out.printf("Account Holder: %s | Balance: %.2f%n",
                account.accountHolder, account.getBalance());

        System.out.println("--- Deposit ---");
        account.deposit(1500.0);

        System.out.println("\n--- Deposit ---");
        account.deposit(2000.0, "Salary credit");

        System.out.println("\n--- Successful Withdrawal ---");
        try {
            account.withdraw(3000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Failed Withdrawal (triggers custom exception) ---");
        try {
            account.withdraw(10000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        System.out.printf("%n--- Final Balance: %.2f ---%n", account.getBalance());
    }
}
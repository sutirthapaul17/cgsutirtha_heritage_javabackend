
// Step 1: Define your custom exception
class InsufficientFundsException extends Exception {
    private double amount;  // Extra context about the error

    public InsufficientFundsException(double amount) {
        super("Insufficient funds! Short by Rs." + amount);
        this.amount = amount;
    }

    public double getShortfall() {
        return amount;
    }
}



// Step 2: Use the custom exception in a class
public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Declares it may throw our custom exception
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
        System.out.println("Withdrawn Rs." + amount + " | Remaining: Rs." + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Rahul", 5000);
        try {
            acc.withdraw(3000);   // OK
            acc.withdraw(4000);   // InsufficientFundsException!
        } catch (InsufficientFundsException e) {
            System.out.println("Bank Error: " + e.getMessage());
            System.out.println("You need Rs." + e.getShortfall() + " more.");
        }

    }
}


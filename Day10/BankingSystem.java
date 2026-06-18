
// ── Abstract Class ──────────────────────────────────────

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName    = holderName;
        this.balance       = initialBalance;
    }
    // Abstract — each account type deposits differently (rules differ)
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract String getAccountType();

    // Concrete — shared across all account types
    public void printStatement() {
        System.out.println("=== Account Statement ===");
        System.out.println("Account No : " + accountNumber);
        System.out.println("Holder     : " + holderName);
        System.out.println("Type       : " + getAccountType());
        System.out.println("Balance    : Rs." + balance);
    }

    public double getBalance()       { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName()    { return holderName; }
}

// ── Interfaces ──────────────────────────────────────────
interface Transferable {
    boolean transferTo(BankAccount target, double amount);

    default void printTransferSummary(String to, double amount, boolean success) {
        System.out.println("Transfer " + (success ? "SUCCESS" : "FAILED") + " → Rs." + amount + " to " + to);
    }
}

interface Interestable {
    double calculateInterest();
    void applyInterest();
    double getInterestRate();
}

interface Loanable {
    boolean applyForLoan(double amount, int tenureMonths);
    double getLoanEligibility();
}


// ── Concrete Classes ─────────────────────────────────────
// Savings Account — can transfer + earns interest
class SavingsAccount extends BankAccount implements Transferable, Interestable {

    private static final double INTEREST_RATE = 0.04;  // 4% per annum
    public SavingsAccount(String accNo, String holder, double balance) {
        super(accNo, holder, balance);
    }

    @Override
    public String getAccountType() { return "Savings Account"; }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs." + amount + " | New balance: Rs." + balance);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= 500) {  // min balance Rs.500
            balance -= amount;
            System.out.println("Withdrawn Rs." + amount + " | Balance: Rs." + balance);
        } else {
            System.out.println("Withdrawal failed: Minimum balance Rs.500 required");
        }
    }

    @Override
    public boolean transferTo(BankAccount target, double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
            target.deposit(amount);
            printTransferSummary(target.getHolderName(), amount, true);
            return true;
        }
        printTransferSummary(target.getHolderName(), amount, false);
        return false;
    }

    @Override
    public double getInterestRate()   { return INTEREST_RATE; }
    @Override
    public double calculateInterest() { return balance * INTEREST_RATE; }
    @Override
    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("Interest applied: Rs." + interest + " | New balance: Rs." + balance);
    }
}

// Current Account — can transfer + can apply for loan
class CurrentAccount extends BankAccount implements Transferable, Loanable {

    public CurrentAccount(String accNo, String holder, double balance) {
        super(accNo, holder, balance);
    }
    @Override
    public String getAccountType() { return "Current Account"; }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Current Acct deposit: Rs." + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + 50000) {  // overdraft up to Rs.50,000
            balance -= amount;
            System.out.println("Withdrawn Rs." + amount + " | Balance: Rs." + balance);
        } else {
            System.out.println("Overdraft limit exceeded");
        }

    }

    @Override
    public boolean transferTo(BankAccount target, double amount) {
        withdraw(amount);
        target.deposit(amount);
        printTransferSummary(target.getHolderName(), amount, true);
        return true;
    }

    @Override
    public double getLoanEligibility() { return balance * 5; }

    @Override
    public boolean applyForLoan(double amount, int tenureMonths) {
        if (amount <= getLoanEligibility()) {
            System.out.println("Loan APPROVED: Rs." + amount + " for " + tenureMonths + " months");
            return true;
        }
        System.out.println("Loan REJECTED: Amount exceeds eligibility of Rs." + getLoanEligibility());
        return false;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        // Polymorphism — all stored as BankAccount
        BankAccount[] accounts = {
                new SavingsAccount("SAV001", "Ananya Sharma", 10000),
                new CurrentAccount("CUR001", "Raj Enterprises", 50000),
                new SavingsAccount("SAV002", "Priya Mehta", 25000),
        };

        // Runtime Polymorphism — correct withdraw/deposit called
        System.out.println("=== Monthly Operations ===");
        for (BankAccount acc : accounts) {
            acc.printStatement();  // polymorphic call
            acc.deposit(1000);
            System.out.println();
        }
        // instanceof + Casting — apply interest only to savings
        System.out.println("=== Applying Monthly Interest ===");
        for (BankAccount acc : accounts) {
            if (acc instanceof Interestable ia) {  // pattern matching
                System.out.println(acc.getHolderName() + ":");
                ia.applyInterest();
            }
        }

        // instanceof + Casting — process transfers
        System.out.println("\n=== Transfer Operations ===");
        BankAccount ananya = accounts[0];
        BankAccount raj    = accounts[1];
        if (ananya instanceof Transferable t) {
            t.transferTo(raj, 3000);
        }

        // instanceof + Casting — loan applications for current accounts
        System.out.println("\n=== Loan Applications ===");
        for (BankAccount acc : accounts) {
            if (acc instanceof Loanable loan) {
                System.out.println(acc.getHolderName() + " applying for loan...");
                loan.applyForLoan(200000, 24);
            }
        }
    }
}

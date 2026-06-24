package Synchronization;


class BankAccount {
    private int balance = 1000;

    // ❌ NOT thread-safe — race condition!
    public void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName()
                    + " | Withdrawing: " + amount + " | Balance before: " + balance);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " | Balance after withdrawal: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " | Insufficient funds!");
        }
    }

    public int getBalance() { return balance; }
}

// Main.java
public class RaceCondition {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        Thread atm1 = new Thread(() -> account.withdraw(800), "ATM-1");
        Thread atm2 = new Thread(() -> account.withdraw(800), "ATM-2");
        atm1.start();
        atm2.start();
// ❌ Result: Both threads see balance=1000, both withdraw 800, final balance = -600!
    }
}

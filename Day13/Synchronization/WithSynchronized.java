package Synchronization;



class BankAccount1 {
    private int balance = 1000;

    // ✅ synchronized ensures only ONE thread executes this at a time
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName()
                    + " | Withdrawing: " + amount + " | Balance before: " + balance);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " | Balance after: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " | Insufficient funds!");
        }
    }
}

public class WithSynchronized {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        Thread atm1 = new Thread(() -> account.withdraw(800), "ATM-1");
        Thread atm2 = new Thread(() -> account.withdraw(800), "ATM-2");
        atm1.start();
        atm2.start();
// ❌ Result: Both threads see balance=1000, both withdraw 800, final balance = -600!
    }
}

// Output (correct):
// ATM-1 | Withdrawing: 800 | Balance before: 1000
// ATM-1 | Balance after: 200
// ATM-2 | Insufficient funds!

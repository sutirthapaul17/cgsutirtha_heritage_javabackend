package Threads;


// PaymentProcessor.java
class PaymentProcessor extends Thread {
    private String orderId;
    private double amount;

    public PaymentProcessor(String orderId, double amount) {
        this.orderId = orderId;
        this.amount  = amount;
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] Processing payment for order: " + orderId);
        try {
            Thread.sleep(2000); // Simulates API call delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[" + getName() + "] Payment of $" + amount + " completed for order: " + orderId);
    }
}

// Main.java
public class UsingExtends {
    public static void main(String[] args) {
        PaymentProcessor t1 = new PaymentProcessor("ORD-001", 150.00);
        PaymentProcessor t2 = new PaymentProcessor("ORD-002", 320.50);

        t1.setName("PaymentThread-1");
        t2.setName("PaymentThread-2");

        t1.start(); // ✅ Calls run() in a NEW thread
        t2.start(); // ✅ Runs concurrently

        // ❌ t1.run()  <-- WRONG: runs in main thread, not concurrently
    }
}

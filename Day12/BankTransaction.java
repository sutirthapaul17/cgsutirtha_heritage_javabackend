public class BankTransaction {
    public static void processPayment(double amount) {
        System.out.println("Opening DB connection...");
        try {
            if (amount <= 0) throw new IllegalArgumentException("Invalid amount");
            System.out.println("Payment of Rs." + amount + " processed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // ALWAYS runs — even if exception occurred
            System.out.println("Closing DB connection...");
        }
    }

    public static void main(String[] args) {
        processPayment(500.0);   // Normal case
        processPayment(-100.0);  // Exception case
    }
}


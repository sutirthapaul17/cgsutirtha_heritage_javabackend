// Abstract class — cannot instantiate Payment directly 

abstract class Payment {

    private String transactionId;
    private double amount;
    // Constructor
    public Payment(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }
    // Abstract method — every payment type MUST implement this
    public abstract void processPayment(); 

    // Abstract method — validation differs per type
    public abstract boolean validatePayment(); 

    // Concrete method — shared by ALL payment types
    public void logTransaction() {
        System.out.println("[LOG] Transaction ID: " + transactionId + " | Amount: Rs." + amount);
    } 

    // Concrete method — shared behaviour
    public void generateReceipt() {
        System.out.println("Receipt generated for transaction: " + transactionId);
    } 

    // Getters
    public double getAmount(){ return amount; }
    public String getTransactionId() { return transactionId; }
} 

// Concrete subclass 1 — Credit Card Payment
class CreditCardPayment extends Payment {
    private String cardNumber;
    private int cvv;
    public CreditCardPayment(String txnId, double amount,String cardNumber, int cvv) {

        super(txnId, amount);// calls abstract class constructor
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card payment of Rs." + getAmount());
        System.out.println("Card ending: " + cardNumber.substring(cardNumber.length()-4));
    }

    @Override
    public boolean validatePayment() {
        return cardNumber.length() == 16 && cvv > 99 && cvv < 1000;
    }
}

// Concrete subclass 2 — UPI Payment
class UPIPayment extends Payment {

    private String upiId;
    public UPIPayment(String txnId, double amount, String upiId) {
        super(txnId, amount);
        this.upiId = upiId;
    } 

    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment of Rs." + getAmount());
        System.out.println("UPI ID: " + upiId);
    } 

    @Override
    public boolean validatePayment() {
        return upiId != null && upiId.contains("@");
    }
}
// Main class — using the payment system
public class PaymentDemo { 
    public static void main(String[] args) {

        // Payment p = new Payment(...);  ❌ ERROR — cannot instantiate abstract class
        Payment cc = new CreditCardPayment("TXN001", 5000.00, "1234567890123456", 123);
        Payment upi = new UPIPayment("TXN002", 1200.00, "user@paytm"); 

        // Process Credit Card
        if (cc.validatePayment()) {
            cc.processPayment();   // Calls CreditCardPayment's version
            cc.logTransaction();   // Shared concrete method
            cc.generateReceipt();  // Shared concrete method
        }
        System.out.println("-----"); 

        // Process UPI
        if (upi.validatePayment()) {
            upi.processPayment();  // Calls UPIPayment's version
            upi.logTransaction();
        }
    }
} 

 

/* Output:
   Processing Credit Card payment of Rs.5000.0
   Card ending: 3456
   [LOG] Transaction ID: TXN001 | Amount: Rs.5000.0
   Receipt generated for transaction: TXN001
   -----
   Processing UPI payment of Rs.1200.0
   UPI ID: user@paytm
   [LOG] Transaction ID: TXN002 | Amount: Rs.1200.0
*/
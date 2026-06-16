
class Payment { 

    final String CURRENCY = "INR";  // final variable 

    final void generateReceipt(double amount) { 
        System.out.println("=== RECEIPT ==="); 
        System.out.println("Amount : " + CURRENCY + " " + amount); 
        System.out.println("Status : SUCCESS"); 
        System.out.println("=================");
    } 
    void processPayment(double amount) { 
        System.out.println("Processing payment of " + amount); 
    } 
} 

class UPIPayment extends Payment { 

    String upiId; 
    UPIPayment(String upiId) { 
        this.upiId = upiId; 
    } 
    @Override 
    void processPayment(double amount) {   // Allowed! 
        System.out.println("UPI Payment of " + CURRENCY + " " + amount); 
        System.out.println("UPI ID: " + upiId); 
    } 
    // generateReceipt cannot be overridden — it's final! 
} 

public class FinalAndInheritance {
    public static void main(String[] args) { 
        UPIPayment upi = new UPIPayment("raj@upi"); 
        upi.processPayment(1500.00); 
        upi.generateReceipt(1500.00);  // Uses parent's final method 
    } 
}

package finalKeyword;

// Real-Life: Physics/Math Constants 
class MathConstants { 
    final double PI = 3.14159265358979; 
    final double E  = 2.71828182845904; 
} 

 
// Real-Life: Bank Configuration 
class BankConfig { 

    final int MAX_WITHDRAWAL_LIMIT = 50000;
    final String BANK_NAME = "State Bank"; 
    final double GST_RATE = 0.18; 

    void processWithdrawal(int amount) { 

        if (amount > MAX_WITHDRAWAL_LIMIT) { 
            System.out.println("Error: Exceeds limit of " + MAX_WITHDRAWAL_LIMIT); 
        } else { 
            System.out.println("Withdrawing: Rs. " + amount); 
        } 
        // MAX_WITHDRAWAL_LIMIT = 100000;  // COMPILE ERROR! 

    } 

} 

// Static final = Class-level constant (Convention: ALL_CAPS)
class PhysicsConstants { 
    static final double SPEED_OF_LIGHT = 3.0e8; 
    static final double GRAVITY = 9.8; 
    static final double PLANCK = 6.626e-34; 
}  

// Usage: 
// System.out.println(PhysicsConstants.SPEED_OF_LIGHT); 
// Final with objects — reference is fixed, object state can change! 
class Container { 
    int value; 
} 

class Demo { 

    public static void main(String[] args) { 

        final Container box = new Container(); 
        box.value = 10;     // OK — modifying object state 
        box.value = 20;     // OK — still modifying state 
        // box = new Container();  // ERROR — cannot reassign reference! 

    } 

} 
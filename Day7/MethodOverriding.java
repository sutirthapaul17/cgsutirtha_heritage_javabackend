class Vehicle { 
    void start() { 
        System.out.println("Vehicle: Engine starting..."); 
    } 
} 
class Car extends Vehicle { 
    @Override 
    void start() { 
        super.start();   // First do what parent does 
        System.out.println("Car: Pressing ignition button..."); 
        System.out.println("Car: Ready to drive!"); 
    }
} 
public class MethodOverriding { 
    public static void main(String[] args) { 
        Car c = new Car(); 
        c.start(); 
    }
}
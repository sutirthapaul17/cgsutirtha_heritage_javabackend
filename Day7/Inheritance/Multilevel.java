package Inheritance;

// Multilevel Inheritance: Vehicle → Car → ElectricCar 
class Vehicle { 

    String brand; 
    Vehicle(String brand) { 
        this.brand = brand; 
        System.out.println("Vehicle: " + brand); 
    } 

    void fuel() {
        System.out.println(brand + " runs on fuel."); 
    } 

} 

class Car extends Vehicle { 

    int doors; 
    Car(String brand, int doors) { 
        super(brand); 
        this.doors = doors; 
        System.out.println("Car with " + doors + " doors."); 
    } 
    void drive() { 
        System.out.println(brand + " car is driving."); 
    } 
} 

class ElectricCar extends Car { 

    int batteryCapacity;  // in kWh 
    ElectricCar(String brand, int doors, int battery) { 
        super(brand, doors); 
        this.batteryCapacity = battery; 
        System.out.println("ElectricCar battery: " + battery + " kWh"); 
    } 

    @Override 
    void fuel() { 
        System.out.println(brand + " runs on electricity!"); 
    } 

    void charge() { 
        System.out.println(brand + " is charging its " + batteryCapacity + " kWh battery."); 
    } 
} 

public class Multilevel{ 
    public static void main(String[] args) { 
        ElectricCar tesla = new ElectricCar("Tesla", 4, 100); 
        tesla.fuel();    // Overridden in ElectricCar 
        tesla.drive();   // Inherited from Car 
        tesla.charge();  // ElectricCar's own method 
    }
}

 

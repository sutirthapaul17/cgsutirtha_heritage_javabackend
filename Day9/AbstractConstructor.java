
abstract class Vehicle {

    protected String brand;
    protected int year;

    // Abstract class constructor
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
        System.out.println("Vehicle created: " + brand);
    }
    public abstract void startEngine();
}
class Car extends Vehicle {

    private int doors;
    public Car(String brand, int year, int doors) {
        super(brand, year);  // MUST call abstract class constructor first
        this.doors = doors;
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " car engine started! Doors: " + doors);
    }
}
public class AbstractConstructor {
}

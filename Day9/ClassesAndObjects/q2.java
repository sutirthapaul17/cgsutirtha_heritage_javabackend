// Create a Car class with: 
// brand 
// model 
// price 
// Create 3 objects and print their details


package ClassesAndObjects;

class Car {
    String brand;
    String model;
    double price;

    Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: ₹" + price);
        System.out.println();
    }
}

public class q2 {
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", "Fortuner", 3500000);
        Car car2 = new Car("Hyundai", "Creta", 1800000);
        Car car3 = new Car("Tata", "Nexon", 1500000);

        car1.display();
        car2.display();
        car3.display();
    }
}
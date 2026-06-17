// Create a Laptop class and instantiate multiple objects using different values. 

package ClassesAndObjects;

class Laptop {
    String brand;
    String model;
    int ram;
    double price;


    Laptop(String brand, String model, int ram, double price) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Price: ₹" + price);
        System.out.println();
    }
}

public class q4 {
    public static void main(String[] args) {

        Laptop laptop1 = new Laptop("Dell", "Inspiron 15", 8, 55000);
        Laptop laptop2 = new Laptop("HP", "Pavilion", 16, 70000);
        Laptop laptop3 = new Laptop("Lenovo", "LOQ", 16, 75000);

        laptop1.displayDetails();
        laptop2.displayDetails();
        laptop3.displayDetails();
    }
}
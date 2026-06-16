
// ============================================================ 

// E-COMMERCE PRODUCT MANAGEMENT SYSTEM 

// Demonstrates: Inheritance, super, @Override, final 

// ============================================================ 

// BASE CLASS (Parent) 
class Product { 

    private int productId; 
    private String name; 
    protected double basePrice; 
    final String CURRENCY = "Rs."; 

    Product(int id, String name, double price) { 
        this.productId = id; 
        this.name = name; 
        this.basePrice = price; 
    } 
    final double calculateTax() { 
        return basePrice * 0.18;
    } 
    double calculateDiscount() { 
        return 0;  
    } 
    final double getFinalPrice() { 
        return basePrice + calculateTax() - calculateDiscount(); 
    } 
    void displayProduct() { 
        System.out.println("\n--- Product Details ---"); 
        System.out.println("ID       : " + productId); 
        System.out.println("Name     : " + name); 
        System.out.println("Base     : " + CURRENCY + " " + basePrice); 
        System.out.println("Tax(18%) : " + CURRENCY + " " + calculateTax()); 
        System.out.println("Discount : " + CURRENCY + " " + calculateDiscount());
        System.out.println("Final    : " + CURRENCY + " " + getFinalPrice()); 
    } 
    int getProductId() { return productId; } 
    String getName() { return name; } 
} 

class Electronics extends Product { 

    String brand; 
    int warrantyMonths; 
    Electronics(int id, String name, double price, String brand, int warranty) { 
        super(id, name, price); 
        this.brand = brand; 
        this.warrantyMonths = warranty; 
    }
    @Override 
    double calculateDiscount() { 
        return basePrice * 0.10; 
    } 
    @Override 
    void displayProduct() { 
        super.displayProduct(); 
        System.out.println("Brand    : " + brand); 
        System.out.println("Warranty : " + warrantyMonths + " months"); 
    } 
} 

class Clothing extends Product { 
    String size; 
    String material; 
    Clothing(int id, String name, double price, String size, String material) { 
        super(id, name, price); 
        this.size = size; 
        this.material = material; 
    } 

    @Override 
    double calculateDiscount() { 
        return basePrice * 0.20;
    } 

    @Override 
    void displayProduct() { 
        super.displayProduct(); 
        System.out.println("Size     : " + size); 
        System.out.println("Material : " + material); 
    } 
} 

class Smartphone extends Electronics { 

    int ram; 
    int storage;
    Smartphone(int id, String name, double price, String brand, int warranty, int ram, int storage) { 
        super(id, name, price, brand, warranty); 
        this.ram = ram; 
        this.storage = storage; 
    } 

    @Override 
    double calculateDiscount() { 
        return super.calculateDiscount() + basePrice * 0.05; 
    } 
    @Override 
    void displayProduct() { 
        super.displayProduct();
        System.out.println("RAM      : " + ram + " GB"); 
        System.out.println("Storage  : " + storage + " GB"); 
    } 
} 


public class Ecommerce { 
    public static void main(String[] args) {  

        Electronics laptop = new Electronics(101, "Dell Laptop", 75000, "Dell", 12); 
        Clothing shirt = new Clothing( 202, "Cotton Shirt", 1200, "L", "100% Cotton"); 
        Smartphone phone = new Smartphone( 303, "Samsung Galaxy", 45000, "Samsung", 12, 8, 128); 

        laptop.displayProduct(); 
        shirt.displayProduct(); 
        phone.displayProduct(); 
            
        System.out.println("\n=== Price Summary ==="); 
        Product[] cart = { laptop, shirt, phone }; 
        double total = 0; 
        for (Product p : cart) { 

            System.out.printf("%s: Rs. %.2f%n", p.getName(), p.getFinalPrice()); 
            total += p.getFinalPrice(); 
        } 
        System.out.printf("Total Cart: Rs. %.2f%n", total); 
    } 
} 

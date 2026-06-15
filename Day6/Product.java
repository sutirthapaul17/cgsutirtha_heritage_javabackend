public class Product { 

    int id; 
    String name; 
    double price; 

    Product(int id, String name, double price) { 
        this.id = id; 
        this.name = name; 
        this.price = price; 
    } 

    // Overriding the default Object.toString() 
    @Override 
    public String toString() { 
        return "Product[ID=" + id + ", Name=" + name + ", Price=Rs." + price + "]"; 
    } 

    public static void main(String[] args) { 
        Product p1 = new Product(101, "Wireless Mouse", 799.0); 
        System.out.println(p1); 
        System.out.println("Receipt line -> " + p1); 

    } 

} 
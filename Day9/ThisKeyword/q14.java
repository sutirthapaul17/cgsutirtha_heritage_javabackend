package ThisKeyword;


class Product {
    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    void display() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }
}

public class q14 {
    public static void main(String[] args) {
        Product p = new Product(1, "Laptop", 65000);

        p.display();
    }
}